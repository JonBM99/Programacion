import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Metodo scanner
        Scanner entrada = new Scanner (System.in);
        //Bienvenida al programa y pregunta la cantidad de numeros a almacenar
        System.out.println("Bienvenido al programa de coleccion de datos."+"\n"+"Introduce la cantidad total de numeros a almacenar"); 
        int x = entrada.nextInt(); 
        //Array necesario para almacenar los numeros
        double [] coleccion = new double[x];             
        //do while para que el menu que vamos a crear funcione hasta que metamos el numero 4 para salir del programa
        int menu;
        do {            
            System.out.println("Introduce 1 para modificar la coleccion");
            System.out.println("Introduce 2 para mostrar las estadisticas de la coleccion");
            System.out.println("Introduce 3 para ampliar el valor de la coleccion");
            System.out.println("Introduce 4 para salir del programa");
            menu=entrada.nextInt();
            //Creamos el menu principal que contendra varios submenus
            switch (menu) {
                case 1:
                //Opciones para el primer submenu
                int opcion;
                //do while para que el subenu que vamos a crear funcione hasta que metamos el numero 4 para salir del programa
                do { 
                    System.out.println("Introduce 1 para insertar un numero en la coleccion");
                    System.out.println("Introduce 2 para borrar un numero de una posicion especifica");
                    System.out.println("Introduce 3 para modificar un numero de una posicion especifica");
                    System.out.println("Introduce 4 para salir de MODIFICAR COLECCION");
                    opcion=entrada.nextInt();
                    //Primer submenu "MODIFICAR COLLECION"
                    switch (opcion) {
                        //Primera opcion: insertar numeros
                        case 1:
                            for (int i = 0; i < coleccion.length; i++) {
                                System.out.println("Ingrese los numeros que quiere introducir en la coleccion, en la posicion " + (i+1) + " :");
                                coleccion[i]=entrada.nextDouble();
                            }
                        break;
                        //Segunda opcion: borrar un numero de una posicion especifica
                        case 2:
                            System.out.println("Introduzca la posicion en la que quiere borrar el numero");
                            int p = entrada.nextInt();
                            if(p > 0 && p < coleccion.length){
                                coleccion[p] = 0;
                                System.out.println("Se ha borrado el valor de la posicion" + p + ".");
                            }
                        break;
                        //Tercera opcion: modificar numero de una posicion especifica
                        case 3:
                            System.out.println("Introduzca un valor: ");
                            int v = entrada.nextInt();
                            System.out.println("Introduzca la posicion donde poner el valor");
                            int p1 = entrada.nextInt();

                            if (p1 >= 0 && p1 < coleccion.length) {
                                coleccion[p1] = v;
                                System.out.println("Valor " + v + " añadido en la posicion: " + p1 + ".");   
                                } else {
                                    System.out.println("Posicion invalida");
                                }
                        break;
                        //Salir del submenu al menu principal
                        case 4 :
                            System.out.println("Saliendo de MODIFICAR COLECCION");
                            break;
                        default:
                            System.out.println("Introduce un valor valido");
                    }
                } while (opcion!=4);
                break;

                //Segundo submenu "ESTADISTICAS DE LA COLECCION"
                case 2:
                int opcion1;
                //do while para que el submenu que vamos a crear funcione hasta que metamos el numero 5 para salir del programa
                do { 
                    //Opciones para el segundo submenu
                    System.out.println("Introduce 1 para mostrar la media de todos los valores no nulos");
                    System.out.println("Introduce 2 para mostrar la suma de todos los valores");
                    System.out.println("Introduce 3 para mostrar el maximo de la coleccion");
                    System.out.println("Introduce 4 para mostrar el minimo de la coleccion");
                    System.out.println("Introduce 5 para salir de ESTADISTICAS DE LA COLECCION");
                    opcion1=entrada.nextInt();
                    //Creamos el submenu
                    switch (opcion1) {
                        //Primera opcion: Media de todos los valores no nulos
                        case 1:
                        double sumasinnulos = 0;
                        double nonulos = 0;
                               
                        for (int i = 0; i < coleccion.length; i++) {
                            if(coleccion[i]!=0){
                                nonulos++;
                                sumasinnulos+=coleccion[i];
                            }
                        }
                            System.out.println("La media de los valores no nulos es: " + (sumasinnulos/nonulos));
                        break;

                        //Segunda opcion: suma de todos los valores
                        case 2:
                        double suma = 0;
                        for (int i = 0; i < coleccion.length; i++) {
                            suma+=coleccion[i];
                        }
                        System.out.println("La suma de todos los valores es: " + suma);
                        break;

                        //Tercera opcion: maximo de la coleccion
                        case 3:
                        double max = coleccion[0];
                        for (int i = 0; i < coleccion.length; i++) {
                            if (coleccion[i]>max) {
                                max = coleccion[i];
                            }
                        }
                        System.out.println("El valor maximo de la coleccion es: " + max);
                        break;
                        //Cuarta opcion: minimo de la coleccion
                        case 4:
                        double min = coleccion[0];
                        for (int i = 0; i < coleccion.length; i++) {
                            if (coleccion[i]<min) {
                                min = coleccion[i];
                            }
                        }
                        System.out.println("El valor minimo de la coleccion es: " + min);
                        break;

                        //Salida del submenu
                        case 5:
                        System.out.println("Saliendo de Estadisticas de la coleccion.");
                        default:
                            System.out.println("Introduce un valor de menu valido");
                    }
                } while (opcion1!=5);
                break;

                //Tercera opcion del menu principal "AMPLIAR LA COLECCION"
                case 3:
                System.out.println("Introduce el valor al que quieres AMPLIAR LA COLECCION");
                x=entrada.nextInt();
                break;

                //Salida del programa principal
                case 4:
                System.out.println("Saliendo del programa.");
                break;
                default:
                    System.out.println("Introduce un valor de menu valido");
            }
        } while (menu != 4);
    }
}