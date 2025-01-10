public class Satelites extends Astros {
    private double distanciaPlaneta;
    private double orbitaPlaneta;
    private String planetaOrbita;

    public Satelites(double distanciaPlaneta, double orbitaPlaneta, String planetaOrbita, String nombre, double masa, double diametro, double pRotacion, double pTraslacion, double dMedia) {
        super(nombre, masa, diametro, pRotacion, pTraslacion, dMedia);
        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlaneta = orbitaPlaneta;
        this.planetaOrbita = planetaOrbita;
    }

    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public double getOrbitaPlaneta() {
        return orbitaPlaneta;
    }

    public String getPlanetaOrbita() {
        return planetaOrbita;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Satelites: ");
        sb.append("Nombre: ").append(super.getNombre());
        sb.append(", Masa del Cuerpo: ").append(super.getMasa());
        sb.append(", Diametro Medio: ").append(super.getDiametro());
        sb.append(", Periodo de Rotacion: ").append(super.getpRotacion());
        sb.append(", Periodo de Trastacion: ").append(super.getpTraslacion());
        sb.append(", Distancia Media: ").append(super.getdMedia());
        sb.append(", Distancia al Planeta: ").append(distanciaPlaneta);
        sb.append(", Orbita al Planeta: ").append(orbitaPlaneta);
        sb.append(", Planeta al que orbita: ").append(planetaOrbita);
        sb.append('.');
        return sb.toString();
    }

}
