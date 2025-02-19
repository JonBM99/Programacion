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

    public void ingreso(double cantidad) throws AvisarHaciendaException, NumeroNoValidoException{
        saldo += cantidad;
        registrarMovimiento("Ingreso", cantidad);
        if(cantidad >= 3000){
            throw new AvisarHaciendaException("AVISO: Notificar a hacienda.");
        }
        if(cantidad <= 0){
            throw new NumeroNoValidoException("La cantidad debe ser mayor que 0.");
        }
    }

    public void retirada(double cantidad) throws AvisarHaciendaException, NumeroNoValidoException, SaldoInsuficienteException{
        
        saldo-=cantidad;
        registrarMovimiento("Retirada", cantidad);
        if(cantidad >= 3000){
            throw new AvisarHaciendaException("AVISO: Notificar a hacienda.");
        }
        if(cantidad <= 0){
            throw new NumeroNoValidoException("La cantidad debe ser mayor que 0.");
        }

        if((saldo-cantidad) < -50){
            throw new SaldoInsuficienteException("No se puede retirar más dinero del que hay en la cuenta.");
        }
    }
}