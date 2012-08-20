package com.pilgrim_lifestyle.web.dashboard;

import com.pilgrim_lifestyle.security.service.UserDetailsService;
import com.pilgrim_lifestyle.web.tool.OnetimeToken;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
public class DashBoardController
{
    @Autowired
    private OnetimeToken onetimeToken;

    private static final String DRAFT = "draft";

    @RequestMapping( value = "dashboard" )
    public String dashboard( WebRequest request, Model model )
    {
        logger.info(  "dashboard start" );
        onetimeToken.removeToken( request );
        request.removeAttribute( DRAFT, RequestAttributes.SCOPE_SESSION );

        logger.info(  "dashboard end" );
        return "dashboard/dashboard";
    }

    private static Logger logger= Logger.getLogger( UserDetailsService.class );
}
