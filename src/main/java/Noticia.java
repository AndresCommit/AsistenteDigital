import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Noticia implements Serializable {
    private String titulo;
    private String link;
    private String fuente;
    private String fecha;

    public Noticia(String titulo, String link, String fuente, String fecha) {
        this.titulo = titulo;
        this.link = link;
        this.fuente = fuente;
        this.fecha = fecha;
    }

    public long getFechaParsed() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
            Date date = sdf.parse(this.fecha);
            return date.getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}