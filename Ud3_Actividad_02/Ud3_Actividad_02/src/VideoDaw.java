import java.time.LocalDate;

public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula [] peliculasRegistradas;
    private Cliente [] clientesRegistrados;
    private int nPelisRegistradas;
    private int nClientesRegistrados;
    
    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.peliculasRegistradas = new Pelicula[100];
        this.clientesRegistrados = new Cliente[100];
        this.nPelisRegistradas = 0;
        this.nClientesRegistrados = 0;
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public Pelicula[] getPeliculasRegistradas() {
        return peliculasRegistradas;
    }

    public Cliente[] getClientesRegistrados() {
        return clientesRegistrados;
    }
    
    public String mostrarInfoVideoclub(){
        String infoVideoclub = String.format("Cif: %s, Direccion: %s, FechaAlta: %s, Peliculas registradas: %s, Clientes registrados: %s",
        this.cif, this.direccion, this.fechaAlta, this.nPelisRegistradas, this.nClientesRegistrados);
        return infoVideoclub;
    }

    public boolean registrarPelicula(Pelicula p){
        boolean isAdd = false;
        if(p != null){
            this.peliculasRegistradas[nPelisRegistradas] = p;
            nPelisRegistradas++;
            p.isAlquilada();
        }
        return isAdd;
    }

    public String mostrarPeliculasAlquiladas(){
        String peliculasAlquiladas = "";
        for(int i = 0; i < nPelisRegistradas; i++){
            if (peliculasRegistradas[i].isAlquilada() == true){
                System.out.println(i + "." + peliculasRegistradas[i].mostrarInfoPelicula());
            }
        }
        return peliculasAlquiladas;
    }
    

    public String mostrarPeliculasNoAlquiladas(VideoDaw v1){
        String peliculasNoAlquiladas = "";
            for (int i = 0; i < nPelisRegistradas; i++) {
                if(peliculasRegistradas[i].isAlquilada() == false)
                System.out.println(i + "." + peliculasRegistradas[i].mostrarInfoPelicula());
            }
        return peliculasNoAlquiladas;
    }

    public boolean registrarCliente(Cliente c){
        boolean isAdd = false;
        if(c != null){
            this.clientesRegistrados[nClientesRegistrados] = c;
            nClientesRegistrados++;
        }
        return isAdd;
    }

    public void mostrarClientes(){
        if(clientesRegistrados != null){
            for (int i = 0; i < nClientesRegistrados; i++) {
                System.out.println(i + "." + clientesRegistrados[i].mostraInfocliente());
            }
        }
    }
    public Cliente posicionCliente(int i){
        return this.clientesRegistrados[i];
    }

    public Pelicula posicionPelicula(int i){
        return this.peliculasRegistradas[i];
    }

    public boolean alquilarPelicula(int c, int p){
        this.posicionCliente(c);
        this.posicionPelicula(p).alquiler();
        boolean isAdd = false;
        return isAdd;
    }

    public boolean  devolverPelicula(int c, int p){
        this.posicionCliente(c);
        this.posicionPelicula(p).devolver();
        boolean isRemove = false;
        return isRemove;
    }

    public boolean darBajaCliente(Cliente cliente, int c){
        boolean quitarCliente = false;
        if(cliente != null){
            this.clientesRegistrados[nClientesRegistrados] = null;
            for (int i = 0; i < nClientesRegistrados; i++) {
                this.clientesRegistrados[nClientesRegistrados - 1] = this.clientesRegistrados[i];
            }
            this.clientesRegistrados[nClientesRegistrados - 1] = null;
            nClientesRegistrados--;
            quitarCliente = true;
            System.out.println("Cliente dado de baja correctamente.");
        }
        return quitarCliente;
    }

    public boolean darBajaPelicula(Pelicula pelicula, int p){
        boolean quitarPelicula = false;
        if(pelicula != null){
            this.peliculasRegistradas[nPelisRegistradas] = null;
            for (int i = 0; i < nPelisRegistradas; i++) {
                this.peliculasRegistradas[nPelisRegistradas - 1] = this.peliculasRegistradas[i];
            }
            this.peliculasRegistradas[nPelisRegistradas - 1] = null;
            nPelisRegistradas--;
            quitarPelicula = true;
            System.out.println("Pelicula dada de baja correctamente.");
        }
        return quitarPelicula;
    }
}