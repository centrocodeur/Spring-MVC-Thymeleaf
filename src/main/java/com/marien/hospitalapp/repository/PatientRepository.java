package com.marien.hospitalapp.repository;

import com.marien.hospitalapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findByNomContainsIgnoreCase(String keyword, Pageable pageable);

    Page<Patient> findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(String nom, String prenom,  Pageable pageable);

}
