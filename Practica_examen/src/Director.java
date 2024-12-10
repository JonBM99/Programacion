import java.time.LocalDate;

public class Director {
        private String nombre;
        private String dni;
        private LocalDate fechaAlta;
        
        public Director(String nombre, String dni) {

            this.nombre = nombre;
            this.dni = dni;
            this.fechaAlta = LocalDate.now();
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public String getDni() {
            return dni;
        }

        public LocalDate getFechaAlta() {
            return fechaAlta;
        }
    
        public String mostrarInfoDirector(){
            String infoDirector = String.format("Nombre: %s, Dni: %s Director desde: %s", this.nombre, this.dni, this.fechaAlta);
            return infoDirector;
        }
}
