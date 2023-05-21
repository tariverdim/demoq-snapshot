package com.example.demoq.UserDetailsService;

import com.example.demoq.model.data.ActorEntity;
import com.example.demoq.repository.ActorEntityRepository;
import com.example.demoq.repository.FilmActorEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class ActorEntityService {

    private ActorEntityRepository actorEntityRepository;
    private FilmActorEntityRepository filmActorEntityRepository;

//    public ActorEntityService() {
//    }

    public ActorEntityService(ActorEntityRepository actorEntityRepository, FilmActorEntityRepository filmActorEntityRepository) {
        this.actorEntityRepository = actorEntityRepository;
        this.filmActorEntityRepository = filmActorEntityRepository;
    }

    public Iterable<ActorEntity> fetchData() {
        return actorEntityRepository.findAll();
    }

    public Iterable<ActorEntity> fetchData(String sl) {
        return actorEntityRepository.findByLastNameIsLike(sl);
    }

    public Iterable<ActorEntity> fetchData(String sf,String a) {
        return actorEntityRepository.findByfirstNameIsLike(sf);
    }

    public void deleteRecord(Long id) {

        actorEntityRepository.deleteById(id);
    }

    public Optional<ActorEntity> findById(Long id){
        return actorEntityRepository.findById(id);
    }

    public void addActor(ActorEntity actorEntity) {

        actorEntityRepository.save(actorEntity);
    }


}
