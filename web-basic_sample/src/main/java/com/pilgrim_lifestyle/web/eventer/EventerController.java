package com.pilgrim_lifestyle.web.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.service.eventer.EventerService;
import com.pilgrim_lifestyle.form.eventer.EventerForm;
import com.pilgrim_lifestyle.form.eventer.EventerFormDxo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;


@Controller
@RequestMapping( "/eventer" )
public class EventerController
{
    @Autowired
    private EventerService eventerService;

    @Autowired
    private EventerFormDxo eventerFormDxo;

    private static final String EVENTER = "eventer";

    @RequestMapping( value = "new", method = RequestMethod.GET )
    public String newEventer( WebRequest request, Model model )
    {
        EventerForm eventer = new EventerForm();

        model.addAttribute( EVENTER, eventer );
        return "eventer/register/register";
    }

    @RequestMapping( value= "", method = RequestMethod.POST )
    public String createEventer(
            @Valid @ModelAttribute( EVENTER ) EventerForm eventerForm,
            WebRequest request, Model model )
    {
        Eventer eventer = eventerFormDxo.convert( eventerForm );

        eventerService.add( eventer );

        return "redirect:/eventer/new";
    }
}
