import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GeneradorHTML {

    private static final String PLANTILLA_HTML = "<html><head><title>Resumen de Noticias</title>" +
            "<style>" +
            "body{font-family:Arial,sans-serif;margin:20px}" +
            " .noticia{border-bottom:1px solid #ccc;padding:10px 0} h2{color:#333} span{color:#666;font-size:0.9em}</style>"
            +
            "</head><body><h1>Resumen Diario de Noticias</h1>";

    private static final String PIE_HTML = "</body></html>";

    public void generarInforme() {

        SimpleDateFormat sdfArchivo = new SimpleDateFormat("yyyy-MM-dd");
        String fechaHoyString = sdfArchivo.format(new Date());

        String nombreArchivo = "resumen-" + fechaHoyString + ".html";
        File carpetaReports = new File("reports");
        File archivoSalida = new File(carpetaReports, nombreArchivo);

        if (!carpetaReports.exists()) {
            carpetaReports.mkdirs();
        }

        ArchivoNoticias archivo = new ArchivoNoticias();
        List<Noticia> todasLasNoticias = archivo.leerTodas();

        int contadorNoticiasHoy = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {

            writer.write(PLANTILLA_HTML);
            writer.write("<p>Fecha del informe: " + fechaHoyString + "</p><hr>");

            SimpleDateFormat sdfComparador = new SimpleDateFormat("yyyyMMdd");
            String hoyCode = sdfComparador.format(new Date());

            for (Noticia n : todasLasNoticias) {

                String noticiaCode = sdfComparador.format(new Date(n.getFechaParsed()));

                if (hoyCode.equals(noticiaCode)) {
                    writer.write("<div class='noticia'>");
                    writer.write("<h2><a href='" + n.getLink() + "' target='_blank'>" + n.getTitulo() + "</a></h2>");
                    writer.write("<p><span>" + n.getFuente() + " - " + n.getFecha() + "</span></p>");
                    writer.write("</div>");

                    contadorNoticiasHoy++;
                }
            }

            if (contadorNoticiasHoy == 0) {
                writer.write("<p>No hay noticias registradas para el día de hoy.</p>");
            }

            writer.write(PIE_HTML);

            System.out.println("Informe generado correctamente: " + archivoSalida.getPath());
            Logger.log("Informe HTML generado: " + nombreArchivo + " (" + contadorNoticiasHoy + " noticias)");

        } catch (IOException e) {
            System.err.println("Error al generar el HTML: " + e.getMessage());
            Logger.log("Error generando informe HTML: " + e.getMessage());
        }
    }
}