package com.pilgrim_lifestyle.web.eventer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping( "/" )
public class EventerController
{
    @RequestMapping( value = "", method = RequestMethod.GET )
    public String getEventer( WebRequest request, Model model )
    {
        return "eventer/register/register";
    }
}
