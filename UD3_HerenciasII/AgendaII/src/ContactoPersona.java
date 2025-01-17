public class ContactoPersona extends Contactos{
    private String cumpleaños;

    public ContactoPersona(String nombre, String telefono, String cumpleaños) {
        super(nombre, telefono);
        this.cumpleaños = cumpleaños;
    }

    public String getCumpleaños() {
        return cumpleaños;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactoPersona: ");
        sb.append("Nombre: ").append(getNombre());
        sb.append(", Telefono: ").append(getTelefono());
        sb.append(", Cumpleaños: ").append(cumpleaños);
        sb.append('.');
        return sb.toString();
    }
}