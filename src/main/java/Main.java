import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        GestorConfiguracion gestor = new GestorConfiguracion();
        LectorRSS lector = new LectorRSS();

        System.out.println("Iniciando asistente...");
        String urlActual = gestor.cargarConfig();

        if (urlActual == null) {
            System.err.println("Error crítico: No se pudo cargar la configuración. Saliendo.");
            return;
        }

        int opcion = -1;

        do {
            System.out.println("\n--- ASISTENTE DIGITAL DE NOTICIAS ---");
            System.out.println("1. Actualizar noticias desde el feed"); // Opción 1 de la práctica
            System.out.println("3. Ver/Modificar URL del feed");    // Opción 3 de la práctica
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                // --- ¡AQUÍ ESTÁ LA CORRECCIÓN! ---
                // Leemos la línea entera y la convertimos a número.
                // Esto evita el error de "salto" del nextLine().
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; // Si introduce letras, será una opción inválida
            }

            switch (opcion) {
                case 1:
                    System.out.println("Conectando al feed: " + urlActual + "...");
                    List<Noticia> noticiasLeidas = lector.parseFeed(urlActual);

                    if (noticiasLeidas == null || noticiasLeidas.isEmpty()) {
                        System.out.println("No se han encontrado noticias o hubo un error.");
                    } else {
                        System.out.println("¡Éxito! Se han encontrado " + noticiasLeidas.size() + " noticias.");
                        Noticia primeraNoticia = noticiasLeidas.get(0);
                        System.out.println("--- EJEMPLO DE LA PRIMERA NOTICIA ---");
                        System.out.println("Título: " + primeraNoticia.getTitulo());
                        System.out.println("Link: " + primeraNoticia.getLink());
                        System.out.println("Fuente (Autor): " + primeraNoticia.getFuente());
                        System.out.println("Fecha (Long): " + primeraNoticia.getFecha());
                    }
                    break;

                case 3:
                    // Este código AHORA SÍ funcionará
                    System.out.println("La URL del feed actual es: " + urlActual);
                    System.out.print("Introduce la nueva URL (deja en blanco para no cambiar): ");

                    // Esta línea ya no se "saltará"
                    String nuevaUrl = entrada.nextLine();

                    if (nuevaUrl != null && !nuevaUrl.trim().isEmpty()) {
                        gestor.guardarConfig(nuevaUrl);
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