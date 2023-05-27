package com.simard.adopteunmonstre.services;

import com.simard.adopteunmonstre.exception.ResourceNotFoundException;
import com.simard.adopteunmonstre.model.entities.Adoption;
import com.simard.adopteunmonstre.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {
    private final AdoptionRepository adoptionRepository;
    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository) {this.adoptionRepository = adoptionRepository;}
    public Iterable<Adoption> getAllByUserId(Long userId) {
        return this.adoptionRepository.findAllByUserId(userId);
    }

    public Adoption create(Adoption newAdoption) {
        return this.adoptionRepository.save(newAdoption);
    }

    public void deleteById(Long id) {
        this.adoptionRepository.deleteById(id);
    }

    public Adoption updateById(Long id, Adoption updatedAdoption) {
        return adoptionRepository.findById(id)
                .map(adoption -> {
                    adoption.setMonster(updatedAdoption.getMonster());
                    adoption.setUser(updatedAdoption.getUser());
                    adoption.setAdoptionDate(updatedAdoption.getAdoptionDate());
                    return adoptionRepository.save(adoption);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Adoption not found with id " + id));
    }
}
