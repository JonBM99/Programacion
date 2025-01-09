public abstract class Astros {
    private String nombre;
    private double masa;
    private double diametro;
    private double rotacion;
    private double traslacion;
    private double distancia;
    private double temperatura;
    private double gravedad;

    public Astros(double diametro, double distancia, double gravedad, double masa, String nombre, double rotacion, double temperatura, double traslacion) {
        this.diametro = diametro;
        this.distancia = distancia;
        this.gravedad = gravedad;
        this.masa = masa;
        this.nombre = nombre;
        this.rotacion = rotacion;
        this.temperatura = temperatura;
        this.traslacion = traslacion;
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

    public double getRotacion() {
        return rotacion;
    }

    public double getTraslacion() {
        return traslacion;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getGravedad() {
        return gravedad;
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Astros{");
        sb.append("nombre=").append(nombre);
        sb.append(", masa=").append(masa);
        sb.append(", diametro=").append(diametro);
        sb.append(", rotacion=").append(rotacion);
        sb.append(", traslacion=").append(traslacion);
        sb.append(", distancia=").append(distancia);
        sb.append(", temperatura=").append(temperatura);
        sb.append(", gravedad=").append(gravedad);
        sb.append('}');
        return sb.toString();
    }
 }