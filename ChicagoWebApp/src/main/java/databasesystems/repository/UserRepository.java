package databasesystems.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import databasesystems.domain.MyUser;

@Repository
public interface UserRepository extends CrudRepository<MyUser, String> {

}
