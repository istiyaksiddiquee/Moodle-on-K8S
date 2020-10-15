package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
