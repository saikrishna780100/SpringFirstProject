package sai.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sai.springframework.webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
