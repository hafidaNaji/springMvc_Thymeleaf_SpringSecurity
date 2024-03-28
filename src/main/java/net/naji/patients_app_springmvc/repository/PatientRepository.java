package net.naji.patients_app_springmvc.repository;

import net.naji.patients_app_springmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
 Page<Patient>findByNomContainingIgnoreCaseOrPrenomContainsIgnoreCase(String nom,String prenom,Pageable pageable);

}
