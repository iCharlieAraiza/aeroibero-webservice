package uia.dappii.dijkstra;
import lombok.Data;

@Data
public class Ruta {
    private final String ciudadOne;
    private final String ciudadTwo;
    private final int longitud;
}
