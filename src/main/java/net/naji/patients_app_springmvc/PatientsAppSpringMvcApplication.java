package net.naji.patients_app_springmvc;

import net.naji.patients_app_springmvc.entities.Patient;
import net.naji.patients_app_springmvc.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsAppSpringMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientsAppSpringMvcApplication.class, args);
    }
    //@Bean
    public CommandLineRunner start (PatientRepository patientRepository){
        return args -> {
            Patient p1=new Patient();
            p1.setNom("Youssfi");
            p1.setPrenom("Mohamed");
            p1.setDateNaissance(new Date());
            p1.setScore(300);
            p1.setMalade(true);

            Patient p2=new Patient(null,"Imane","Imane",new Date(),false,234);

            Patient p3= Patient.builder()
                    .nom("Sanae")
                    .prenom("Yassine")
                    .malade(false)
                    .score(122)
                    .build();
            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);

           // patientRepository.findAll().forEach(System.out::println);
            patientRepository.findAll().forEach(p-> System.out.println(p.toString()));
        };
    }
    @Bean
public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}
}
