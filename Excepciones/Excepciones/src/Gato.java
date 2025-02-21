public class Gato {
    String nombre;
    int edad;
/**
 * 
 * @param nombre
 * @param edad
 * @throws Exception
 */
    public Gato(String nombre, int edad) throws Exception{
        setNombre(nombre);
        setEdad(edad);
    }

/**
 * 
 * @return
 * @throws Exception
 */
    public String getNombre()throws Exception {
        if(nombre == null || nombre.length()<3){
            throw new Exception("El nombre no puede ser nulo o tener menos de 3 letras");
        }
        return nombre;
    }

/**
 * 
 * @param nombre
 * @throws Exception
 */
    public void setNombre(String nombre) throws Exception {
        if(nombre == null || nombre.length()<3){
            throw new Exception("El nombre no puede ser nulo o tener menos de 3 letras");
        }
        this.nombre = nombre;
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    public int getEdad() throws Exception{
        if(edad < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        return edad;
    }

    /**
     * 
     * @param edad
     * @throws Exception
     */
    public void setEdad(int edad) throws Exception{
        if(edad < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.edad = edad;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString(){
        return "El gato se llama: " + nombre + " y tiene " + edad + " año/s.";
    }

    
}
