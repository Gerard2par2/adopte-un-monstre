package com.simard.adopteunmonstre.repository;

import com.simard.adopteunmonstre.model.entities.Adoption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends CrudRepository<Adoption, Long> {
}
