import javax.swing.*;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        Cliente[] clienteArray = new Cliente[30];
        Banco banco = new Banco();

//Atributos
//---------------------------------------------------------------------- NOHAY
//Llamado de Funciones Principales
//----------------------------------------------------------------------
        mostrarMenuPrincipal(clienteArray, banco);
    }

    //Funciones Generales
//----------------------------------------------------------------------
    public static int menuGenerico(String mensaje, String titulo, int imagen, String opciones[]) {
        //Menu con botones

        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, imagen, null, opciones, opciones[0]);
    }

    public static Object listaMenuGenerico(String mensaje, String titulo, int imagen, String opciones[]) {
        //Menu en lista

        return JOptionPane.showInputDialog(null, mensaje, titulo, imagen, null, opciones, opciones[0]);
    }

    //Funciones Especificas
    //------------------------------------------------------------------------
    public static void mostrarMenuPrincipal(Cliente[] clienteArray, Banco banco) {
        //MENU PRINCIPAL
        String[] MAIN_MENU_OPTIONS = {"BANCO", "CLIENTES", "SALIR"};
        int choice;
        do {
            String message = "Bienvenido a HiperBanco, tu socio bancario de confianza. ¡Gracias por elegirnos!";
            choice = menuGenerico(message, "Inicio del Sistema", JOptionPane.DEFAULT_OPTION, MAIN_MENU_OPTIONS);//JOptionPane.showOptionDialog(null, message, "Inicio del Sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, MAIN_MENU_OPTIONS, MAIN_MENU_OPTIONS[0]);
            switch (choice) {
                case 0 -> mostrarMenuBanco(clienteArray);
                case 1 -> validateLogin(clienteArray, banco);
                case 2 -> JOptionPane.showMessageDialog(null, "Has elegido la opción SALIR");
            }
        } while (choice != 2);

    }

    public static void mostrarMenuBanco(Cliente[] clienteArray) {
        //MENU BANCO
        String[] BANCO_MENU_OPTIONS = {"Generar datos", "Mostrar clientes", "Mostrar cuentas y movimientos", "Agregar nuevo cliente",
                "Agregar nueva cuenta", "Buscar cliente", "Buscar cuenta", "Generar reportes", "Salir del menú bancario"};
        String choice;
        do {
            choice = (String) listaMenuGenerico("Seleccione una opción:", "Menú Bancario", JOptionPane.PLAIN_MESSAGE, BANCO_MENU_OPTIONS);
            //(String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú Bancario", JOptionPane.PLAIN_MESSAGE, null, BANCO_MENU_OPTIONS, BANCO_MENU_OPTIONS[0]);

            if (choice == null) {
                choice = BANCO_MENU_OPTIONS[BANCO_MENU_OPTIONS.length - 1];
            }
            switch (choice) {
                case "Generar datos" -> {
                    JOptionPane.showMessageDialog(null, "Generar datos");
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos Clientes desea crear?: "));
                    createRandomClientes(n, clienteArray);
                }
                case "Mostrar clientes" -> {
                    JOptionPane.showMessageDialog(null, "Mostrar clientes");
                    mostrarClientes(clienteArray);
                }
                case "Mostrar cuentas y movimientos" -> {
                    JOptionPane.showMessageDialog(null, "Mostrar cuentas y movimientos");
                }
                case "Agregar nuevo cliente" -> {
                    JOptionPane.showMessageDialog(null, "Agregar nuevo cliente");
                    llenar(clienteArray, "");
                    mostrarInfo(clienteArray);
                }
                case "Agregar nueva cuenta" -> {
                    JOptionPane.showMessageDialog(null, "Agregar nueva cuenta");
                }
                case "Buscar cliente" -> {
                    JOptionPane.showMessageDialog(null, "Buscar cliente");
                    buscarCliente(clienteArray);
                }
                case "Buscar cuenta" -> {
                    JOptionPane.showMessageDialog(null, "Buscar cuenta");
                }
                case "Generar reportes" -> {
                    JOptionPane.showMessageDialog(null, "Generar reportes");
                }
                case "Salir del menú bancario" -> {
                    JOptionPane.showMessageDialog(null, "Has elegido la opción SALIR");
                }
            }
        } while (!choice.equals(BANCO_MENU_OPTIONS[BANCO_MENU_OPTIONS.length - 1]));//Compara si el usuario ha elegido o no la opcion "Salir", si no la ha elegido el loop seguira.
        //Solo funciona con Strings
    }

    public static void mostrarMenuClientes(Cliente[] clienteArray) {
        //MENU CLIENTES
        String[] CLIENTES_MENU_OPTIONS = {"Mostrar datos personales", "Modificar datos personales", "Mostrar cuentas y movimientos", "Salir del menu clientes"};
        String choice;
        do {
            choice = (String) listaMenuGenerico("Seleccione una opción:", "Menú Clientes", JOptionPane.PLAIN_MESSAGE, CLIENTES_MENU_OPTIONS); //(String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú Bancario", JOptionPane.PLAIN_MESSAGE, null, BANCO_MENU_OPTIONS, BANCO_MENU_OPTIONS[0]);

            if (choice == null) {
                choice = CLIENTES_MENU_OPTIONS[CLIENTES_MENU_OPTIONS.length - 1];
            }
            switch (choice) {
                case "Mostrar datos personales" -> JOptionPane.showMessageDialog(null, "Mostrar datos personales");
                case "Modificar datos personales" -> JOptionPane.showMessageDialog(null, "Modificar datos personales");
                case "Mostrar cuentas y movimientos" ->
                        JOptionPane.showMessageDialog(null, "Mostrar cuentas y movimientos");
                case "Salir del menu clientes" -> JOptionPane.showMessageDialog(null, "Has elegido la opción SALIR");
            }
        } while (!choice.equals(CLIENTES_MENU_OPTIONS[CLIENTES_MENU_OPTIONS.length - 1]));//Compara si el usuario ha elegido o no la opcion "Salir", si no la ha elegido el loop seguira.
    }

    //--------------------------------------------------------------------------------------------
    //clases y funciones para el menu de banco
    public static boolean areThereClientes(Cliente[] clienteArray) {
        if (clienteArray == null) {
            JOptionPane.showMessageDialog(null, "El array de clientes es nulo");
            return false;
        }

        int count = 0;
        for (int i = 0; i < clienteArray.length; i++) {
            if (clienteArray[i] != null && !clienteArray[i].getID().equals("")) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Hay " + count + " clientes en el sistema");
            return true;
        }
    }

    public static void createRandomClientes(int numClientes, Cliente[] clienteArray) {
        //Generar Clientes Aleatorios Sin Input
        Random random = new Random();
        String[] nombres = {"Juan", "Maria", "Luis", "Ana", "Pablo", "Carla", "Sofia", "Pedro", "Marta", "Diego", "Lucia", "Felipe", "Laura", "Carlos", "Camila", "Jorge", "Isabela", "Gustavo", "Valentina", "Lina", "Andres", "Mariana", "Fabio", "Paola", "Ricardo", "Tatiana", "Gabriel", "Juliana", "Alejandro", "Natalia", "Simon", "Victoria", "Lorenzo", "Jimena", "Emilio", "Daniela", "Roberto", "Olivia", "Mateo", "Agustina", "Ignacio"};
        String[] apellidos = {"Gonzalez", "Rodriguez", "Gomez", "Fernandez", "Perez", "Martinez", "Lopez", "Sanchez", "Romero", "Sosa", "Alvarez", "Diaz", "Torres", "Ruiz", "Hernandez", "Flores", "Acosta", "Silva", "Ramirez", "Molina", "Ortega", "Nunez", "Cabrera", "Garcia", "Castillo", "Vega", "Benitez", "Vargas", "Miranda", "Castro", "Morales", "Vazquez", "Gutierrez", "Aguilar", "Rojas", "Soto", "Alonso", "Valdez", "Luna", "Gimenez", "Ferrari", "Leiva", "Maldonado"};
        String[] emails = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
        String[] userNames = {"user1", "user2", "user3", "user4", "user5"};

        for (int i = 0; i < numClientes; i++) {
            String id = Integer.toString(i + 1);
            String nombre = nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];
            String phone = "3" + String.format("%08d", random.nextInt(99999999));
            String email = nombre.split(" ")[0].toLowerCase() + "." + nombre.split(" ")[1].toLowerCase() + "@" + emails[random.nextInt(emails.length)];
            String user = userNames[random.nextInt(userNames.length)] + Integer.toString(i + 1);
            boolean status = random.nextBoolean();
            clienteArray[i] = new Cliente(id, nombre, phone, email, user, status);
        }
        JOptionPane.showMessageDialog(null, "Clientes generados aleatoriamente");
        JOptionPane.showMessageDialog(null, "Cliente Generado.");
    }

    //Mostrar informacion de todos los clientes agreagdos anteriormente es de la parte de mostrar clientes
    //Anyelo
    public static void mostrarClientes(Cliente[] clienteArray) {
        for (int i = 0; i < indexDatos(clienteArray); i++)
            JOptionPane.showMessageDialog(null, "-*-*-*-*-*-*-*-*-*-*-*\n"
                    + " El correo del cliente es: " + clienteArray[i].getEmail() + "\n El nombre completo del cliente es: "
                    + clienteArray[i].getNombre() + "\n El telefono del cliente es: " + clienteArray[i].getPhone()
                    + "\nEl id del cliente es: " + clienteArray[i].getID() + "\n El usuario del cliente: "
                    + clienteArray[i].getUser() + "\n El tarjeta de acceso: \n" + clienteArray[i].getTarjetaAcceso()
                    + "\n El numero de cuentas: \n" + clienteArray[i].getNumerosCuenta());
    }

    public static void mostrarInfo(Cliente[] clienteArray) {
        for (int i = 0; i < indexDatos(clienteArray); i++)
            System.out.println( "-*-*-*-*-*-*-*-*-*-*-*\n"
                    + " El correo del cliente es: " + clienteArray[i].getEmail() + "\n El nombre completo del cliente es: "
                    + clienteArray[i].getNombre() + "\n El telefono del cliente es: " + clienteArray[i].getPhone()
                    + "\nEl id del cliente es: " + clienteArray[i].getID() + "\n El usuario del cliente: "
                    + clienteArray[i].getUser() + "\n El tarjeta de acceso: \n" + clienteArray[i].getTarjetaAcceso()
                    + "\n El numero de cuentas: \n" + clienteArray[i].getNumerosCuenta()
                    + "Tarjeta de acceso\n" + clienteArray[i].getTarjetaAcceso() + "Tarjeta de numeros de cuenta " + clienteArray[i].getNumerosCuenta());
    }

    public static boolean validateLogin(Cliente[] clienteArray, Banco banco) {
        boolean hayClientes = areThereClientes(clienteArray); //Comprueba si hay clientes
        //El login del menu de Clientes
        if (hayClientes) {
            while (true) {

                // Input pidiendo el nombre de usuario
                String username = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");

                // Compara si existe el usuario en la lista de usuarios
                boolean userExists = false;
                Cliente currentCliente = null;
                for (int i = 0; i < clienteArray.length; i++) {
                    if (clienteArray[i].getUser().equals(username)) {
                        userExists = true;
                        currentCliente = clienteArray[i];
                        JOptionPane.showMessageDialog(null, "Usuario encontrado.");
                        break;
                    }
                }
                // Si el usuario no existe
                if (!userExists) {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    continue;// Usado en vez de break para no terminar el loop
                }

                // Pide al usuario ingresar los valores de la tarjeta
                String accessCardInput = JOptionPane.showInputDialog(null, "Ingrese su tarjeta de acceso en el formato XX-XX-XX:");
                String[] accessCardValues = accessCardInput.split("-");
                if (accessCardValues.length != 3) {
                    JOptionPane.showMessageDialog(null, "Tarjeta de acceso no válida.");
                    continue;
                }

                // Compara los datos introducidos con el de la tarjeta de acceso
                int[][] accessCard = banco.getAccessCard();
                boolean accessCardCorrect = true;
                for (int i = 0; i < accessCardValues.length; i++) {
                    int value = Integer.parseInt(accessCardValues[i]);
                    boolean valueFound = false;
                    for (int j = 0; j < accessCard[i].length; j++) {
                        if (accessCard[i][j] == value) {
                            valueFound = true;
                            break;
                        }
                    }
                    if (!valueFound) {
                        accessCardCorrect = false;
                        break;
                    }
                }

                if (!accessCardCorrect) {
                    JOptionPane.showMessageDialog(null, "Tarjeta de acceso incorrecta.");
                    continue;
                }

                // Busca si el usuario esta activo
                if (!currentCliente.isStatus()) {
                    JOptionPane.showMessageDialog(null, "Usuario inactivo.");
                    continue;
                }

                JOptionPane.showMessageDialog(null, "Acceso concedido.");
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen clientes");
            return false;
        }
    }

    //Aqui  lo que se realiza es un ingreso de los datos de los clientes
    //Anyelo
    public static void llenar(Cliente[] clienteArray, String email) {

        //El if lo que realiza es un index del vector si el vector esta lleno nos indicara que el limite esta lleno
        if (indexDatos(clienteArray) == -1) {
            JOptionPane.showMessageDialog(null,
                    "Limite de clientes alcansado");
            return;
        }

        if (email.equals("")) {
            email = JOptionPane.showInputDialog("Correo del cliente: ");
        }
        // Aqui se realiza la verificaion del ID si el ID esta repetido nos mandara a un else que es un boton

        if (verificarCorreo(email)) { // TRUE or FALSE

            String ID = JOptionPane.showInputDialog("Id del cliente: ");
            if (buscarClienteId(clienteArray, ID) == null) {

                String user = "";

                String nombre = JOptionPane.showInputDialog("Nombre del cliente: ");

                String phone = JOptionPane.showInputDialog("Telefono del cliente\n   Formato: 0000-0000 : ");

                int index = indexDatos(clienteArray);

                clienteArray[index] = new Cliente(
                        ID, email, nombre, phone, user, true);

                JOptionPane.showMessageDialog(null,
                        "-*-*Cliente agregado con exito-*-*");

            } else {

                //boton el cual indica que el ID esta en el sistema, asi nos dara dos opciones
                //agregar otro ID o cancelar el ingreso de la informacion
                int opt = mostrarBotones(
                        "El cliente con el id: " + ID + " ya esta en el sistema",
                        "Codigo Repetido",
                        JOptionPane.WARNING_MESSAGE,
                        new String[]{"Nuevo codigo", "Cancelar"});

                if (opt == 0) {
                    llenar(clienteArray, email);
                }
            }
        } else {
            int opt = mostrarBotones(
                    "El cliente con el email: " + email + " es incorrecto",
                    "Email invalido",
                    JOptionPane.WARNING_MESSAGE,
                    new String[]{"Nuevo email", "Cancelar"});

            if (opt == 0) {
                llenar(clienteArray, "");
            }

        }
    }

    //Anyelo
    public static int indexDatos(Cliente[] clienteArray) {
        for (int i = 0; i < clienteArray.length; i++) {
            if (clienteArray[i] == null) {
                return i;
            }
        }
        return -1;
    }

    //boton para poder agregar un nuevo Id o correo en este caso
    public static int mostrarBotones(
            String mensaje,
            String titulo,
            int imagen,
            String botones[]) {

        return JOptionPane.showOptionDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                imagen,
                null,
                botones,
                botones[0]); // 0-1-2-3...

    }

    // el buscar cliente id lo utilizaremos para los botones en la parte de llenar informacion
    //Anyelo

    public static Cliente buscarClienteId(Cliente[] clienteArray, String id) {
        for (int i = 0; i < clienteArray.length; i++) {
            if (clienteArray != null) {
                if (clienteArray[i] == null) {
                    return null;
                }
                if (clienteArray[i].getID().equals(id)) {
                    return clienteArray[i];
                }
            }
        }
        return null;
    }

    //buscamos en la matriz de clientes para mostrar la informacion del cliente buscado esto es de la parte de buscar cliente
    //Anyelo
    public static void buscarCliente(Cliente[] clienteArray) {
        // Buscamos
        String id = JOptionPane.showInputDialog("Ingrese su Id: ");

        Cliente cliente = buscarClienteId(clienteArray, id);

        if (cliente == null) {

            JOptionPane.showMessageDialog(null,
                    "-*-*Cliente no exite-*-*");

        } else {
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*\n"
                    + " El correo del cliente es: " + cliente.getEmail() + "\n El nombre completo del cliente es: "
                    + cliente.getNombre() + "\n El telefono del cliente es: " + cliente.getPhone()
                    + "\nEl id del cliente es: " + cliente.getID() + "\n El usuario del cliente: "
                    + cliente.getUser() + "\n El tarjeta de acceso: \n" + cliente.getTarjetaAcceso()
                    + "\n El numero de cuentas: \n" + cliente.getNumerosCuenta()
                    + "Tarjeta de acceso\n" + cliente.getTarjetaAcceso() + "Tarjeta de numeros de cuenta " + cliente.getNumerosCuenta());

        }
    }

    // aqui igual el verificado es para utilizarlo en la parte de llenar informacion
    //Anyelo
    public static boolean verificarCorreo( String email) {

        // Expresión regular para validar el correo electrónico
        String pattern = "[^@]+@[^@]+\\.[^@]+";

        if (email.matches(pattern)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico agregado correctamente");
            return true;

        }else {
            return false;
        }

    }
}