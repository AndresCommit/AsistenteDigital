import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArchivoNoticias {

    private static final String RUTA_FICHERO = "data" + File.separator + "noticias.dat";

    private static final int TAM_TITULO = 100;
    private static final int TAM_LINK = 200;
    private static final int TAM_FUENTE = 50;

    // TAMAÑO REGISTRO (2 bytes por char + 8 bytes del long fecha)
    // (100*2) + (200*2) + (50*2) + 8 = 200 + 400 + 100 + 8 = 708 bytes
    private static final int TAM_REGISTRO = 708;

    public ArchivoNoticias() {
        new File("data").mkdirs();
    }

    public void archivarNoticia(Noticia noticia) {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA_FICHERO, "rw")) {

            raf.seek(raf.length());

            writeFixedString(raf, noticia.getTitulo(), TAM_TITULO);

            writeFixedString(raf, noticia.getLink(), TAM_LINK);

            writeFixedString(raf, noticia.getFuente(), TAM_FUENTE);

            raf.writeLong(noticia.getFechaParsed());

        } catch (IOException e) {
            System.err.println("Error al escribir en noticias.dat: " + e.getMessage());
            Logger.log("Error crítico guardando noticia: " + noticia.getTitulo());
        }
    }

    public List<Noticia> leerTodas() {
        List<Noticia> lista = new ArrayList<>();
        File file = new File(RUTA_FICHERO);

        if (!file.exists()) return lista;

        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);

            while (raf.getFilePointer() + TAM_REGISTRO <= raf.length()) {

                String titulo = readFixedString(raf, TAM_TITULO);
                String link = readFixedString(raf, TAM_LINK);
                String fuente = readFixedString(raf, TAM_FUENTE);
                long fechaLong = raf.readLong();
                String fechaTexto = sdf.format(new Date(fechaLong));


                Noticia n = new Noticia(titulo, link, fuente, fechaTexto);
                lista.add(n);
            }

        } catch (IOException e) {
            System.err.println("Error al leer noticias.dat: " + e.getMessage());
        }
        return lista;
    }

    private void writeFixedString(RandomAccessFile raf, String texto, int tam) throws IOException {
        StringBuffer sb;
        if (texto != null) {
            sb = new StringBuffer(texto);
        } else {
            sb = new StringBuffer("");
        }

        sb.setLength(tam);

        raf.writeChars(sb.toString());
    }

    private String readFixedString(RandomAccessFile raf, int tam) throws IOException {
        char[] chars = new char[tam];
        for (int i = 0; i < tam; i++) {
            chars[i] = raf.readChar();
        }
        return new String(chars).trim();
    }
}