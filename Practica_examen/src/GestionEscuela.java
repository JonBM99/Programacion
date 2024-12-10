import java.util.Scanner;

public class GestionEscuela {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        Director d = null;
        JefeEstudios j = null;
        Profesor p = null;

        System.out.println("<== Bienvenido a GestionEscuela ==>");
        System.out.println("Procedemos a crear la Escuela");

        String nombreEscuela = MyUtils.leerTextoPantalla("Introduce el nombre de la escuela:");
        String localizacionEscuela = MyUtils.leerTextoPantalla("Introduce la direccion de la escuela:");
        Escuela escuela = new Escuela(nombreEscuela, localizacionEscuela);
        System.out.println("Escuela registrada correctamente.");

        String opcion;
        do {
            System.out.println("\n");
            System.out.println("1. Registrar trabajador.");
            System.out.println("2. Mostrar informacion de la escuela, con profesores, jefes de estudios y director.");
            System.out.println("3. Mostrar el numero de trabajadores.");
            System.out.println("4. Mostrar informacion de un nivel.");
            System.out.println("5. Eliminar trabajador.");
            System.out.println("6. Agenda del director.");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    String opcion2;
                    do {
                        System.out.println("Selecciona que quieres registrar:");
                        System.out.println("1. Director.");
                        System.out.println("2. Jefe de estudios.");
                        System.out.println("3. Profesor.");
                        System.out.println("4. Salir del registro de director.");
                        opcion2 = entrada.nextLine();
                        switch (opcion2) {
                            case "1":
                                String nombre = MyUtils.leerTextoPantalla("Introduce el nombre del director:");
                                String dni = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del director:");
                                Director director = new Director(nombre, dni);
                                escuela.registarDirector(director);
                                d = director;
                                break;
                            case "2":
                                String nombre1 = MyUtils.leerTextoPantalla("Introduce el nombre del jefe de estudios:");
                                String dni1 = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del jefe de estudios:");
                                Niveles nivel = MyUtils.menuNiveles();
                                JefeEstudios jefe = new JefeEstudios(nombre1, dni1, nivel);
                                escuela.registrarJefeEstudios(jefe);
                                j = jefe;
                                System.out.println(jefe.mostrarInfoJefeEstudios());
                                break;
                            case "3":
                                String nombre2 = MyUtils.leerTextoPantalla("Introduce el nombre del profesor:");
                                String dni2 = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del profesor:");
                                Niveles nivel2 = MyUtils.menuNiveles();
                                Profesor profe = new Profesor(nombre2, dni2, nivel2);
                                escuela.registrarProfesores(profe);
                                p = profe;
                                System.out.println(profe.mostrarInfoProfesor());
                                break;
                            case "4":
                                System.out.println("Volviendo al menu general.");
                                break;
                            default:
                                System.out.println("Introduce un valor valido.");
                        }
                    } while (!opcion2.equals("4"));
                    break;
                case "2":
                    System.out.println(escuela.mostrarInfoEscuela());
                    if(d != null){
                        System.out.println("Director:");
                        System.out.println(d.mostrarInfoDirector());
                    } else{ 
                        System.out.println("No hay director registrado");
                        }
                    if(j != null){
                        System.out.println("Jefes de estudios:");
                        escuela.mostrarJefeEstudios();
                    } else{ 
                        System.out.println("No hay jefes de estudios registrados");
                        }
                    if(p != null){
                        System.out.println("Profesores:");
                        escuela.mostrarProfesores();
                    } else{ 
                        System.out.println("No hay profesores registrados");
                        }
                    break;
                case "3":
                    System.out.println("El numero de trabajadores actual es: "+ escuela.nTrabajadores);
                    break;
                case "4":
                    String opcion3;
                        do {
                            System.out.println("Selecciona el nivel:");
                            System.out.println("1. Infantil.");
                            System.out.println("2. Primaria.");
                            System.out.println("3. Secundaria.");
                            System.out.println("4. Salir.");
                            opcion3 = entrada.nextLine();
                            switch (opcion3) {
                                case "1":
                                    escuela.mostrarInfoNiveles(Niveles.INFANTIL);
                                    break;
                                case "2":
                                    escuela.mostrarInfoNiveles(Niveles.PRIMARIA);
                                    break;
                                case "3":
                                    escuela.mostrarInfoNiveles(Niveles.SECUNDARIA);
                                    break;
                                case "4":
                                    System.out.println("Volviendo al menu general.");
                                    break;
                                default:
                                    System.out.println("Introduce un valor valido.");
                            }
                        } while (!opcion3.equals("4"));
                    break;
                case "5":
                String opcion4;
                do {
                    System.out.println("\n");
                    System.out.println("Selecciona quien quieres eliminar:");
                    System.out.println("1. Director.");
                    System.out.println("2. Jefe de Estudios.");
                    System.out.println("3. Profesor.");
                    System.out.println("4. Salir.");
                    opcion4 = entrada.nextLine();
                    switch (opcion4) {
                        case "1":
                            if(d != null){
                                d = null;
                                System.out.println("Director eliminado correctamente.");
                            } else{
                                System.out.println("Para eliminar a un director primero debe existir.");
                            }
                            break;
                        case "2":
                            if(j != null){
                                System.out.println("Selecciona al jefe de estudios que quieres eliminar:");
                                escuela.mostrarJefeEstudios();
                                int i = entrada.nextInt();
                                escuela.eliminarJefeEstudios(j, i);
                            } else{
                                System.out.println("Para eliminar a un jefe de estudios primero debe existir.");
                            }
                            break;
                        case "3":
                            if(p != null){
                                System.out.println("Selecciona al profesor que quieres eliminar:");
                                escuela.mostrarProfesores();
                                int i = entrada.nextInt();
                                escuela.eliminarProfesor(p, i);
                            } else{
                                System.out.println("Para eliminar a un profesor primero debe existir.");
                            }
                            break;
                        case "4":
                            System.out.println("Volviendo al menu general.");
                            break;
                        default:
                            System.out.println("Introduce un valor valido.");
                    }
                } while (!opcion4.equals("4"));
                    break;
                case "6":
                String opcion5;
                do {
                    System.out.println("Que quiere hacer:");
                    System.out.println("1. Reunion.");
                    System.out.println("2. Fuera de oficina.");
                    System.out.println("3. Convocar.");
                    System.out.println("4. Salir.");
                    opcion5 = entrada.nextLine();
                    switch (opcion5) {
                        case "1":
                            System.out.println("El director esta en una reunion.");
                            break;
                        case "2":
                            System.out.println("El director esta fuera de la oficina.");
                            break;
                        case "3":
                            System.out.println("El director esta convocando a todos los trabajadores.");
                            break;
                        case "4":
                            System.out.println("Volviendo al menu general.");
                            break;
                        default:
                            System.out.println("Introduce un valor valido.");
                    }
                } while (!opcion5.equals("4"));
                    break;
                case "7":
                    System.out.println("Saliendo de GestionEscuela");
                    break;
                default:
                    System.out.println("Introduce un valor valido.");
            }
        } while (!opcion.equals("7"));
    }
}
