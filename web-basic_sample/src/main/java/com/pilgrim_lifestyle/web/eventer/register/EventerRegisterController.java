package com.pilgrim_lifestyle.web.eventer.register;

import java.util.Arrays;
import java.util.List;

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

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.service.account.RegisterAccountService;
import com.pilgrim_lifestyle.web.tool.BadTokenException;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

@Controller
@RequestMapping( "/eventers" )
@Secured({"ROLE_ANONYMOUS", "ROLE_ADMIN"})
public class EventerRegisterController
{
    @Autowired
    private RegisterAccountService registerAccountService;

    @Autowired
    private OnetimeToken onetimeToken;

    private static final String EVENTER = "eventer";

    private static final String DRAFT = "draft";

    @RequestMapping( value= "new", method = RequestMethod.POST, params="draft=no" )
    @ResponseStatus( value = HttpStatus.SEE_OTHER )
    public String newRegister( WebRequest request, Model model, RedirectAttributes redirectAttributes ) throws BadTokenException
    {
        onetimeToken.checkToken( request );

        String draft = request.getParameter( DRAFT );

        Eventer eventer = ( Eventer ) request.getAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );

        registerAccountService.register( eventer );

        request.removeAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( DRAFT, draft )
                          .addAttribute( DRAFT, draft );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.GET, params="draft=no" )
    public String newRegisterRedirect( WebRequest request, Model model )
    {
        List<String> sessionList = Arrays.asList( request.getAttributeNames( RequestAttributes.SCOPE_SESSION ) );
        if( ! onetimeToken.isContain( request ) ||  sessionList.contains( EVENTER )  )
        {
            return "error/pageNotFound";
        }

        return "eventer/register/completion/completion";
    }
}
