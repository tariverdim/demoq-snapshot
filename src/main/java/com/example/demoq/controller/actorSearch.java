package com.example.demoq.controller;

import com.example.demoq.UserDetailsService.ActorEntityService;
import com.example.demoq.UserDetailsService.FilmService;
import com.example.demoq.model.FilmEntity;
import com.example.demoq.model.FormQuery;
import com.example.demoq.model.data.FilmActorEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class actorSearch {

    private ActorEntityService actorEntityService;
    private FilmService filmService;

    public actorSearch(ActorEntityService actorEntityService, FilmService filmService) {
        this.actorEntityService = actorEntityService;
        this.filmService = filmService;
    }

    @GetMapping("/actor")
    public String one(Model model){
        model.addAttribute("FQ",new FormQuery());

        return "actor";
    }

    @PostMapping("/actor")
    public ModelAndView two(@ModelAttribute("FQ") FormQuery formQuery) {

        ModelAndView modelAndView = new ModelAndView("resultActor");


        if((formQuery.getFirstName() == "") && (formQuery.getLastName() == "")) {

            modelAndView.addObject("select", new FormQuery());
            modelAndView.addObject("resultList", actorEntityService.fetchData());
            return modelAndView;

        }else if((formQuery.getFirstName() == "") && (formQuery.getLastName() != "")){
            modelAndView.addObject("select", new FormQuery());
            modelAndView.addObject("resultList", actorEntityService.fetchData(formQuery.getLastName()));
            return modelAndView;


        }else if((formQuery.getFirstName() != "") && (formQuery.getLastName() == "")){
            modelAndView.addObject("select", new FormQuery());
            modelAndView.addObject("resultList", actorEntityService.fetchData(formQuery.getFirstName(),""));
            return modelAndView;

        }else if ((formQuery.getFirstName() != "") && (formQuery.getLastName() != "")){
            modelAndView.addObject("select", new FormQuery());
            modelAndView.addObject("resultList", actorEntityService.fetchData(formQuery.getFirstName(),""));
            return modelAndView;

        }

        // TODO search Query conditional firstname
        return new ModelAndView("errorDb");
    }


    @PostMapping("/ado")
    public ModelAndView ado_post(@ModelAttribute("FQ") FormQuery formQuery) {

        ModelAndView modelAndView = new ModelAndView("ado");

        if(formQuery.getId() == null){
            formQuery.setValueOne("false");
            modelAndView.addObject("select", formQuery);
            return modelAndView;
        }

        if(formQuery.getValueOne() == null){
            formQuery.setValueOne("false");
            modelAndView.addObject("select", formQuery);
            return modelAndView;
        }


        //Film query
        if(formQuery.getValueOne().equals("film")){

            //formQuery.setValueOne("film");

            Iterable<FilmActorEntity> fe = filmService.fetchFilmActorAll();

            Iterator<FilmActorEntity> fei = fe.iterator();

            List<FilmEntity> io = new ArrayList<>();

            FilmActorEntity id = null;


            while(fei.hasNext()){

                id = fei.next();

                if(id.getActorId() == formQuery.getId()){

                    io.add(filmService.fetchfilmbyid(id.getFilmId()).get());
                }
            }


            formQuery.setFirstName(actorEntityService.findById(formQuery.getId()).get().getFirstName());
            formQuery.setLastName(actorEntityService.findById(formQuery.getId()).get().getLastName());


            modelAndView.addObject("filmEntity", io);

            modelAndView.addObject("select", formQuery);

            System.out.println(formQuery.getValueOne());

            return modelAndView;
        }

        //For Delete operation
        if(formQuery.getId() != null){
            System.out.println(formQuery.getValueOne());

            if(formQuery.getValueOne().equals("delete")){
                System.out.println(formQuery.getId());

                modelAndView.addObject("entityName", actorEntityService.findById(formQuery.getId()).get());

                actorEntityService.deleteRecord(formQuery.getId());
                modelAndView.addObject("select", formQuery);

                return modelAndView;

            }

            if(formQuery.getValueOne().equals("info")){
                System.out.println("Section Query began!!!");
                formQuery.setValueOne("info");


                modelAndView.addObject("entityName", actorEntityService.fetchData());
                modelAndView.addObject("select", formQuery);
//              Iterable<FilmActorEntity> fa = filmService.filmsPlayedByID(formQuery.getId());

                return modelAndView;
            }
        }
        //add new Actor Film

        if(formQuery.getValueOne().equals("add")){

            ModelAndView modelAdd = new ModelAndView("add");

            modelAdd.addObject("select", formQuery);
            formQuery.setValueOne("add");
            return modelAdd;

        }



        return new ModelAndView("errorDb");
    }
}
