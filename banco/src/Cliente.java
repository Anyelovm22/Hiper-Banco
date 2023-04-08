import java.util.Random;

public class Cliente {

    private String ID;
    private String nombre;
    private String phone;
    private String email;
    private String user;
    private String clave;
    private boolean status;
    private int[][] tarjetaAcceso;//Anyelo
    private int[] numerosCuenta; //Anyelo

    public Cliente(String ID, String nombre, String phone, String email, String user, boolean status) {
        this.ID = ID;
        this.nombre = nombre;
        this.phone = phone;
        this.email = email;
        this.user = generarUsuario(nombre);
        this.status = status;
        this.clave = ""; //Anyelo
        this.tarjetaAcceso = generarTarjetaAcceso();//Anyelo
        this.numerosCuenta = numerosCuenta;//Anyelo
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    //Anyelo
    public String getClave() {
        return clave;
    }

    //Anyelo
    public void setClave(String clave) {
        this.clave = clave;
    }


    //Anyelo
    public String getNumerosCuenta() {
        String cuenta = "";
        for (int i = 0; i < 5; i++) {
            cuenta += "[" + numerosCuenta[i] + "]";
        }
        cuenta += "]\n";

        return cuenta;
    }


    //Anyelo
    public void setNumerosCuenta(int[] numerosCuenta) {
        this.numerosCuenta = numerosCuenta;
    }


    //Anyelo
    public String getTarjetaAcceso() {
            String acceso = "";
            acceso += "\n";
            for (int i = 0; i < 4; i++) {
                acceso += "[";
                for (int j = 0; j < 5; j++) {
                    acceso += "[" + tarjetaAcceso[i][j] + "]";
                }
                acceso += "]\n";

            }

            return acceso;
        }

    //Anyelo
    public void setTarjetaAcceso(int[][] tarjetaAcceso) {
        this.tarjetaAcceso = tarjetaAcceso;
    }


    //Generamos la tarjeta de acceso aleatorio
    //Anyelo
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

    private String generarUsuario(String nombre) {
        String id = Integer.toString( 1);
        String[] user = nombre.split(" ");
        String usuario = user[0] + (40+id);
        return usuario;
    }
}