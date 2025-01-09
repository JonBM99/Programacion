public class Satelites extends Astros{
    private String planeta;

    public Satelites(String planeta, double diametro, double distancia, double gravedad, double masa, String nombre, double rotacion, double temperatura, double traslacion) {
        super(diametro, distancia, gravedad, masa, nombre, rotacion, temperatura, traslacion);
        this.planeta = planeta;
    }

    public String getPlaneta() {
        return planeta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Satelites{");
        sb.append(" Nombre: ").append(super.getNombre());
        sb.append(", Planeta que orbita: ").append(planeta);
        sb.append(" , Masa: ").append(super.getMasa());
        sb.append(" Kg , Diametro: ").append(super.getDiametro());
        sb.append(" Km , Rotacion: ").append(super.getRotacion());
        sb.append(" Dias , Traslacion: ").append(super.getTraslacion());
        sb.append(" Dias , Distancia: ").append(super.getDistancia());
        sb.append(" Km , Temperatura: ").append(super.getTemperatura());
        sb.append(" ºC , Gravedad: ").append(super.getGravedad());
        sb.append("G}");
        return sb.toString();
    }
}
