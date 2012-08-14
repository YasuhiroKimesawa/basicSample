package com.pilgrim_lifestyle.web.dashboard;

import com.pilgrim_lifestyle.web.tool.OnetimeToken;

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

    @RequestMapping( value = "", method = RequestMethod.GET )
    public String dashboard( WebRequest request, Model model )
    {
        onetimeToken.removeToken( request );
        request.removeAttribute( DRAFT, RequestAttributes.SCOPE_SESSION );

        return "dashboard/dashboard";
    }
}
