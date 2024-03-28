package net.naji.patients_app_springmvc.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name = "PATIENTS")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString@Builder
public class Patient {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY )

    private Long id;

    @NotEmpty
    @Size(min = 5,max = 40)
    private String nom;

    @NotEmpty
    @Size(min = 5,max = 40)
    private String prenom;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    private boolean malade;

    @DecimalMin("100")
    private int score;

}
