import com.thoughtworks.xstream.XStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LectorRSS {

    public List<Noticia> parseFeed(String urlString) {

        XStream xstream = new XStream();

        try {
            xstream.allowTypes(new Class[]{
                    Rss.class,
                    Channel.class,
                    Noticia.class,
                    java.util.List.class
            });

            // Mapeamos los tags XML a nuestras clases
            xstream.alias("rss", Rss.class);         // <rss> -> Rss.java
            xstream.alias("channel", Channel.class);   // <channel> -> Channel.java
            xstream.alias("item", Noticia.class);     // <item> -> Noticia.java

            xstream.addImplicitCollection(Channel.class, "items");

            xstream.aliasField("title", Noticia.class, "titulo");
            xstream.aliasField("link", Noticia.class, "link");
            xstream.aliasField("dc:creator", Noticia.class, "fuente"); // Para el autor
            xstream.aliasField("pubDate", Noticia.class, "fecha");    // Para la fecha

            xstream.registerConverter(new DateConverterRss());

            InputStream stream = new URL(urlString).openStream();

            // Deserializamos el XML
            Rss rss = (Rss) xstream.fromXML(stream);

            stream.close();

            // Devolvemos la lista de noticias que estaba dentro de Channel
            return rss.getChannel().getItems();

        } catch (Exception e) {
            System.err.println("Error al parsear con XStream: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}