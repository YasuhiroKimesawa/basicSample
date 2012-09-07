package com.pilgrim_lifestyle.web.event.register;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pilgrim_lifestyle.model.event.Event;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

@Controller
@RequestMapping( "/events" )
@Secured( "ROLE_EVENTER" )
public class EventConfirmController
{
    private static final String EVENT = "event";

    private static final String DRAFT = "draft";

    @Autowired
    private OnetimeToken onetimeToken;

    @RequestMapping( value= "new", method = RequestMethod.POST, params="draft=yes" )
    @ResponseStatus( value = HttpStatus.SEE_OTHER )
    public String newConfirm( @Valid @ModelAttribute( EVENT ) Event event,
            BindingResult result, RedirectAttributes redirectAttributes,
            WebRequest request, Model model )
    {
        String draft = request.getParameter( DRAFT );

        if( result.hasErrors() )
        {
            model.addAttribute( EVENT, event );
            return "event/register/register";
        }

        request.setAttribute( EVENT, event, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( DRAFT, draft )
                          .addAttribute( DRAFT, draft );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.GET, params="draft=yes" )
    public String newConfirmRedirect( WebRequest request, Model model )
    {
        List<String> sessionList = Arrays.asList( request.getAttributeNames( RequestAttributes.SCOPE_SESSION ) );
        if( ! sessionList.contains( EVENT ) )
        {
            return "error/pageNotFound";
        }

        onetimeToken.initializeToken( request, model );
        return "event/register/confirm/confirm";
    }
}
