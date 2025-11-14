
import java.io.*;
public class GestorConfiguracion {
    String dirActual = System.getProperty("user.dir");
    File configuracion = new File(dirActual + "\\data\\config.ser");

    public void guardarConfig(String url) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            // 1. Preparamos el stream para escribir bytes en el fichero.
            fos = new FileOutputStream(configuracion);
            // 2. Envolvemos el fos para poder escribir objetos (serializar).
            oos = new ObjectOutputStream(fos);

            // Escribimos el objeto String (la URL) en el fichero.
            oos.writeObject(url);

            System.out.println("[CONFIG] Configuración guardada: " + url);

        } catch (IOException e) {
            System.err.println("Error al guardar la configuración: " + e.getMessage());
        } finally {
            // Cerramos los streams en orden inverso al abrirlos
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar ObjectOutputStream: " + e.getMessage());
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar FileOutputStream: " + e.getMessage());
            }
        }
    }
    public String cargarConfig(){

        if (!configuracion.exists()) {
            System.out.println("[CONFIG] 'config.ser' no encontrado. Usando URL por defecto.");

            // Si no existe, es la primera ejecución. Devolvemos una URL por defecto.
            String urlPorDefecto = "https://www.xataka.com/categoria/medicina-y-salud";

            // Guardamos esta URL por defecto para que el fichero ya exista la próxima vez.
            this.guardarConfig(urlPorDefecto);

            return urlPorDefecto;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(configuracion);
            //Envolvemos el fis para deserializar
            ois = new ObjectInputStream(fis);

            // Leemos el objeto del fichero y lo casteamos
            String urlCargada = (String) ois.readObject();

            System.out.println("[CONFIG] Configuración cargada: " + urlCargada);
            return urlCargada;

        } catch (FileNotFoundException e) {
            System.err.println("Error: Fichero de config no encontrado: " + e.getMessage());
        } catch (IOException e) {
            // Ocurre si el fichero está corrupto o no se puede leer.
            System.err.println("Error de E/S al leer la configuración: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Ocurre si el objeto guardado NO es un String.
            System.err.println("Error: El contenido de 'config.ser' no es un String: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar ObjectInputStream: " + e.getMessage());
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar FileInputStream: " + e.getMessage());
            }
        }

        // Si algo falló en la lectura (fichero corrupto, etc.), devolvemos null.
        return null;
    };

}
