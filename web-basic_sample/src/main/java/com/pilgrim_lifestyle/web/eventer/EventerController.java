package com.pilgrim_lifestyle.web.eventer;

import java.util.Arrays;
import java.util.List;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.RegisterEventerPolicy;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;
import com.pilgrim_lifestyle.service.eventer.EventerService;
import com.pilgrim_lifestyle.web.tool.BadTokenException;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;
import com.pilgrim_lifestyle.form.eventer.EventerForm;
import com.pilgrim_lifestyle.form.eventer.EventerDxo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping( "/eventers" )
public class EventerController
{
    @Autowired
    private EventerService eventerService;

    @Autowired
    private RegisterEventerPolicy registerEventerPolicy;

    @Autowired
    private EventerDxo eventerDxo;

    @Autowired
    private OnetimeToken onetimeToken;

    @Autowired
    private Validator validator;

    private static final String EVENTER_FORM = "eventerForm";

    private static final String DRAFT = "draft";

    @RequestMapping( value = "new", method = RequestMethod.GET )
    public String newEventer( WebRequest request, Model model, RedirectAttributes redirectAttributes )
    {
        if( model.containsAttribute( EVENTER_FORM ) )
        {
            return "eventer/register/register";
        }

        request.removeAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );
        onetimeToken.removeToken( request );

        EventerForm eventerForm = new EventerForm();

        model.addAttribute( EVENTER_FORM, eventerForm );

        return "eventer/register/register";
    }

    @RequestMapping( value= "new", method = RequestMethod.POST, params="draft=yes" )
    @ResponseStatus( value = HttpStatus.SEE_OTHER )
    public String newConfirm( @Valid @ModelAttribute( EVENTER_FORM ) EventerForm eventerForm,
            BindingResult result, RedirectAttributes redirectAttributes,
            WebRequest request, Model model )
    {
        String draft = request.getParameter( DRAFT );

        Eventer eventer = eventerDxo.fromDTO( eventerForm );

        validator.validate( eventer, result );
        registerEventerPolicy.validate( eventer, result );

        if( result.hasErrors() )
        {
            model.addAttribute( EVENTER_FORM, eventerForm );
            return "eventer/register/register";
        }

        request.setAttribute( EVENTER_FORM, eventerForm, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( DRAFT, draft )
                          .addAttribute( DRAFT, draft );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.GET, params="draft=yes" )
    public String newConfirmRedirect( WebRequest request, Model model )
    {
        List<String> sessionList = Arrays.asList( request.getAttributeNames( RequestAttributes.SCOPE_SESSION ) );
        if( ! sessionList.contains( EVENTER_FORM ) )
        {
            return "error/pageNotFound";
        }

        onetimeToken.initializeToken( request, model );
        return "eventer/register/confirm/confirm";
    }

    @RequestMapping( value="new", method = RequestMethod.PUT, params="draft=yes" )
    @ResponseStatus( value = HttpStatus.SEE_OTHER )
    public String newModify( WebRequest request, Model model, RedirectAttributes redirectAttributes )
    {
        EventerForm eventerForm = (EventerForm) request.getAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( EVENTER_FORM, eventerForm );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.POST, params="draft=no" )
    @ResponseStatus( value = HttpStatus.SEE_OTHER )
    public String newRegister( WebRequest request, Model model, RedirectAttributes redirectAttributes ) throws BadTokenException
    {
        onetimeToken.checkToken( request );

        String draft = request.getParameter( DRAFT );

        EventerForm eventerForm = (EventerForm) request.getAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );

        Contact contact = eventerDxo.fromContactDTO( eventerForm.getContact() );
        Profile profile = eventerDxo.fromProfileDTO( eventerForm.getProfile() );
        Passwords passwords = eventerDxo.fromPasswordsDTO( eventerForm.getPasswords() );

        eventerService.add( contact, profile, passwords );

        request.removeAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( DRAFT, draft )
                          .addAttribute( DRAFT, draft );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.GET, params="draft=no" )
    public String newRegisterRedirect( WebRequest request, Model model )
    {
        List<String> sessionList = Arrays.asList( request.getAttributeNames( RequestAttributes.SCOPE_SESSION ) );
        if( ! onetimeToken.isContain( request ) ||  sessionList.contains( EVENTER_FORM )  )
        {
            return "error/pageNotFound";
        }

        return "eventer/register/completion/completion";
    }
}
