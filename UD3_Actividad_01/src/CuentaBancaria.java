public class CuentaBancaria {
    private String iban;
    private String titular;
    private double saldo;
    private Movimiento []movimientos;
    private int nMovimientos;

    public CuentaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0.0;
        this.movimientos = new Movimiento[100];
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void registrarMovimiento(String tipo, double cantidad){
        if(nMovimientos >= 100){
            System.out.println("No se pueden realizar mas movimientos.");
        }
        movimientos[nMovimientos] = new Movimiento(tipo,cantidad);
        nMovimientos++;
    }

    public void mostrarMovimiento(){
        if(nMovimientos==0){
            System.out.println("No existen movimientos.");
        }
        for (int i = 0; i < nMovimientos; i++) {
            movimientos[i].mostrarInfoMovimiento();
        }
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
