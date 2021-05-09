package mx.aeroibero.main.dto;

import lombok.Data;
import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.cliente.Cliente;

import java.util.List;

@Data
public class ReservacionDto {
    List<Cliente> clientes;
    List<Viaje> viajes;
}
