package mx.aeroibero.main.controller;

import mx.aeroibero.main.entity.cliente.Cliente;
import mx.aeroibero.main.service.cliente.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    public ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public List<Cliente> showClientes(){
        return clienteService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Object showCLienteById(@PathVariable( value = "id") Long id){
        Cliente cliente = clienteService.findByID(id);
        if(cliente==null)
            return null;
        return cliente;
    }

    @CrossOrigin
    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

}
