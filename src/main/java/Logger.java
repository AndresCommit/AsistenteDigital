import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final String RUTA_LOG = "data" + File.separator + "resumen_diario.log";

    public static void log(String mensaje) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(new Date());

        String lineaLog = "[" + fechaHora + "] " + mensaje;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_LOG, true))) {

            writer.write(lineaLog);
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error crítico al escribir en el log: " + e.getMessage());
        }
    }
}