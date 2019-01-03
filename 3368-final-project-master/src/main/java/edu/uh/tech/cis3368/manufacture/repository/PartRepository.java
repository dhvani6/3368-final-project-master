
package edu.uh.tech.cis3368.manufacture.repository;

import edu.uh.tech.cis3368.manufacture.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part,Integer> {
    Part findByPartId(Integer part_id);
}
