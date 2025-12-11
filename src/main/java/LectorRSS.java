import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LectorRSS {

    public List<Noticia> parseFeed(String urlString) {
        XStream xstream = new XStream();
        xstream.ignoreUnknownElements();

        try {

            xstream.addPermission(NoTypePermission.NONE);
            xstream.allowTypes(new Class[] {
                    Rss.class,
                    Rss.Channel.class,
                    Noticia.class,
                    java.util.List.class
            });

            xstream.alias("rss", Rss.class);
            xstream.alias("channel", Rss.Channel.class);
            xstream.alias("item", Noticia.class);

            xstream.addImplicitCollection(Rss.Channel.class, "items");

            xstream.aliasField("title", Noticia.class, "titulo");
            xstream.aliasField("link", Noticia.class, "link");
            xstream.aliasField("dc:creator", Noticia.class, "fuente");
            xstream.aliasField("pubDate", Noticia.class, "fecha");

            InputStream stream = new URL(urlString).openStream();
            Rss rss = (Rss) xstream.fromXML(stream);
            stream.close();

            return rss.getChannel().getItems();

        } catch (Exception e) {
            System.err.println("Error al parsear con XStream: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}