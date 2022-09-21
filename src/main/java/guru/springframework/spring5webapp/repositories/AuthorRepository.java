package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

// Created a CRUD Repository for our Author class using the Long id (JPA Key)
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
