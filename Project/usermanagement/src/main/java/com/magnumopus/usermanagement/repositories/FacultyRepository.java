package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

}
