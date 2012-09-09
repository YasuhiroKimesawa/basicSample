package com.pilgrim_lifestyle.web.event.register;

import com.pilgrim_lifestyle.model.event.Event;
import com.pilgrim_lifestyle.service.event.RegisterEventService;
import com.pilgrim_lifestyle.web.tool.BadTokenException;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping( "/events" )
@Secured( "ROLE_EVENTER" )
public class EventRegisterController
{
    @Autowired
    private RegisterEventService registerEventService;

    @Autowired
    private OnetimeToken onetimeToken;

    private static final String EVENT = "event";

    private static final String DRAFT = "draft";

    @RequestMapping( value= "new", method = RequestMethod.POST, params="draft=no" )
    @ResponseStatus( value = HttpStatus.SEE_OTHER )
    public String newRegister( WebRequest request, Model model, RedirectAttributes redirectAttributes ) throws BadTokenException
    {
        onetimeToken.checkToken( request );

        String draft = request.getParameter( DRAFT );

        Event event = ( Event ) request.getAttribute( EVENT, RequestAttributes.SCOPE_SESSION );

        registerEventService.register( event );

        request.removeAttribute( EVENT, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( DRAFT, draft )
                          .addAttribute( DRAFT, draft );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.GET, params="draft=no" )
    public String newRegisterRedirect( WebRequest request, Model model )
    {
        List<String> sessionList = Arrays.asList( request.getAttributeNames( RequestAttributes.SCOPE_SESSION ) );
        if( ! onetimeToken.isContain( request ) ||  sessionList.contains( EVENT )  )
        {
            return "error/pageNotFound";
        }

        return "event/register/completion/completion";
    }

}
