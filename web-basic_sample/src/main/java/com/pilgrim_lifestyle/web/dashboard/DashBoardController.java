package com.pilgrim_lifestyle.web.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping( "/" )
public class DashBoardController
{
    @RequestMapping( value = "", method = RequestMethod.GET )
    public String dashboard( WebRequest request, Model model )
    {
        return "dashboard/dashboard";
    }
}
