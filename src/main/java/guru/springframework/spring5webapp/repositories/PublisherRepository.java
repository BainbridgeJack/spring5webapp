package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

// Create a CRUD Repository for our Publisher Class using the JPA Key.
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
