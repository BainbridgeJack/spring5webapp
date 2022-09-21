package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

// Created a CRUD Repository for our Book class using the Long id (JPA Key)
public interface BookRepository extends CrudRepository<Book, Long> {
}
