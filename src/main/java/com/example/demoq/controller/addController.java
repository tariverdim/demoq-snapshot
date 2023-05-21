package com.example.demoq.controller;


import com.example.demoq.UserDetailsService.ActorEntityService;
import com.example.demoq.model.FilmEntity;
import com.example.demoq.model.FormQuery;
import com.example.demoq.model.data.ActorEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Controller
@RequestMapping
public class addController {

    private ActorEntityService actorEntityService;

    public addController(ActorEntityService actorEntityService) {
        this.actorEntityService = actorEntityService;
    }

    @GetMapping("/add")
    public ModelAndView addActorGet() {
        ModelAndView modelAdd = new ModelAndView("add");

        modelAdd.addObject("select", new FormQuery());

        return modelAdd;

    }


    @PostMapping("/add")
    public ModelAndView addActor(@ModelAttribute("select") FormQuery formQuery){

        ModelAndView modelAndView = new ModelAndView("add");

        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setFirstName(formQuery.getFirstName());
        actorEntity.setLastName(formQuery.getLastName());
        actorEntity.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        actorEntityService.addActor(actorEntity);

        modelAndView.addObject("recorded","true");
        modelAndView.addObject("f",formQuery.getFirstName());
        modelAndView.addObject("l",formQuery.getLastName());


        return modelAndView;
    }

}
