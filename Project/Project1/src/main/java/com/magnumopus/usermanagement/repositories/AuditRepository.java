package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.Audit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Integer> {

}
