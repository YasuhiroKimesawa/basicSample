package com.pilgrim_lifestyle.web.dashboard;

import com.pilgrim_lifestyle.web.tool.OnetimeToken;
import com.systemsekkei.base.security.web.login.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping( "/" )
public class DashBoardController
{
    @Autowired
    private OnetimeToken onetimeToken;

    private static final String DRAFT = "draft";

    static final String LOGIN_FORM_SESSION_NAME = LoginForm.class.getName();

    private String loginFormAttributeName = "loginForm";

    @RequestMapping( value = "", method = RequestMethod.GET )
    public String dashboard( WebRequest request, Model model )
    {
        onetimeToken.removeToken( request );
        request.removeAttribute( DRAFT, RequestAttributes.SCOPE_SESSION );

        LoginForm loginForm = loadAndRemoveFromSession( request );

        LoginForm preparedLoginForm = prepareShowLoginForm( loginForm, request );

        request.setAttribute(
                loginFormAttributeName, preparedLoginForm, WebRequest.SCOPE_REQUEST );

        return "dashboard/dashboard";
    }

    protected LoginForm prepareShowLoginForm(LoginForm loginForm, WebRequest request)
    {
        if (loginForm != null)
        {
            return loginForm;
        }

        return new LoginForm();
    }

    private static final LoginForm loadAndRemoveFromSession(WebRequest request)
    {
        LoginForm loginForm = (LoginForm) request.getAttribute(
                LOGIN_FORM_SESSION_NAME, WebRequest.SCOPE_SESSION);
        request.removeAttribute(
                LOGIN_FORM_SESSION_NAME, WebRequest.SCOPE_SESSION);
        return loginForm;
    }

    public void setLoginFormAttributeName(String loginFormAttributeName)
    {
        this.loginFormAttributeName = loginFormAttributeName;
    }
}
