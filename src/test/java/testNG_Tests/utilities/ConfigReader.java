package testNG_Tests.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*

        Bu sinif configuration.properties file i okumak icin kullanilir
    property file i okumak icin properti objecsi kullanilir
     */
    private static Properties properties;
    static {
        String path="configuration.properties";


        try {
            //configuration.properties dosyasi acilir
            FileInputStream fileInputStream= new FileInputStream(path);

            //properties initialize ediliyor
            properties= new Properties();

            //configuration.properties dosyasindaki datalari yukluyuruz
            properties.load(fileInputStream);

            //fileInputStream kapatiyor
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
public static String getProperty(String key){
        String  value= properties.getProperty(key);
        return value;
}

}
