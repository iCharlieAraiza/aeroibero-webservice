package mx.aeroibero.main.reservacion.controller;

import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.service.aeropuerto.AeropuertoService;
import mx.aeroibero.main.service.aeropuerto.AeropuertoServiceImpl;
import mx.aeroibero.main.service.viaje.ViajeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservacion")
public class ReservacionController {
    private AeropuertoService aeropuertoService;
    private ViajeService viajeService;

    public ReservacionController(AeropuertoService aeropuertoService, ViajeService viajeService) {
        this.aeropuertoService = aeropuertoService;
        this.viajeService = viajeService;
    }

    @GetMapping
    public List<Aeropuerto> show_reservacion(){
        return aeropuertoService.findAll();
    }

    @CrossOrigin
    @GetMapping("/collection")
    public List<Viaje> viajeListCol(@RequestParam String[] values){
        List<Viaje> viajeList = new ArrayList<>();

        for(String id : values){
            Viaje viaje = viajeService.findById(Long.parseLong(id));
            if(viaje!=null)
                viajeList.add(viaje);
        }

        //values.forEach(el-> viajeList.add(viajeService.findById(el)));
        return viajeList;
    }
}
