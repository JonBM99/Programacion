import java.io.Serializable;

public class Libro implements Serializable{

    private static final long serialVersionUID = 1549415889424694442L;

    private String isbn;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

    public Libro(String isbn, String titulo, String autor, String fechaPublicacion) {
    
    
    this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro:");
        sb.append("isbn:").append(isbn);
        sb.append(", titulo:").append(titulo);
        sb.append(", autor:").append(autor);
        sb.append(", fechaPublicacion:").append(fechaPublicacion);
        sb.append('.');
        return sb.toString();
    }
}
