package com.mascotas.app.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mascotas.app.Service.MascotaService;
import com.mascotas.app.model.Mascota;
import org.springframework.ui.Model;


@Controller
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    // Home Page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // List all pets
    @GetMapping("/mascotas")
    public String listarMascotas(@RequestParam(defaultValue = "0") int pagina, @RequestParam(defaultValue = "5") int tamano, Model model) {
        Page<Mascota> page = mascotaService.listarMascotasPaginadas(pagina, tamano);
        model.addAttribute("mascotas", page.getContent());
        model.addAttribute("pagina", pagina);
        model.addAttribute("tamano", tamano);
        model.addAttribute("totalPaginas", page.getTotalPages());
        return "listarMascotas";
    }

    // Search for pets by name
    @GetMapping("/mascotas/buscarPorNombre")
    public String buscarMascotasPorNombre(@RequestParam("nombre") String nombre, Model model) {
        List<Mascota> mascotas = mascotaService.buscarPorNombre(nombre);
        model.addAttribute("mascotas", mascotas);
        model.addAttribute("nombre", nombre);
        return "buscarMascota"; 
    }

    // Search for pet by ID
    @GetMapping("/mascotas/buscarPorId")
    public String buscarMascotaPorId(@RequestParam("id") Long id, Model model) {
        Optional<Mascota> mascota = mascotaService.buscarPorId(id);
        if (mascota.isPresent()) {
            model.addAttribute("mascota", mascota.get());
            model.addAttribute("error", false);
        } else {
            model.addAttribute("error", true);
            model.addAttribute("mensaje", "Mascota no encontrada.");
        }
        return "verMascota";
    }

    // Show form to create a new pet
    @GetMapping("/mascotas/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "subirMascota";
    }

    // Create a new pet
    @PostMapping("/mascotas")
    public String crearMascota(@ModelAttribute Mascota mascota, Model model) {
        mascotaService.guardar(mascota);
        model.addAttribute("mensaje", "Mascota añadida exitosamente.");
        return "redirect:/mascotas?mensaje=" + "Mascota añadida exitosamente.";
    }

    // Remove a pet
    @PostMapping("/mascotas/borrar/{id}")
    public String eliminarMascota(@PathVariable Long id) {
        mascotaService.borrar(id);
        return "redirect:/mascotas";
    }

    // List the 20 youngest pets
    @GetMapping("/mascotas/jovenes")
    public String listarMascotasMasJovenes(@RequestParam(defaultValue = "0") int pagina, @RequestParam(defaultValue = "5") int tamano, Model model) {
        Page<Mascota> page = mascotaService.listarMascotasPaginadas(pagina, tamano);
        model.addAttribute("mascotas", page.getContent());
        model.addAttribute("pagina", pagina);
        model.addAttribute("tamano", tamano);
        model.addAttribute("totalPaginas", page.getTotalPages());
        return "listarJovenes";
    }
}

