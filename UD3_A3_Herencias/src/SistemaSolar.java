public class SistemaSolar {
    public static void main(String[] args) {
        Planetas tierra = new Planetas(true, 12756, 147.19e6, 1, 5.972e24, "Tierra", 24, 14, 365);
        Satelites luna = new Satelites("Tierra", 3.475, 384400, 0.16, 7.349e22, "Luna", 28, -96, 28);
        tierra.agregarSatelite(luna);
        System.out.println(tierra.toString());
        System.out.println(luna.toString());
    }
}