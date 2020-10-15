package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
