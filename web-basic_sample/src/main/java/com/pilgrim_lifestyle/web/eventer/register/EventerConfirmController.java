package com.pilgrim_lifestyle.web.eventer.register;

import com.pilgrim_lifestyle.model.account.AccountPolicy;
import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

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

@Controller
@RequestMapping( "/eventers" )
@Secured({"ROLE_ANONYMOUS", "ROLE_ADMIN"})
public class EventerConfirmController
{
    @Autowired
    private AccountPolicy accountPolicy;

    @Autowired
    private OnetimeToken onetimeToken;

    private static final String EVENTER = "eventer";

    private static final String DRAFT = "draft";

    @RequestMapping( value= "new", method = RequestMethod.POST, params="draft=yes" )
    @ResponseStatus( value = HttpStatus.SEE_OTHER )
    public String newConfirm( @Valid @ModelAttribute( EVENTER ) Eventer eventer,
            BindingResult result, RedirectAttributes redirectAttributes,
            WebRequest request, Model model )
    {
        String draft = request.getParameter( DRAFT );

        accountPolicy.validate( eventer, result );

        if( result.hasErrors() )
        {
            model.addAttribute( EVENTER, eventer );
            return "eventer/register/register";
        }

        request.setAttribute( EVENTER, eventer, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( DRAFT, draft )
                          .addAttribute( DRAFT, draft );

        return "redirect:new";
    }

    @RequestMapping( value= "new", method = RequestMethod.GET, params="draft=yes" )
    public String newConfirmRedirect( WebRequest request, Model model )
    {
        List<String> sessionList = Arrays.asList( request.getAttributeNames( RequestAttributes.SCOPE_SESSION ) );
        if( ! sessionList.contains( EVENTER ) )
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
        Eventer eventer = ( Eventer ) request.getAttribute( EVENTER, RequestAttributes.SCOPE_SESSION );

        redirectAttributes.addFlashAttribute( EVENTER, eventer );

        return "redirect:new";
    }

}
