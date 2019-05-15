package bjtu.edu.javaee.a2.repository;

import bjtu.edu.javaee.a2.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="user")
public interface UserRepository extends CrudRepository<User , Integer>{
}
