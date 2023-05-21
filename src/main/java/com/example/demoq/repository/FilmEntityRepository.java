package com.example.demoq.repository;

import com.example.demoq.model.FilmEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmEntityRepository extends CrudRepository<FilmEntity,Long> {

    Optional<FilmEntity> findByfilmId(Long id);
}
