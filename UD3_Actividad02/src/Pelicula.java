import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    private int cod;
    private String titulo;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;
    private GeneroPelicula genero;
    private static int contador = 1;

    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

    public Pelicula(String titulo, GeneroPelicula genero){
        this.titulo = titulo;
        this.genero = genero;

        this.cod = this.contador;
        this.contador++;
        this.fechaRegistro = LocalDate.now();
        this.isAlquilada = false;
    } 

    public int getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public GeneroPelicula getGenero() {
        return genero;
    }

    public void darBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setIsAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    public String mostrarInfoPelicula(){
        String infoPelicula = String.format("Codigo: P-0%s, Titulo: %s, Genero: %s",
        this.cod, this.titulo,this.genero);
        return infoPelicula;
    }

    
}
