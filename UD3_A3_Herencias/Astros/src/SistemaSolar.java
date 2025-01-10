import java.util.Scanner;

public class SistemaSolar {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("<===Bienvenido al sistema solar===>");
        Astros [] astros = new Astros[10];
        int contador = 0;
        String option;
        
        do {
            System.out.println("1. Crear un astro.");
            System.out.println("2. Mostrar informacion de los astros registrados.");
            System.out.println("3. Salir.");
            option = entrada.nextLine();

            switch (option) {
                case "1":
                    String nombre = myUtils.leerTextoPantalla("Introduce el nombre del astro");
                    double masa = myUtils.leerNumeroPantalla("Introduce la masa del astro");
                    double diametro = myUtils.leerNumeroPantalla("Introduce el diametro del astro");
                    double pRotacion = myUtils.leerNumeroPantalla("Introduce el periodo de rotacion del astro");
                    double pTraslacion = myUtils.leerNumeroPantalla("Introduce el periodo de traslacion del astro");
                    double dMedia = myUtils.leerNumeroPantalla("Introduce la distancia media del astro");
                    Astros astro = new Astros(nombre, masa, diametro, pRotacion, pTraslacion, dMedia);
                    System.out.println(astro.toString());
                    System.out.println("Astro creado con exito.");
                    System.out.println("Que es tu astro?");
                    String opcion;

                    System.out.println("1. Un planeta. Introduce los datos necesarios.");
                    System.out.println("2. Un satelite. Introduce los datos necesarios.");
                    System.out.println("3. Salir.");
                    opcion = entrada.nextLine();
        
                    if(opcion.equals("1")){
                            double distanciaSol = myUtils.leerNumeroPantalla("Introduce la distancia al sol del planeta");
                            double orbita = myUtils.leerNumeroPantalla("Introduce la orbita del planeta");
                            System.out.println("Tiene satelites? (s/n)");
                            boolean tieneSatelites = false;
                            String tieneSatelites1 = entrada.nextLine();
                            if (tieneSatelites1.equals("s")) {
                                tieneSatelites = true;
                            } else if (tieneSatelites1.equals("n")) {
                                tieneSatelites = false;
                            } else {
                                System.out.println("Introduce un valor valido.");
                            }
                            Planetas infoPlaneta = new Planetas(distanciaSol, orbita, tieneSatelites, nombre, masa, diametro, pRotacion, pTraslacion, dMedia);
                            astros[contador++] = infoPlaneta;
                            System.out.println(infoPlaneta.toString());
                        } else if (opcion.equals("2")){
                            double distanciaPlaneta = myUtils.leerNumeroPantalla("Introduce la distancia al planeta del satelite");
                            double orbitaPlaneta = myUtils.leerNumeroPantalla("Introduce la orbita del satelite");
                            String planetaOrbita = myUtils.leerTextoPantalla("Introduce el planeta al que orbita el satelite");
                            Satelites infoSatelite = new Satelites(distanciaPlaneta, orbitaPlaneta, planetaOrbita, nombre, masa, diametro, pRotacion, pTraslacion, dMedia);
                            astros[contador++] = infoSatelite;
                            System.out.println(infoSatelite.toString());
                        } else {
                            System.out.println("Volviendo a la creacion de astros.");
                        }
                    break;
                case "2":
                    for (int i = 0; i < contador; i++) {
                        System.out.println(astros[i].toString());
                    }
                    break;
                case "3":
                    System.out.println("Saliendo del sistema solar.");
                    break;
                default:
                    System.out.println("Introduce un valor valido.");
                }
        } while (!option.equals("3"));
    }
}