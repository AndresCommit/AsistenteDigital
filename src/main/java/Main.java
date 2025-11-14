import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GestorConfiguracion gestor = new GestorConfiguracion();

        // 1. Cargamos la configuración guardada al iniciar la app
        System.out.println("Iniciando asistente...");
        String urlActual = gestor.cargarConfig();

        if (urlActual == null) {
            System.err.println("Error crítico: No se pudo cargar la configuración. Saliendo.");
            return; // Salir si la carga inicial falló
        }

        int opcion = -1;

        do {
            System.out.println("\n--- MENÚ DE PRUEBA (CONFIGURACIÓN) ---");
            // Esta será la futura "Opción 3" de tu práctica
            System.out.println("1. Ver/Modificar URL del feed");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                // Leemos la línea completa y la convertimos a número
                // Esto evita problemas si el usuario introduce texto
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; // Si introduce letras, será una opción inválida
            }

            switch (opcion) {
                case 1:
                    // Mostramos la URL que tenemos cargada en memoria
                    System.out.println("La URL del feed actual es: " + urlActual);
                    System.out.print("Introduce la nueva URL (deja en blanco para no cambiar): ");

                    String nuevaUrl = entrada.nextLine();

                    // Si la entrada no está vacía...
                    if (nuevaUrl != null && !nuevaUrl.trim().isEmpty()) {
                        // ...la guardamos en el fichero
                        gestor.guardarConfig(nuevaUrl);
                        // ...y actualizamos nuestra variable local
                        urlActual = nuevaUrl;
                        System.out.println("Configuración guardada correctamente.");
                    } else {
                        System.out.println("No se han realizado cambios.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 0);

        entrada.close();
    }
}
