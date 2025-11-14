import java.io.*;

public class GestorConfiguracion {

    String dirActual = System.getProperty("user.dir");
    File configuracion = new File(dirActual + File.separator + "data" + File.separator + "config.ser");

    public void guardarConfig(String url) {
        configuracion.getParentFile().mkdirs();

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(configuracion);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(url);
            System.out.println("[CONFIG] Configuración guardada: " + url);

        } catch (IOException e) {
            System.err.println("Error al guardar la configuración: " + e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar ObjectOutputStream: " + e.getMessage());
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar FileOutputStream: " + e.getMessage());
            }
        }
    }

    public String cargarConfig() {

        if (!configuracion.exists()) {
            System.out.println("[CONFIG] 'config.ser' no encontrado. Usando URL por defecto.");

            // He cambiado la URL de ejemplo a la que pide la práctica
            String urlPorDefecto = "xataka.com/feedburner.xml";

            // Esta llamada ahora SÍ funcionará y creará el fichero correctamente
            this.guardarConfig(urlPorDefecto);

            return urlPorDefecto;
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(configuracion);
            ois = new ObjectInputStream(fis);
            String urlCargada = (String) ois.readObject();
            System.out.println("[CONFIG] Configuración cargada: " + urlCargada);
            return urlCargada;

        } catch (FileNotFoundException e) {
            System.err.println("Error: Fichero de config no encontrado: " + e.getMessage());
        } catch (IOException e) {
            // Si el fichero está corrupto O VACÍO, entrará aquí.
            System.err.println("Error de E/S al leer la configuración (fichero corrupto?): " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: El contenido de 'config.ser' no es un String: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) { /* no hacer nada */ }
            try {
                if (fis != null) fis.close();
            } catch (IOException e) { /* no hacer nada */ }
        }

        // Si la lectura falló (fichero corrupto)
        return null;
    }
}