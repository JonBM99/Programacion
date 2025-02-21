public class ContactoEmpresa extends Contactos{
    private String paginaweb;

    public ContactoEmpresa(String nombre, String telefono, String paginaweb) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.paginaweb = paginaweb;
    }

    
    
    
    /** 
     * @return String
     */
    public String getPaginaweb() {
        return paginaweb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactoEmpresa: ");
        sb.append("Nombre: ").append(getNombre());
        sb.append(", Telefono: ").append(getTelefono());
        sb.append(", Pagina Web: ").append(paginaweb);
        sb.append('.');
        return sb.toString();
    }
}
