package com.pilgrim_lifestyle.web.dashboard;

import com.pilgrim_lifestyle.security.model.Account;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping( value = "" )
public class DashBoardController
{
    @Autowired
    private OnetimeToken onetimeToken;

    private static final String DRAFT = "draft";

    static final String ACCOUNT_SESSION_NAME = Account.class.getName();

    private String accountAttributeName = "account";

    @RequestMapping( value = "" )
    public String dashboard( WebRequest request, Model model )
    {
        onetimeToken.removeToken( request );
        request.removeAttribute( DRAFT, RequestAttributes.SCOPE_SESSION );

        Account account = loadAndRemoveFromSession( request );

        Account preparedAccount = prepareShowLoginForm( account, request );

        request.setAttribute( accountAttributeName, preparedAccount, WebRequest.SCOPE_REQUEST );

        return "dashboard/dashboard";
    }

    protected Account prepareShowLoginForm( Account account, WebRequest request )
    {
        if ( account != null )
        {
            return account;
        }

        return new Account();
    }

    private static final Account loadAndRemoveFromSession( WebRequest request )
    {
        Account account = ( Account ) request.getAttribute( ACCOUNT_SESSION_NAME, WebRequest.SCOPE_SESSION );

        request.removeAttribute( ACCOUNT_SESSION_NAME, WebRequest.SCOPE_SESSION );

        return account;
    }

    public void setAccountAttributeName( String accountAttributeName )
    {
        this.accountAttributeName = accountAttributeName;
    }

}
