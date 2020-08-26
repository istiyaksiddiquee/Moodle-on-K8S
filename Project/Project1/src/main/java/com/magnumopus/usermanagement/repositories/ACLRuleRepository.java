package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.ACLRule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ACLRuleRepository extends CrudRepository<ACLRule, Integer> {

}
