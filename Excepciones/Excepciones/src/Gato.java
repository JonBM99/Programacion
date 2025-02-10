public class Gato {
    String nombre;
    int edad;

    public Gato(String nombre, int edad) throws Exception{
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre()throws Exception {
        if(nombre == null || nombre.length()<3){
            throw new Exception("El nombre no puede ser nulo o tener menos de 3 letras");
        }
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre == null || nombre.length()<3){
            throw new Exception("El nombre no puede ser nulo o tener menos de 3 letras");
        }
        this.nombre = nombre;
    }

    public int getEdad() throws Exception{
        if(edad < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        return edad;
    }

    public void setEdad(int edad) throws Exception{
        if(edad < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "El gato se llama: " + nombre + " y tiene " + edad + " año/s.";
    }

    
}
