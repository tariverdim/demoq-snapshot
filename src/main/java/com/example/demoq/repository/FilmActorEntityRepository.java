package com.example.demoq.repository;

import com.example.demoq.model.data.FilmActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorEntityRepository extends CrudRepository<FilmActorEntity,Long> {


    Iterable<FilmActorEntity> findAllByfilmId(Long id);

    Iterable<FilmActorEntity> findAllByactorId(Long id);
}
