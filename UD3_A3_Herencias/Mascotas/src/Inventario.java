
public class Inventario {
    private Mascotas[] animales;
    private int numAnimales;
    private static final int MAX_ANIMALES = 100;
    
    public Inventario() {
        animales = new Mascotas[MAX_ANIMALES];
        numAnimales = 0;
    }
    
    public void mostrarListaAnimales() {
        for (int i = 0; i < numAnimales; i++) {
            animales[i].muestra();
        }
    }
    
    public void mostrarAnimal(int indice) {
        if (indice >= 0 && indice < numAnimales) {
            animales[indice].muestra();
        } else {
            System.out.println("Índice no válido");
        }
    }
    
    public void mostrarTodosLosDatos() {
        for (int i = 0; i < numAnimales; i++) {
            System.out.println("\nAnimal " + (i+1) + ":");
            animales[i].muestra();
            System.out.println("Edad: " + animales[i].edad);
            System.out.println("Estado: " + animales[i].estado);
            System.out.println("Fecha de nacimiento: " + animales[i].fechaNacimiento);
        }
    }
    
    public void insertarAnimal(Mascotas animal) {
        if (numAnimales < MAX_ANIMALES) {
            animales[numAnimales] = animal;
            numAnimales++;
        } else {
            System.out.println("El inventario está lleno");
        }
    }
    
    public void eliminarAnimal(int indice) {
        if (indice >= 0 && indice < numAnimales) {
            for (int i = indice; i < numAnimales - 1; i++) {
                animales[i] = animales[i + 1];
            }
            animales[numAnimales - 1] = null;
            numAnimales--;
        } else {
            System.out.println("Índice no válido");
        }
    }
    
    public void vaciarInventario() {
        for (int i = 0; i < numAnimales; i++) {
            animales[i] = null;
        }
        numAnimales = 0;
    }
}