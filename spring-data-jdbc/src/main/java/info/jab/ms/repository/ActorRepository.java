package info.jab.ms.repository;

import info.jab.ms.model.Actor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends ListCrudRepository<Actor, Long> { }
