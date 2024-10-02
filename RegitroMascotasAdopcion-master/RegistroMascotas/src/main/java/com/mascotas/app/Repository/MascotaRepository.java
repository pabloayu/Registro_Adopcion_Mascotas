package com.mascotas.app.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mascotas.app.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Method to search for pets by name
    List<Mascota> findByNombreContainingIgnoreCase(String nombre);

    // Method to search for a pet by ID
    Optional<Mascota> findById(Long id);
}
