package com.pilgrim_lifestyle.web.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pilgrim_lifestyle.web.dashboard.LoginForm;

public class LoginFormAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler
{
    protected String usernameParameterName
        = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

    protected String passwordParameterName
        = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY;

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception ) throws IOException,
            ServletException
    {
        LoginForm loginForm = createLoginForm( request, response, exception );
        saveToSession( loginForm, request );

        super.onAuthenticationFailure( request, response, exception );
    }

    protected LoginForm createLoginForm(
            HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception )
    {
        String username = request.getParameter( usernameParameterName );
        String password = request.getParameter( passwordParameterName );

        return new LoginForm( username, password );
    }

    private static void saveToSession(
            LoginForm loginForm, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.setAttribute( DashBoardController.LOGIN_FORM_SESSION_NAME, loginForm );
    }

    public void setUsernameParameterName( String usernameParameterName )
    {
        this.usernameParameterName = usernameParameterName;
    }

    public void setPasswordParameterName( String passwordParameterName )
    {
        this.passwordParameterName = passwordParameterName;
    }
}
