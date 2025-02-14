import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Movimiento {
    private int id;
    private LocalDateTime fecha;
    private String tipo;
    private double cantidad;

    private static int nMovimientos = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Movimiento(String tipo, double cantidad) {
        this.id = this.nMovimientos;
        this.nMovimientos++;
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movimiento:");
        sb.append("id:").append(id);
        sb.append(", fecha:").append(fecha.format(formatter));
        sb.append(", tipo:").append(tipo);
        sb.append(", cantidad:").append(cantidad);
        sb.append('.' + "\n");
        return sb.toString();
    }
}
