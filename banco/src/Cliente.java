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


    public Cliente(String ID, String nombre, String phone, String email, String user, boolean status, String clave) {
        this.ID = ID;
        this.nombre = nombre;
        this.phone = phone;
        this.email = email;
        this.user = user;
        this.status = status;
        this.clave = "";
        this.tarjetaAcceso = generarTarjetaAcceso(); // Generate the access card only once
        this.numerosCuenta = numerosCuenta;
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


        public String getNumerosCuenta() { //Aca da error por que numeros de cuenta es un int[] y aca lo esta retornando como String.
        String cuenta = "";
        for (int i = 0; i < 5; i++) {
            cuenta += "[" + numerosCuenta[i] + "]";
        }
        cuenta += "]\n";

        return numerosCuenta = cuenta;
    }


    public void setNumerosCuenta(int[] numerosCuenta) {
        this.numerosCuenta = numerosCuenta;
    }

    public int[][] getTarjetaAcceso() {
        return tarjetaAcceso;
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


    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("-*-*-*-*-*-*-*-*-*-*-*\n")
                .append(" El id del cliente es: ").append(getID()).append("\n El nombre completo del cliente es: ")
                .append(getNombre()).append("\n El telefono del cliente es: ").append(getPhone())
                .append("\n El correo del cliente es: ").append(getEmail()).append("\n El usuario del cliente: ")
                .append(getUser()).append("\n El estado del cliente es: ").append(getStatus()).append("\nTarjeta de acceso\n");

        int[][] tarjeta = getTarjetaAcceso(); // Retrieve the tarjetaAcceso matrix

        char[] columns = {'A', 'B', 'C', 'D', 'E'};
        sb.append("    ");
        for (int j = 0; j < 5; j++) {
            sb.append("[").append(columns[j]).append("] ");
        }
        sb.append("\n");

        for (int i = 0; i < 4; i++) {
            sb.append("[").append(i + 1).append("] ");
            for (int j = 0; j < 5; j++) {
                sb.append("[").append(tarjeta[i][j]).append("] ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}