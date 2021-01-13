import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
    public static void main(String[] args) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String name = read();
        Animal animal = (Animal) Class.forName(name).newInstance();         //反射
        animal.brak();
    }
    public static String read() throws ClassNotFoundException, DocumentException {

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(Class.forName("Test").getResourceAsStream("/config.xml"));
        Element element = (Element) document.selectObject("/animal/animal");
        return element.getStringValue();

    }
}
