package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.GroupUserMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserMappingRepository extends CrudRepository<GroupUserMapping, Integer> {

}
