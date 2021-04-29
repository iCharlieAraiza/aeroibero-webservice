package mx.aeroibero.main.reservacion.controller;

import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.service.aeropuerto.AeropuertoService;
import mx.aeroibero.main.service.aeropuerto.AeropuertoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservacion")
public class ReservacionController {
    private AeropuertoService aeropuertoService;

    public ReservacionController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping
    public List<Aeropuerto> show_reservacion(){
        return aeropuertoService.findAll();
    }
}
