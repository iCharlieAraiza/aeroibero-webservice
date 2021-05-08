package mx.aeroibero.main.reservacion.controller;

import mx.aeroibero.main.dto.ReservacionDto;
import mx.aeroibero.main.entity.Boleto;
import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.entity.cliente.Cliente;
import mx.aeroibero.main.service.aeropuerto.AeropuertoService;
import mx.aeroibero.main.service.aeropuerto.AeropuertoServiceImpl;
import mx.aeroibero.main.service.boleto.BoletoService;
import mx.aeroibero.main.service.cliente.ClienteService;
import mx.aeroibero.main.service.viaje.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservacion")
public class ReservacionController {
    private AeropuertoService aeropuertoService;
    private ViajeService viajeService;
    private ClienteService clienteService;
    private BoletoService boletoService;

    public ReservacionController(AeropuertoService aeropuertoService, ViajeService viajeService, ClienteService clienteService, BoletoService boletoService) {
        this.aeropuertoService = aeropuertoService;
        this.viajeService = viajeService;
        this.clienteService = clienteService;
        this.boletoService = boletoService;
    }


    @GetMapping
    public List<Aeropuerto> show_reservacion(){
        return aeropuertoService.findAll();
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public Boleto getTicket(@PathVariable ( value = "id") long id){
        return boletoService.findByID(id);
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

    @CrossOrigin
    @PostMapping("/create")
    public List<Boleto> createReservation(@RequestBody ReservacionDto reservacion){
        List<Cliente> clienteList = reservacion.getClientes(), newClients = new ArrayList<>();
        List<Viaje> viajeList = reservacion.getViajes();
        List<Boleto> boletoList = new ArrayList<>();

        clienteList.forEach(cliente -> {
            newClients.add(clienteService.saveCliente(cliente));
        });

        for(Viaje viaje : viajeList){
            for(Cliente cliente : newClients){
                if(cliente.getEmail()!=null){
                    boletoList.add(
                            boletoService.saveBoleto( new Boleto(cliente, viaje, "Pendiente", null ))
                    );
                }

            }
        }

        return boletoList;
    }

}
