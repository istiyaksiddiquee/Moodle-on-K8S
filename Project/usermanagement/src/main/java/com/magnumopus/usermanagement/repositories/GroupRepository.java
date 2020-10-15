package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

}
