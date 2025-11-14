import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Esta clase le enseña a XStream cómo convertir
// el texto de <pubDate> (ej: "Fri, 14 Nov 2025...") a un Long.
public class DateConverterRss implements Converter {

    // El formato de fecha que usan los RSS
    private final SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

    // Le dice a XStream que SÓLO use esto para campos de tipo Long
    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Long.class);
    }

    // Función que lee el XML (String) y devuelve el objeto (Long)
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        String dateStr = reader.getValue(); // Obtiene el texto: "Fri, 14 Nov..."
        try {
            Date date = sdf.parse(dateStr); // Convierte el texto a Fecha
            return date.getTime(); // Devuelve el long
        } catch (Exception e) {
            System.err.println("Error parseando fecha RSS: " + dateStr);
            return 0L; // Devuelve 0 si falla
        }
    }

    // No necesitamos esta parte (es para escribir XML), la dejamos vacía
    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext context) {
        // No implementado
    }
}