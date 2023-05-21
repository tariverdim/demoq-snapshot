package com.example.demoq.UserDetailsService;

import com.example.demoq.model.FilmEntity;
import com.example.demoq.model.data.FilmActorEntity;
import com.example.demoq.repository.ActorEntityRepository;
import com.example.demoq.repository.FilmActorEntityRepository;
import com.example.demoq.repository.FilmEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FilmService {

    private ActorEntityRepository actorEntityRepository;
    private FilmActorEntityRepository filmActorEntityRepository;
    private FilmEntityRepository filmEntityRepository;


    public FilmService(ActorEntityRepository actorEntityRepository, FilmActorEntityRepository filmActorEntityRepository, FilmEntityRepository filmEntityRepository) {

        this.actorEntityRepository = actorEntityRepository;
        this.filmActorEntityRepository = filmActorEntityRepository;
        this.filmEntityRepository = filmEntityRepository;
    }

    public Iterable<FilmEntity> filmsListById(Iterable<Long> ids) {

        return filmEntityRepository.findAllById(ids);

    }

    public Iterable<FilmEntity> fetchFilm() {
        return filmEntityRepository.findAll();
    }


    public Optional<FilmEntity> fetchfilmbyid(Long id){
        return filmEntityRepository.findByfilmId(id);
    }


    public Iterable<FilmActorEntity> fetchFilmActorAll() {
        return filmActorEntityRepository.findAll();
    }

 public Iterable<FilmEntity> fetchAllFilms() {
        return filmEntityRepository.findAll();
 }

    public Iterable<FilmActorEntity> filmsPlayedByID(Long id) {
        return filmActorEntityRepository.findAllByactorId(id);
    }
}