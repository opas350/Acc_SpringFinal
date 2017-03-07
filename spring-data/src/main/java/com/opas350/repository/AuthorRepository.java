package com.opas350.repository;

import com.opas350.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by javier.reyes.valdez on 3/6/2017.
 */
public interface AuthorRepository extends JpaRepository<Author, Integer>, CrudRepository<Author, Integer> {
}
