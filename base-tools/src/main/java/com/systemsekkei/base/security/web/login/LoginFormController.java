package com.systemsekkei.base.security.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginFormController
{
    static final String LOGIN_FORM_SESSION_NAME = LoginForm.class.getName();

    private String loginFormAttributeName = "loginForm";

    private String viewName = "loginForm";

    @RequestMapping
    public String showLoginForm(WebRequest request)
    {
        LoginForm loginForm = loadAndRemoveFromSession( request );

        LoginForm preparedLoginForm = prepareShowLoginForm( loginForm, request );

        request.setAttribute(
            loginFormAttributeName, preparedLoginForm, WebRequest.SCOPE_REQUEST );

        return viewName;
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

    public void setViewName(String viewName)
    {
        this.viewName = viewName;
    }
}
