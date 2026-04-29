package com.marien.hospitalapp;

import com.marien.hospitalapp.entities.Patient;
import com.marien.hospitalapp.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HospitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalAppApplication.class, args);
    }


    //@Bean
    public CommandLineRunner start(PatientRepository patientRepository){

        return  args -> {
            Patient p1 = new Patient();  // NoArgContructor
            p1.setNom("Marien");
            p1.setPrenom("Rodrique");
            p1.setScore(120);
            p1.setMalade(false);
            p1.setDateNaissance(new Date());
            patientRepository.save(p1);

            // AllArgsConstructor
            Patient p2 = new Patient(null, "TAPANDE", "Marien", new Date(), 1200, false);

            patientRepository.save(p2);

           Patient p3 = Patient.builder()  // Builder
                   .nom("Tapande")
                   .dateNaissance(new Date())
                   .prenom("Mathis")
                   .score(140)
                   .build();
           patientRepository.save(p3);


            List<Patient> patientList = patientRepository.findAll();

            patientList.forEach(p ->{
               System.out.println(p.toString());
            });
        };

    }


}
