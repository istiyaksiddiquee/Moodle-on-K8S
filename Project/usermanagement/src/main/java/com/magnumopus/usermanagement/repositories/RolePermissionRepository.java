package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.RolePermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends CrudRepository<RolePermission, Integer> {

}
