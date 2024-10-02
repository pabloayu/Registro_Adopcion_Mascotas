package com.mascotas.app.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date fechaNac;
    private String raza;
    private double peso;
    private boolean tieneChip;
    private String urlFoto;
    
}


