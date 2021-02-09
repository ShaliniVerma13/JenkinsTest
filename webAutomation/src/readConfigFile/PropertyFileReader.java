package readConfigFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public static String ApplicationConfigReader(String Key)
	{
		try{
			File f = new File("./ConfigurationFiles/ApplicationConfig.properties");
			FileReader fr= new FileReader(f);
			Properties prop = new Properties();
			prop.load(fr);
			return prop.get(Key).toString();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("*************Exception***********"+e);
			return null;
		}
	}
			

	public static String ElementLocatorReader(String Key)
	{
		try{
			File f = new File("./ElementLocators/Locator.properties");
			FileReader fr= new FileReader(f);
			Properties prop = new Properties();
			prop.load(fr);
			return prop.get(Key).toString();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("*************Exception***********"+e);
			return null;
		}
	}
		
}
