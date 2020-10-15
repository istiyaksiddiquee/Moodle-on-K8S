package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

//    List<User> findByNameNamedOrmXml(@Param("name") String name);
//
    List<User> findByUserNameNamedNativeOrmXml(@Param("user_name") String userName);
//
//    @Query(nativeQuery = true)
//    List<User> findByNameNamedNative(@Param("name") String name);
//
//    List<User> findByNameNamed(@Param("name") String name);
}
