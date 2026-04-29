package com.marien.hospitalapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 200)
    private String nom;

    private String prenom;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date dateNaissance;

    @DecimalMin("100")
    private int score;

    private  boolean malade;

}
