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

    public String getNumerosCuenta() {
        String cuenta = "";
        for (int i = 0; i < 5; i++) {
            cuenta += "[" + numerosCuenta[i] + "]";
        }
        cuenta += "]\n";

        return cuenta;
    }


    public void setNumerosCuenta(int[] numerosCuenta) {
        this.numerosCuenta = numerosCuenta;
    }

    //public int[][] getTarjetaAcceso() {
    //    return tarjetaAcceso;
   // }

    //public void setTarjetaAcceso(int[][] tarjetaAcceso) {
        //this.tarjetaAcceso = generarTarjetaAcceso();
    //}


   public String getTarjetaAcceso() {  //CAMBIAR FORMATO Y
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

//    public void setTarjetaAcceso(int[][] tarjetaAcceso) {
//        this.tarjetaAcceso = tarjetaAcceso;
//    }

    //Generamos la tarjeta de acceso aleatorio

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
