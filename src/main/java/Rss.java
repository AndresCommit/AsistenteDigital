import java.util.List;

public class Rss {

    private Channel channel;

    public Channel getChannel() { return channel; }
    public void setChannel(Channel channel) { this.channel = channel; }

    public static class Channel {
        private List<Noticia> items;

        public List<Noticia> getItems() { return items; }
        public void setItems(List<Noticia> items) { this.items = items; }
    }
}