import java.util.Random;

public class Cliente {

    private String ID;
    private String nombre;
    private String phone;
    private String email;
    private String user;
    private String clave;
    private boolean status;
    private int[][] tarjetaAcceso;
    private int[] numerosCuenta;


    public Cliente(String ID, String nombre, String phone, String email, String user, boolean status) {
        this.ID = ID;
        this.nombre = nombre;
        this.phone = phone;
        this.email = email;
        this.user = user;
//      this.user = generarUsuario(nombre);
        this.status = status;
        this.clave = "";
        this.tarjetaAcceso = generarTarjetaAcceso();
        this.numerosCuenta = new int[]{0, 0, 0, 0, 0};
    }

    public Cliente() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {

        this.user = user;

    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int[] getNumerosCuenta() {
        return numerosCuenta;
    }

    public void setNumerosCuenta(int[] numerosCuenta) {
        this.numerosCuenta = numerosCuenta;
    }

    public String getTarjetaAcceso() {
        String acceso = "";
        acceso += "\n";
        char[] columns = {'A', 'B', 'C', 'D', 'E'};
        // Display column letters
        acceso += "    ";
        for (int j = 0; j < 5; j++) {
            acceso += "[" + columns[j] + "] ";
        }
        acceso += "\n";

        int[][] tarjeta = generarTarjetaAcceso(); // Retrieve the tarjetaAcceso matrix

        // Display row numbers and tarjetaAcceso values
        for (int i = 0; i < 4; i++) {
            acceso += "[" + (i + 1) + "] ";
            for (int j = 0; j < 5; j++) {
                acceso += "[" + tarjeta[i][j] + "] "; // Update the value with tarjetaAcceso matrix value
            }
            acceso += "\n";
        }
        return acceso;
    }


    private int[][] generarTarjetaAcceso() {
        int[][] tarjeta = new int[4][5];
        Random random = new Random();
        for (int i = 0; i < tarjeta.length; i++) {
            for (int j = 0; j < tarjeta[i].length; j++) {
                tarjeta[i][j] = random.nextInt(90) + 10;
            }
        }
        return tarjeta;
    }

    public String info (){
        return   "-*-*-*-*-*-*-*-*-*-*-*\n"
                + " El id del cliente es: " + getID() + "\n El nombre completo del cliente es: "
                + getNombre() + "\n El telefono del cliente es: " + getPhone()
                + "\n El correo del cliente es: " + getEmail() + "\n El usuario del cliente: "
                + getUser() + "\n El estado del cliente es: "+ getStatus() +"\nTarjeta de acceso\n" + getTarjetaAcceso();
    }
}