package com.pilgrim_lifestyle.web.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;
import com.pilgrim_lifestyle.service.eventer.EventerService;
import com.pilgrim_lifestyle.web.WebBase;
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
    private EventerDxo eventerDxo;

    @Autowired
    private WebBase webBase;

    @Autowired
    private Validator validator;

    private static final String EVENTER_FORM = "eventerForm";

    private static final String DRAFT = "draft";

    @RequestMapping( value = "new", method = RequestMethod.GET )
    public String newEventer( WebRequest request, Model model )
    {
        webBase.initializeToken( request, model );

        if( request.getAttribute( DRAFT, RequestAttributes.SCOPE_SESSION ) == "yes" )
        {
            return this.newConfirmRedirect( request, model );
        }

        if( request.getAttribute( DRAFT, RequestAttributes.SCOPE_SESSION ) == "no" )
        {
            return this.newRegisterRedirect( request, model );
        }

        if( model.containsAttribute( EVENTER_FORM ) )
        {
            return "eventer/register/register";
        }

        request.removeAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );

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
        Eventer eventer = eventerDxo.fromDTO( eventerForm );

        validator.validate( eventer, result );

        if( result.hasErrors() )
        {
            model.addAttribute( EVENTER_FORM, eventerForm );
            return "eventer/register/register";
        }

        request.setAttribute( EVENTER_FORM, eventerForm, RequestAttributes.SCOPE_SESSION );
        request.setAttribute( DRAFT, "yes", RequestAttributes.SCOPE_SESSION );

        return "redirect:new";
    }

    private String newConfirmRedirect( WebRequest request, Model model )
    {
        return "eventer/register/confirm/confirm";
    }

    @RequestMapping( value="new", method = RequestMethod.PUT, params="draft=yes" )
    public String newModify( WebRequest request, Model model, RedirectAttributes redirectAttributes )
    {
        EventerForm eventerForm = (EventerForm) request.getAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( EVENTER_FORM, eventerForm );

        request.removeAttribute( DRAFT, RequestAttributes.SCOPE_SESSION );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.POST, params="draft=no" )
    public String newRegister( WebRequest request, Model model )
    {
        EventerForm eventerForm = (EventerForm) request.getAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );

        Contact contact = eventerDxo.fromContactDTO( eventerForm.getContact() );
        Profile profile = eventerDxo.fromProfileDTO( eventerForm.getProfile() );
        Passwords passwords = eventerDxo.fromPasswordsDTO( eventerForm.getPasswords() );

        eventerService.add( contact, profile, passwords );

        request.removeAttribute( EVENTER_FORM, RequestAttributes.SCOPE_SESSION );
        request.setAttribute( DRAFT, "no", RequestAttributes.SCOPE_SESSION );

        return "redirect:new";
    }

    private String newRegisterRedirect( WebRequest request, Model model )
    {
        return "eventer/register/completion/completion";
    }
}
