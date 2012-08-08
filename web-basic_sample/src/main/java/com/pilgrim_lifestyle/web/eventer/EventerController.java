package com.pilgrim_lifestyle.web.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;
import com.pilgrim_lifestyle.service.eventer.EventerService;
import com.pilgrim_lifestyle.form.eventer.EventerForm;
import com.pilgrim_lifestyle.form.eventer.EventerDxo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping( "/eventer" )
public class EventerController
{
    @Autowired
    private EventerService eventerService;

    @Autowired
    private EventerDxo eventerDxo;

    @Autowired
    private Validator validator;

    private static final String EVENTER = "eventer";

    @RequestMapping( value = "new", method = RequestMethod.GET )
    public String newEventer( WebRequest request, Model model )
    {
        request.removeAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );

        EventerForm eventer = new EventerForm();

        model.addAttribute( EVENTER, eventer );

        return "eventer/register/register";
    }

    @RequestMapping( value= "", method = RequestMethod.POST, params="draft=yes" )
    public String confirmEventer(
            @Valid @ModelAttribute( EVENTER ) EventerForm eventerForm,
            BindingResult result,
            WebRequest request, Model model )
    {
        Eventer eventer = eventerDxo.fromDTO( eventerForm );

        validator.validate( eventer, result );

        if( result.hasErrors() )
        {
            model.addAttribute( EVENTER, eventerForm );
            return "eventer/register/register";
        }

        request.setAttribute( EVENTER, eventerForm, RequestAttributes.SCOPE_SESSION );

        return "eventer/register/confirm/confirm";
    }

    @RequestMapping( value="", method = RequestMethod.PUT, params="draft=yes" )
    public String backNewEventer( WebRequest request, Model model )
    {
        EventerForm eventerForm = (EventerForm) request.getAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );

        model.addAttribute( EVENTER, eventerForm );

        return "eventer/register/register";
    }

    @RequestMapping( value= "", method = RequestMethod.POST, params="draft=no" )
    public String registerEventer( WebRequest request, Model model )
    {
        EventerForm eventerForm = (EventerForm) request.getAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );

        Contact contact = eventerDxo.fromContactDTO( eventerForm.getContact() );
        Profile profile = eventerDxo.fromProfileDTO( eventerForm.getProfile() );
        Passwords passwords = eventerDxo.fromPasswordsDTO( eventerForm.getPasswords() );

        eventerService.add( contact, profile, passwords );

        request.removeAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );

        return "eventer/register/completion/completion";
    }
}
