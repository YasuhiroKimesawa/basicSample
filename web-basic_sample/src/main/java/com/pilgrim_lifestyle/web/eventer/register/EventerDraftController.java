package com.pilgrim_lifestyle.web.eventer.register;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerFactory;
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
@RequestMapping( "/eventers" )
@Secured({"ROLE_ANONYMOUS", "ROLE_ADMIN"})
public class EventerDraftController
{
    @Autowired
    private EventerFactory eventerFactory;

    @Autowired
    private OnetimeToken onetimeToken;

    private static final String EVENTER = "eventer";

    @RequestMapping( value = "new", method = RequestMethod.GET )
    public String newEventer( WebRequest request, Model model, RedirectAttributes redirectAttributes )
    {
        if( model.containsAttribute( EVENTER ) )
        {
            return "eventer/register/register";
        }

        request.removeAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );
        onetimeToken.removeToken( request );

        Eventer eventer = eventerFactory.createDraft();

        model.addAttribute( EVENTER, eventer );

        return "eventer/register/register";
    }
}
