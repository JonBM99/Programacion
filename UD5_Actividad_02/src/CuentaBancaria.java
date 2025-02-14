import java.util.ArrayList;

public class CuentaBancaria {
    private String iban;
    private Cliente cliente;
    private double saldo;
    ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();

    public CuentaBancaria(String iban, Cliente cliente) {
        this.iban = iban;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public String getIban() {
        return iban;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void registrarMovimiento(String tipo, double cantidad){
        Movimiento movimiento = new Movimiento(tipo, cantidad);
        movimientos.add(movimiento);
    }

    public String mostrarMovimiento(){
        String mostrartinfomove ="";
        for(Movimiento movimiento : movimientos){
            mostrartinfomove += movimiento.toString();
        }
        return mostrartinfomove;
    }

    public void ingreso(double cantidad){
        if(cantidad <= 0){
            System.out.println("La cantidad debe ser mayor que 0.");
        }
        if(cantidad >= 3000){
            System.out.println("AVISO: Notificar a hacienda.");
        }
        saldo += cantidad;
        registrarMovimiento("Ingreso", cantidad);
    }

    public void retirada(double cantidad){
        if(cantidad <= 0){
            System.out.println("La cantidad debe ser mayor que 0.");
        }
        if(cantidad >= 3000){
            System.out.println("AVISO: Notificar a hacienda.");
        }
        if((saldo-cantidad) < -50){
            System.out.println("AVISO: Saldo negativo");
        }
        saldo-=cantidad;
        registrarMovimiento("Retirada", cantidad);
    }
}
