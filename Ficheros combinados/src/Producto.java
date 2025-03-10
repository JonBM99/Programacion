public class Producto {
    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;
    
    public Producto(String referencia, String tipo, String descripcion) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getIva() {
        return iva;
    }

    public boolean isAplicarDto() {
        return aplicarDto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto:");
        sb.append("referencia:").append(referencia);
        sb.append(", descripcion:").append(descripcion);
        sb.append(", tipo:").append(tipo);
        sb.append(", cantidad:").append(cantidad);
        sb.append(", precio:").append(precio);
        sb.append(", descuento:").append(descuento);
        sb.append(", iva:").append(iva);
        sb.append(", aplicarDto:").append(aplicarDto);
        sb.append('.');
        return sb.toString();
    }
}
