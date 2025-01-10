public class Astros {
    protected String nombre;
    protected double masa;
    protected double diametro;
    protected double pRotacion;
    protected double pTraslacion;
    protected double dMedia;
    
    public Astros(String nombre, double masa, double diametro, double pRotacion, double pTraslacion, double dMedia) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametro = diametro;
        this.pRotacion = pRotacion;
        this.pTraslacion = pTraslacion;
        this.dMedia = dMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMasa() {
        return masa;
    }

    public double getDiametro() {
        return diametro;
    }

    public double getpRotacion() {
        return pRotacion;
    }

    public double getpTraslacion() {
        return pTraslacion;
    }

    public double getdMedia() {
        return dMedia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Astros: ");
        sb.append("Nombre: ").append(nombre);
        sb.append(", Masa del cuerpo:").append(masa);
        sb.append(", Diametro del cuerpo: ").append(diametro);
        sb.append(", Periodo de rotacion: ").append(pRotacion);
        sb.append(", Periodo de traslacion: ").append(pTraslacion);
        sb.append(", Distancia media: ").append(dMedia);
        sb.append('.');
        return sb.toString();
    }
}