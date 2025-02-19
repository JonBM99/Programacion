public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto: ");
        sb.append("codigo:").append(codigo);
        sb.append(", nombre:").append(nombre);
        sb.append(", cantidad:").append(cantidad);
        sb.append(", precio:").append(precio);
        sb.append('.');
        return sb.toString();
    }


}
