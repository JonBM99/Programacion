import java.util.HashMap;
import java.util.Map;

public class Taller {
    private String matricula;
    Map <String, Coche> coches = new HashMap<>();
    
    public String añadirCoche(String matricula, String color, String marca) {
        if (!coches.containsKey(matricula)) {
            Coche coche = new Coche(color, marca);
            coches.put(matricula, coche);
            return "Coche añadido correctamente";
        } else {
            return "Ya existe un coche con esa matricula";
        }
    }

    public String eliminarCoche(String matricula) {
        if (coches.containsKey(matricula)) {
            coches.remove(matricula);
            return "Coche eliminado correctamente";
        } else {
            return "No existe un coche con esa matricula";
        }
    } 

    public String visualizaMatriculas() {
        String matriculas = "";
        for (String matricula : coches.keySet()) {
            matriculas += matricula + ", ";
        }
        return matriculas;
    }

    public String visualizaCoches() {
        String listacoches = "";
        for (Coche coche : coches.values()) {
            listacoches += coche + ", ";
        }
        return listacoches;
    }

    public String visualizaTaller(){
        String taller = "";
        for (Map.Entry<String, Coche> entry : coches.entrySet()) {
            taller += "Matricula: " + entry.getKey() + ", " + entry.getValue();
        }
        return taller;
    }
}