package edu.uh.tech.cis3368.manufacture.repository;

import edu.uh.tech.cis3368.manufacture.Customerss;
import org.springframework.data.repository.CrudRepository;

public interface CustomerssRepository extends CrudRepository<Customerss, Integer> {
    Customerss findByCustomerId(Integer customerid);
}
