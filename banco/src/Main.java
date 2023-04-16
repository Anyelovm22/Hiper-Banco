import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Anyelo Y Jostin
 */
public class Main {
    public static void main(String[] args) {
        //Listas
        //----------------------------------------------------------------------
        Cliente[] clienteArray = new Cliente[30];
        //Cliente clienteToValidate = clienteArray[0];
        //Llamado de Funciones Principales
        //----------------------------------------------------------------------
        mostrarMenuPrincipal(clienteArray);
    }
    //Funciones Generales
    //----------------------------------------------------------------------
    public static int menuGenerico(String mensaje, String titulo, int imagen, String[] opciones) {
        //Menu con botones
        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, imagen, null, opciones, opciones[0]);
    }
    public static Object listaMenuGenerico(String mensaje, String titulo, int imagen, String[] opciones) {
        //Menu en lista
        return JOptionPane.showInputDialog(null, mensaje, titulo, imagen, null, opciones, opciones[0]);
    }
    //Funciones Especificas
    //------------------------------------------------------------------------
    public static void mostrarMenuPrincipal(Cliente[] clienteArray) {
        //MENU PRINCIPAL
        String[] MAIN_MENU_OPTIONS = {"BANCO", "CLIENTES", "SALIR"};
        int choice;
        do {
            String message = "Bienvenido a HiperBanco, tu socio bancario de confianza. ¡Gracias por elegirnos!";
            choice = menuGenerico(message, "Inicio del Sistema", JOptionPane.DEFAULT_OPTION, MAIN_MENU_OPTIONS);//JOptionPane.showOptionDialog(null, message, "Inicio del Sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, MAIN_MENU_OPTIONS, MAIN_MENU_OPTIONS[0]);
            switch (choice) {
                case 0 ->
                        mostrarMenuBanco(clienteArray);
                case 1 ->
                        validateLogin(clienteArray, "" );
                case 2 ->
                        JOptionPane.showMessageDialog(null, "Has elegido la opción SALIR");
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
                    createRandomClientes(clienteArray);
                }
                case "Mostrar clientes" -> {
                    JOptionPane.showMessageDialog(null, "Mostrar clientes");
                    mostrarClientes(clienteArray);
                }
                case "Mostrar cuentas y movimientos" -> //NO MUESTRA AUN
                        JOptionPane.showMessageDialog(null, "Mostrar cuentas y movimientos");
                case "Agregar nuevo cliente" -> {
                    JOptionPane.showMessageDialog(null, "Agregar nuevo cliente");
                    agregarCliente(clienteArray, "");
                }
                case "Agregar nueva cuenta" -> {//NO MUESTRA
                    JOptionPane.showMessageDialog(null, "Agregar nueva cuenta");
                    agregarCuenta(clienteArray,"");
                }
                case "Buscar cliente" -> {
                    JOptionPane.showMessageDialog(null, "Buscar cliente");
                    buscarCliente(clienteArray, "", "", "");
                }
                case "Buscar cuenta" -> //NO MUESTRA
                        JOptionPane.showMessageDialog(null, "Buscar cuenta");
                case "Generar reportes" -> //NO MUESTRA
                        JOptionPane.showMessageDialog(null, "Generar reportes");
                case "Salir del menú bancario" -> JOptionPane.showMessageDialog(null, "Has elegido la opción SALIR");
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
                case "Mostrar datos personales" ->
                        JOptionPane.showMessageDialog(null, "Mostrar datos personales");
                case "Modificar datos personales" ->
                        JOptionPane.showMessageDialog(null, "Modificar datos personales");
                case "Mostrar cuentas y movimientos" ->
                        JOptionPane.showMessageDialog(null, "Mostrar cuentas y movimientos");
                case "Salir del menu clientes" ->
                        JOptionPane.showMessageDialog(null, "Has elegido la opción SALIR");
            }
        } while (!choice.equals(CLIENTES_MENU_OPTIONS[CLIENTES_MENU_OPTIONS.length - 1]));//Compara si el usuario ha elegido o no la opcion "Salir", si no la ha elegido el loop seguira.
    }
    //--------------------------------------------------------------------------------------------
    //clases y funciones para el menu de banco
    public static boolean areThereClientes(Cliente[] clienteArray) {
        if (clienteArray == null) {
            System.out.println("El array de clientes es nulo, sera redirigido a registrarse");
            JOptionPane.showMessageDialog(null, "El array de clientes es nulo, sera redirigido a registrarse");
            return false;
        }
        int count = 0;
        for (Cliente cliente : clienteArray) {
            if (cliente != null && !cliente.getID().equals("")) {
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
    // Declare userNumber as a class-level variable
    private static int userNumber = 40;
    //Generar Clientes Aleatorios Sin Input
    public static void createRandomClientes(Cliente[] clienteArray) {
        int numClientes;
        String input = JOptionPane.showInputDialog("Cuantos Clientes desea crear?: ");
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
            return;
        }
        numClientes = Integer.parseInt(input);
        if (indexDatos(clienteArray) == -1) {
            JOptionPane.showMessageDialog(null, "Limite de clientes alcanzado");
            return;
        }
        if (numClientes > clienteArray.length - indexDatos(clienteArray)) {
            int espaciosDisponibles = clienteArray.length - indexDatos(clienteArray);
            JOptionPane.showMessageDialog(null, "La cantidad de clientes deseada excede el límite del array. Espacios disponibles: " + espaciosDisponibles);
            return;
        }
        Random random = new Random();
        String[] emails = {"gmail.com", "yahoo.com", "hotmail.com   ", "outlook.com"};
        String[] nombres = {"Esteban", "Fatima", "Anthonny", "Anyelo", "Juan", "Maria", "Luis", "Ana", "Pablo", "Carla", "Sofia", "Pedro", "Marta", "Diego", "Lucia", "Felipe", "Laura", "Carlos", "Camila", "Jorge", "Isabela", "Gustavo", "Valentina", "Lina", "Andres", "Mariana", "Fabio", "Paola", "Ricardo", "Tatiana", "Gabriel", "Juliana", "Alejandro", "Natalia", "Simon", "Victoria", "Lorenzo", "Jimena", "Emilio", "Daniela", "Roberto", "Olivia", "Mateo", "Agustina", "Ignacio"};
        String[] apellidos = {"Chinchilla", "Perez", "Merlo", "Vargas", "Gonzalez", "Rodriguez", "Gomez", "Fernandez", "Perez", "Martinez", "Lopez", "Sanchez", "Romero", "Sosa", "Alvarez", "Diaz", "Torres", "Ruiz", "Hernandez", "Flores", "Acosta", "Silva", "Ramirez", "Molina", "Ortega", "Nunez", "Cabrera", "Garcia", "Castillo", "Vega", "Benitez", "Vargas", "Miranda", "Castro", "Morales", "Vazquez", "Gutierrez", "Aguilar", "Rojas", "Soto", "Alonso", "Valdez", "Luna", "Gimenez", "Ferrari", "Leiva", "Maldonado"};
        for (int i = 0; i < numClientes; i++) {
            int id = random.nextInt(900000000) + 100000000;
            String ID = String.valueOf(id);
            String nombre = nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];
            String phone = "3" + String.format("%08d", random.nextInt(99999999));
            // Email validation
            String email;
            boolean isEmailDuplicate = false;
            do {
                email = nombre.split(" ")[0].toLowerCase() + "." + nombre.split(" ")[1].toLowerCase() + "@" + emails[random.nextInt(emails.length)];
                for (Cliente cliente : clienteArray) {
                    if (cliente != null && cliente.getEmail().equalsIgnoreCase(email)) {
                        isEmailDuplicate = true;
                        break;
                    }
                }
                if (isEmailDuplicate) {
                    String[] emailParts = email.split("@");
                    String emailName = emailParts[0];
                    String emailDomain = emailParts[1];
                    int randomNum = random.nextInt(100);
                    if (randomNum < 50) {
                        emailName += "_" + random.nextInt(100);
                    } else {
                        emailName += "-" + (char) (random.nextInt(26) + 'a');
                    }
                    email = emailName + "@" + emailDomain;
                }
            } while (isEmailDuplicate);
            String user = nombre.split(" ")[0].toLowerCase()+ userNumber; // Set username as just the first name without spaces
            boolean status = true;
            int index = indexDatos(clienteArray);
            clienteArray[index] = new Cliente(ID, nombre, phone, email, user, status);
            userNumber++; // Incrementa el número de usuarios para el siguiente usuario
        }
        JOptionPane.showMessageDialog(null, "Clientes generados aleatoriamente");
    }

    private static int accountNumber = 4710;


    //Registro de Cuenta Manualmente
    public static void agregarCuenta(Cliente[] clienteArray,String ID){
        int[] cuentas = new int[5];

        if (ID.equals("")) {
            ID = JOptionPane.showInputDialog("Id del cliente: ");
        }
        Cliente temporal = buscarClienteId(clienteArray, ID);
        if (temporal != null) {
            while (true){
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Cuántas cuentas desea agregar? (Ingrese 0 para salir)"));
                if (cantidad == 0) {
                    break; // salir del bucle si el usuario ingresa 0
                }
                for (int i = 0; i < cantidad; i++) {
                    if (accountNumber == 5) {
                        System.out.println("El límite de cuentas ha sido alcanzado");
                        break; // salir del bucle si se alcanza el límite de cuentas
                    }
                }
                cuentas[accountNumber] = accountNumber + 1; // agregar cuenta al arreglo
                accountNumber++; // incrementar contador de cuentas agregadas
                System.out.println("Cuenta " + (accountNumber) + " agregada");
            }
            System.out.println("Cuentas agregadas:");
            for (int i = 0; i < accountNumber; i++) {
                System.out.println(cuentas[i]);
            }
            int index = indexDatos(clienteArray);
            JOptionPane.showMessageDialog(null, "-*-*Cliente agregado con exito-*-*");
            clienteArray[index] = new Cliente(ID, temporal.getNombre(), temporal.getNombre(), temporal.getNombre(),
                    temporal.getNumerosCuenta(), true);
            System.out.println(clienteArray[index].info());
        } else {
            //boton el cual indica que el ID esta en el sistema, asi nif (ID.equals("")) {
        //            ID = JOptionPane.showInputDialog("Id del cliente: ");
        //        }
        //        Cliente temporal = buscarClienteId(clienteArray, ID);os dara dos opciones
            //agregar otro ID o cancelar el ingreso de la informacion
            int opt = menuGenerico("El cliente con el id: " + ID + " ya esta en el sistema", "Codigo Repetido",
                    JOptionPane.WARNING_MESSAGE, new String[] { "Nuevo codigo", "Cancelar" });
            if (opt == 0) {
                agregarCuenta(clienteArray,"");
            }
        }
    }

    //Registro de Clientes Manualmente
    public static void agregarCliente(Cliente[] clienteArray, String email) {
        //El if lo que realiza es un index del vector si el vector esta lleno nos indicara que el limite esta lleno
        if (indexDatos(clienteArray) == -1) {
            JOptionPane.showMessageDialog(null, "Limite de clientes alcanzado");
            return;
        }
        if (email.equals("")) {
            boolean isDuplicateEmail = true;
            while (isDuplicateEmail) {
                email = JOptionPane.showInputDialog("Correo del cliente: ");
                // Verificar si el email ya está en uso por otro cliente en clienteArray
                boolean isEmailDuplicate = false;
                for (Cliente cliente : clienteArray) {
                    if (cliente != null && cliente.getEmail().equals(email)) {
                        isEmailDuplicate = true;
                        break;
                    }
                }
                if (isEmailDuplicate) {
                    int opt = menuGenerico("El email: " + email + " ya está en uso por otro cliente",
                            "Email Duplicado",
                            JOptionPane.WARNING_MESSAGE,
                            new String[]{"Nuevo email", "Cancelar"});
                    if (opt == 1) {
                        return; // Cancelar el ingreso de la información
                    }
                } else {
                    isDuplicateEmail = false;
                }
            }
        }
        // Aqui se realiza la verificaion del ID si el ID esta repetido nos mandara a un else que es un boton
        if (verificarCorreo(email)) { // TRUE or FALSE
            String ID = JOptionPane.showInputDialog("Id del cliente: ");
            if (buscarClienteId(clienteArray, ID) == null) {
                String nombre = JOptionPane.showInputDialog("Nombre del cliente: ");
                String phone = JOptionPane.showInputDialog("Telefono del cliente\n   Formato: 0000-0000 : ");
                // Generate username based on the name of the client
                String user = nombre.split(" ")[0].toLowerCase()+ userNumber;
                int index = indexDatos(clienteArray);
                clienteArray[index] = new Cliente(ID, nombre, phone, email, user, true);
                JOptionPane.showMessageDialog(null, "-*-*Cliente agregado con exito-*-*");
                System.out.println(clienteArray[index].info());
                userNumber++; // Increment userNumber for the next user
            } else {
                //boton el cual indica que el ID esta en el sistema, asi nos dara dos opciones
                //agregar otro ID o cancelar el ingreso de la informacion
                int opt = menuGenerico("El cliente con el id: " + ID + " ya esta en el sistema", "Codigo Repetido",
                        JOptionPane.WARNING_MESSAGE, new String[] { "Nuevo codigo", "Cancelar" });
                if (opt == 0) {
                    agregarCliente(clienteArray, email);
                }
            }
        } else {
            int opt = menuGenerico("El cliente con el email: " + email + " es incorrecto", "Email invalido",
                    JOptionPane.WARNING_MESSAGE, new String[] { "Nuevo email", "Cancelar" });
            if (opt == 0) {
                agregarCliente(clienteArray, "");
            }
        }
    }
    //Mostrar informacion de todos los clientes agreagdos anteriormente es de la parte de mostrar clientes
    //Anyelo
    public static void mostrarClientes(Cliente[] clienteArray) {
        int x = indexDatos(clienteArray) == -1
                ? clienteArray.length : indexDatos(clienteArray);
        for (int i = 0; i < x; i++) {
            System.out.println(clienteArray[i].info());
        }
    }

    public static void validateLogin(Cliente[] clienteArray, String username) {
        boolean areClientes = areThereClientes(clienteArray);
        if (!areClientes) {
            int opt = menuGenerico("Deseas ser redirigido a crear cliente?",
                    "Acceso no permitido",
                    JOptionPane.WARNING_MESSAGE,
                    new String[]{"Crear un cliente", "Cancelar"});
            if (opt == 0) {
                agregarCliente(clienteArray, "");
            } else {
                return;
            }
        }
        if (areClientes) {
            if (username.equals("")) {
                username = JOptionPane.showInputDialog("Ingrese el nombre de usuario del cliente: ");
            }
            Cliente temporal = buscarClienteUsuario(clienteArray, username);
            if (temporal != null) {
                validateAccessCard(temporal); // Use 'temporal' instead of looping through clienteArray
            } else {
                int opt = menuGenerico(
                        "El cliente con el usuario: " + username + " no está en el sistema",
                        "ID incorrecto",
                        JOptionPane.WARNING_MESSAGE,
                        new String[]{"Intentarlo de nuevo", "Cancelar"});
                if (opt == 0) {
                    validateLogin(clienteArray, "");
                }
            }
        }
    }

    //TEST
    public static boolean validateAccessCard(Cliente cliente) {
        int[][] accessCard = cliente.getTarjetaAcceso();
        int successfulAttempts = 0; // Counter for successful attempts

        // Loop to prompt for values three times
        while (successfulAttempts < 3) {
            // Get a random position on the access card
            Random random = new Random();
            int row = random.nextInt(4); // 4 rows (0 to 3)
            int col = random.nextInt(5); // 5 columns (0 to 4)

            // Convert column index to letter representation
            char colLetter = (char) ('A' + col);

            // Show input dialog to prompt user for value at the random position
            String input = JOptionPane.showInputDialog(null,
                    "Ingrese el valor en la posición " + colLetter + (row + 1) + ":",
                    "Validación de tarjeta de acceso", JOptionPane.INFORMATION_MESSAGE);

            if (input != null) {
                // Parse input to integer
                int inputValue;
                try {
                    inputValue = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Acceso denegado. El valor ingresado es incorrecto.",
                            "Validación de tarjeta de acceso", JOptionPane.ERROR_MESSAGE);
                    continue; // Prompt again if input is invalid
                }

                // Get the corresponding value on the access card
                int accessCardValue = cliente.getTarjetaAcceso()[row][col];

                // Validate input against access card value
                if (inputValue == accessCardValue) {
                    JOptionPane.showMessageDialog(null,
                            "¡Acceso concedido!",
                            "Validación de tarjeta de acceso", JOptionPane.INFORMATION_MESSAGE);
                    successfulAttempts++; // Increment successful attempts counter
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Acceso denegado. El valor ingresado es incorrecto.",
                            "Validación de tarjeta de acceso", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                break; // Cancel button was clicked, exit loop
            }
        }

        // Check if all three attempts were successful
        if (successfulAttempts == 3) {
            return true; // Grant access
        } else {
            return false; // Deny access
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
    public static Cliente buscarClienteUsuario(Cliente[] clienteArray, String username) {
        for (int i = 0; i < clienteArray.length; i++) {
            if (clienteArray != null) {
                if (clienteArray[i] == null) {
                    return null;
                }
                if (clienteArray[i].getUser().equals(username)) {
                    return clienteArray[i];
                }
            }
        }
        return null;
    }
    //buscamos en la matriz de clientes para mostrar la informacion del cliente buscado esto es de la parte de buscar cliente
    public static void buscarCliente(Cliente[] clienteArray, String ID, String email, String remplazo) {
        // Buscamos
        if (ID.equals("")) {
            ID = JOptionPane.showInputDialog("Id del cliente: ");
        }
        Cliente temporal = buscarClienteId(clienteArray, ID);
        if (temporal != null) {
            int opt = menuGenerico(
                    "Elija la opcion que deseas realizar",
                    "Bienvenid@ " + temporal.getNombre(),
                    JOptionPane.WARNING_MESSAGE,
                    new String[]{"[Actualizar Informacion]", "[Activar-Desactivar]", "[Botones de Cuentas]", "[Cancelar]"});
            if (opt == 0) {
                int opt1 = menuGenerico(
                        "Elija la opcion que deseas realizar",
                        "",
                        JOptionPane.WARNING_MESSAGE,
                        new String[]{"[Nombre completo]", "[Teléfono]", "[Correo]", "[Cancelar]"});
                if (opt1 == 0) {
                    temporal.setNombre(JOptionPane.showInputDialog(null, "Tu nombre actual es "
                            + temporal.getNombre() + "\n Cual sera el nuevo nombre por el que lo deseas cambiar: "));
                    buscarCliente(clienteArray, ID, email, remplazo);
                }
                if (opt1 == 1) {
                    temporal.setPhone(JOptionPane.showInputDialog(null, "Tu telefono actual es "
                            + temporal.getPhone() + "\n Cual sera el nuevo numero telefonico por el que lo deseas cambiar: "));
                    buscarCliente(clienteArray, ID, email, remplazo);
                }
                if (opt1 == 2) {
                    remplazo = (JOptionPane.showInputDialog(null, "Tu correo actual es "
                            + temporal.getEmail() + "\n Cual sera el nuevo correo por el que lo deseas cambiar: "));
                    if (verificarCorreo(remplazo)) {
                        temporal.setEmail(remplazo);
                        JOptionPane.showMessageDialog(null, "Correo modificado correctamente");
                        buscarCliente(clienteArray, ID, email, remplazo);
                    } else {
                        opt1 = menuGenerico(
                                "El cliente con el email: " + email + " es incorrecto",
                                "Email invalido",
                                JOptionPane.WARNING_MESSAGE,
                                new String[]{"Nuevo email", "Cancelar"});
                        if (opt1 == 0) {
                            buscarCliente(clienteArray, ID, email, "");
                        }
                    }
                }
            }
            if (opt == 1) {
                if (temporal.getStatus()) {
                    int opt2 = menuGenerico(
                            "El estado del cliente es: Activo",
                            "Deseas poner en estado Inactivo",
                            JOptionPane.WARNING_MESSAGE,
                            new String[]{"Desactivar", "Cancelar"});
                    if (opt2 == 0) {
                        temporal.setStatus(false);
                        buscarCliente(clienteArray, ID, email, remplazo);
                    }
                } else if (!temporal.getStatus()) {
                    int opt3 = menuGenerico(
                            "El estado del cliente es: Inactivo",
                            "Deseas poner en estado Activo",
                            JOptionPane.WARNING_MESSAGE,
                            new String[]{"Activar", "Cancelar"});
                    if (opt3 == 0) {
                        temporal.setStatus(true);
                        buscarCliente(clienteArray, ID, email, remplazo);
                    }
                }
            }
            if (opt == 2) {
                System.out.println("Botones de Cuentas");
            }
        } else {
            int opt = menuGenerico(
                    "El cliente con el ID: " + ID + " no esta en el sistema",
                    "ID incorrecto",
                    JOptionPane.WARNING_MESSAGE,
                    new String[]{"Nuevo ID", "Cancelar"});
            if (opt == 0) {
                buscarCliente(clienteArray, "", email, "");
            }
        }
    }
    // aqui igual el verificado es para utilizarlo en la parte de llenar informacion
    //Anyelo
    public static boolean verificarCorreo(String email) {
        // Expresión regular para validar el correo electrónico
        String pattern = "[^@]+@[^@]+\\.[^@]+";
        return email.matches(pattern);

    }
}