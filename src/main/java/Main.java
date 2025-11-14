import java.util.List; // Añade esta importación
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GestorConfiguracion gestor = new GestorConfiguracion();
        int opcion;
        LectorRSS lector = new LectorRSS();

        System.out.println("Iniciando asistente...");
        String urlActual = gestor.cargarConfig();

        do {
            System.out.println("\n--- Menú Asistente Digital ---");
            System.out.println("1. Probar LectorRSS");
            System.out.println("3. Ver/Modificar URL del feed");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Conectando al feed: " + urlActual + "...");

                    List<Noticia> noticiasLeidas = lector.parseFeed(urlActual);

                    if (noticiasLeidas == null || noticiasLeidas.isEmpty()) {
                        System.out.println("No se han encontrado noticias o hubo un error.");
                    } else {
                        System.out.println("¡Éxito! Se han encontrado " + noticiasLeidas.size() + " noticias.");

                        // Mostramos la primera para comprobar
                        Noticia primeraNoticia = noticiasLeidas.get(0);
                        System.out.println("--- EJEMPLO DE LA PRIMERA NOTICIA ---");
                        System.out.println("Título: " + primeraNoticia.getTitulo());
                        System.out.println("Link: " + primeraNoticia.getLink());
                        System.out.println("Fuente (Autor): " + primeraNoticia.getFuente());
                        System.out.println("Fecha (Long): " + primeraNoticia.getFecha());
                    }
                    break;
                // ---
                case 3:
                    // 1. Mostramos la URL que tenemos cargada en memoria
                    System.out.println("La URL del feed actual es: " + urlActual);
                    System.out.print("Introduce la nueva URL (deja en blanco para no cambiar): ");

                    // 2. Leemos la entrada del usuario
                    String nuevaUrl = entrada.nextLine();

                    // 3. Comprobamos si la entrada no está vacía
                    if (nuevaUrl != null && !nuevaUrl.trim().isEmpty()) {

                        // 4. Si hay texto, la guardamos en el fichero
                        gestor.guardarConfig(nuevaUrl);

                        // 5. Y actualizamos la variable que usamos en el programa
                        urlActual = nuevaUrl;
                        System.out.println("Configuración guardada correctamente.");
                    } else {
                        // 6. Si el usuario pulsó Enter sin escribir nada
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