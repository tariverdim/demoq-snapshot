package com.example.demoq.repository;

import com.example.demoq.model.data.ActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorEntityRepository extends CrudRepository<ActorEntity,Long> {


    Iterable<ActorEntity> findByLastNameIsLike(String sl);

    Iterable<ActorEntity> findByfirstNameIsLike(String sf);
}
