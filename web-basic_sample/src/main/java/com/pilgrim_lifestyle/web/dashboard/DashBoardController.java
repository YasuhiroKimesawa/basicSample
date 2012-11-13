package com.pilgrim_lifestyle.web.dashboard;

import com.pilgrim_lifestyle.model.event.EventRepository;
import com.pilgrim_lifestyle.security.model.LoginForm;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping( value = "" )
@Secured( {"ROLE_ANONYMOUS", "ROLE_EVENTER", "ROLE_ADMIN"} )
public class DashBoardController
{
    @Autowired
    private OnetimeToken onetimeToken;

    private static final String DRAFT = "draft";

    static final String ACCOUNT_SESSION_NAME = LoginForm.class.getName();

    private String loginFormAttributeName = "loginForm";

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping( value = "" )
    public String dashboard( WebRequest request, Model model )
    {
        onetimeToken.removeToken( request );
        request.removeAttribute( DRAFT, RequestAttributes.SCOPE_SESSION );

        LoginForm loginForm = loadAndRemoveFromSession( request );

        LoginForm preparedAccount = prepareShowLoginForm( loginForm, request );

        request.setAttribute( loginFormAttributeName, preparedAccount, WebRequest.SCOPE_REQUEST );

        eventRepository.list();

        return "dashboard/dashboard";
    }

    protected LoginForm prepareShowLoginForm( LoginForm loginForm, WebRequest request )
    {
        if ( loginForm != null )
        {
            return loginForm;
        }

        return new LoginForm();
    }

    private static final LoginForm loadAndRemoveFromSession( WebRequest request )
    {
        LoginForm loginForm = ( LoginForm ) request.getAttribute( ACCOUNT_SESSION_NAME, WebRequest.SCOPE_SESSION );

        request.removeAttribute( ACCOUNT_SESSION_NAME, WebRequest.SCOPE_SESSION );

        return loginForm;
    }

    public void setAccountAttributeName( String accountAttributeName )
    {
        this.loginFormAttributeName = accountAttributeName;
    }

}
