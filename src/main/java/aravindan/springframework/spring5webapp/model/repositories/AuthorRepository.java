package aravindan.springframework.spring5webapp.model.repositories;

import org.springframework.data.repository.CrudRepository;

import aravindan.springframework.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
