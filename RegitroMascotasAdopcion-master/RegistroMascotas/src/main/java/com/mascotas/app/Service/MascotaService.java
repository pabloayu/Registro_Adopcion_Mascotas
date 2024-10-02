package com.mascotas.app.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mascotas.app.Repository.MascotaRepository;
import com.mascotas.app.model.Mascota;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    //Pet List Method
    public List<Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    // Method to search for pets by name
    public List<Mascota> buscarPorNombre(String nombre) {
        return mascotaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Method to search for a pet by ID
    public Optional<Mascota> buscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }
    
    // Method for Pet Storage
    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }
    
    //Method to delete pet 
    public void borrar(Long id) {
        mascotaRepository.deleteById(id);
    }
    
    // Method for listing younger pets
    public List<Mascota> listarMascotasMasJovenes() {
        return mascotaRepository.findAll(PageRequest.of(0, 20, Sort.by("fechaNac").descending())).getContent();
    }

    //Method to show pets by 5
    public Page<Mascota> listarMascotasPaginadas(int pagina, int tamano) {
        return mascotaRepository.findAll(PageRequest.of(pagina, tamano, Sort.by("fechaNac").descending()));
    }

}
