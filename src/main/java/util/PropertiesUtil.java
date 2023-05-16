package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//Data from Property file
public class PropertiesUtil
{
    static Properties properties;

    static
    {
        //loading property files
        properties = new Properties();
        String propertiesFilePath ="/Users/dank/Downloads/IntellijProjects/AutomationTesting_SeleniumFW2/src/test/resources/framework.properties";

        FileInputStream fis;
        try {
            fis = new FileInputStream(propertiesFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //To get URL from property file
    public static String getUrL()
    {
        return properties.getProperty("url", "https://www.google.com");
    }

    //Get browser from property file
    public static String getBrowser()
    {
        return properties.getProperty("browser","chrome");
    }

    //Get explicit timeout value from property file
    public static int getExplicitTimeOutInSec()
    {
        return Integer.parseInt(properties.getProperty("explicitTime","5"));

    }

    //To get a value from property file
    public static String getValueFromPropertyFile(String key)
    {
        return properties.getProperty(key);

    }
}
