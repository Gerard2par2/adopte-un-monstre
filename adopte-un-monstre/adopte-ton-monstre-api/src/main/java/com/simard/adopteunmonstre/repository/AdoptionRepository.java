package com.simard.adopteunmonstre.repository;

import com.simard.adopteunmonstre.model.entities.Adoption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends CrudRepository<Adoption, Long> {

    @Query("SELECT a FROM Adoption a WHERE a.user.id = :userId")
    Iterable<Adoption> findAllByUserId(Long userId);
}
