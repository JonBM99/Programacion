public class SistemaSolar {
    public static void main(String[] args) {
        Planetas mercurio = new Planetas(false, 4879, 57900000, 3.7, 3.285e23, "Mercurio",58.6, 167, 88);
        Planetas venus = new Planetas(false, 12104, 108200000, 8.87, 4.867e24, "Venus", 243, 450, 243);
        Planetas tierra = new Planetas(true, 12756, 149600000, 9.8, 5.972e24, "Tierra", 24, 14, 365);
        Planetas marte = new Planetas(true, 6779, 227900000, 0, 6.417e23, "Marte", 24.6, -65, 687);
        Satelites luna = new Satelites("Tierra", 3.475, 384400, 1.62, 7.349e22, "Luna", 28, -96, 28);
        tierra.agregarSatelite(luna);
        
    }
}