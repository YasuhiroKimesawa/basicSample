package com.pilgrim_lifestyle.web.event.register;

import com.pilgrim_lifestyle.model.event.Event;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping( "/events" )
@Secured( "ROLE_EVENTER" )
public class EventDraftController
{
    private static final String EVENT = "event";

    @Autowired
    private OnetimeToken onetimeToken;

    @RequestMapping( value = "new", method = RequestMethod.GET )
    public String newEventer( WebRequest request, Model model, RedirectAttributes redirectAttributes )
    {
        if( model.containsAttribute( EVENT ) )
        {
            return "event/register/register";
        }

        request.removeAttribute( EVENT, RequestAttributes.SCOPE_SESSION );
        onetimeToken.removeToken( request );

        Event event = Event.draft();

        model.addAttribute( EVENT, event );

        return "event/register/register";
    }
}
