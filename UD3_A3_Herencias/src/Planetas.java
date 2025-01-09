public class Planetas extends Astros{
    private boolean hassatelites;
    private Satelites satelites[];
    private int nSatelites;

    public Planetas(boolean hassatelites, double diametro, double distancia, double gravedad, double masa, String nombre, double rotacion, double temperatura, double traslacion) {
        super(diametro, distancia, gravedad, masa, nombre, rotacion, temperatura, traslacion);
        this.hassatelites = false;
        this.satelites = new Satelites[100];
        this.nSatelites = 0;
    }

    public boolean isHassatelites() {
        return hassatelites;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Planetas{");
        sb.append("Nombre: ").append(super.getNombre());
        sb.append(", Masa: ").append(super.getMasa());
        sb.append(" Kg, Diametro: ").append(super.getDiametro());
        sb.append(" Km, Rotacion: ").append(super.getRotacion());
        sb.append(" Horas, Traslacion: ").append(super.getTraslacion());
        sb.append(" Dias, Distancia: ").append(super.getDistancia());
        sb.append(" Km, Temperatura: ").append(super.getTemperatura());
        sb.append(" ºC, Gravedad: ").append(super.getGravedad());
        sb.append(" G, Tiene satelites?: ").append(hassatelites);
        sb.append('}');
        return sb.toString();
    }

    public void agregarSatelite(Satelites satelite) {
        if (nSatelites < satelites.length) {
            satelites[nSatelites] = satelite;
            nSatelites++;
            hassatelites = true;
        } else {
            System.out.println("No se pueden agregar más satélites a " + getNombre());
        }
    }
}
