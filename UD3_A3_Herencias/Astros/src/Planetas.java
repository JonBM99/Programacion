public class Planetas extends Astros {
    private double distanciaSol;
    private double orbita;
    private boolean tieneSatelites;

    public Planetas(double distanciaSol, double orbita, boolean tieneSatelites, String nombre, double masa, double diametro, double pRotacion, double pTraslacion, double dMedia) {
        super(nombre, masa, diametro, pRotacion, pTraslacion, dMedia);
        this.distanciaSol = distanciaSol;
        this.orbita = orbita;
        this.tieneSatelites = tieneSatelites;
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public double getOrbita() {
        return orbita;
    }

    public boolean isTieneSatelites() {
        return tieneSatelites;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Planeta: ");
        sb.append("Nombre: ").append(super.getNombre());
        sb.append(", Masa del Cuerpo: ").append(super.getMasa());
        sb.append(", Diametro Medio: ").append(super.getDiametro());
        sb.append(", Periodo de Rotacion: ").append(super.getpRotacion());
        sb.append(", Periodo de Trastacion: ").append(super.getpTraslacion());
        sb.append(", Distancia Media: ").append(super.getdMedia());
        sb.append(", Distancia al Sol: ").append(distanciaSol);
        sb.append(", Orbita al Sol: ").append(orbita);
        sb.append(", Tiene satelites?: ").append(tieneSatelites);
        sb.append('.');
        return sb.toString();
    }
}