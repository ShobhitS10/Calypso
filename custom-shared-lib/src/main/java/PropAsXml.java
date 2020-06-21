import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
 
public class PropAsXml {
     
    public static void main(String a[]) throws IOException{
         
        OutputStream os = null;
        Properties prop = new Properties();
        prop.setProperty("name", "ShobhitSachdeva");
        prop.setProperty("domain", "www.S2Arts.com");
        prop.setProperty("email", "ssachdeva@luxoft.com");
        try {
            os = new FileOutputStream("C:/Test/Prop.xml");
            prop.storeToXML(os, "Dynamic Property File");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         
    }
}