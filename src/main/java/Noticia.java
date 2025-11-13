import java.io.Serializable;

public class Noticia implements Serializable {
   private String titulo;
   private String link;
   private String fuente;
   private Long fecha;


   //Constructor noticia
    public Noticia(String titulo, String link, String fuente, Long fecha) {
        this.titulo = titulo;
        this.link = link;
        this.fuente = fuente;
        this.fecha = fecha;
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

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }
}
