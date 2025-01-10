import java.util.Scanner;

public class myUtils {
    public static String leerTextoPantalla(String mensaje){
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        String valor = reader.nextLine();
        return valor;
    }
    
    public static double leerNumeroPantalla(String mensaje){
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        double valor = reader.nextDouble();
        return valor;
    }
}
