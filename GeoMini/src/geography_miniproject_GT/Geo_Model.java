package geography_miniproject_GT;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Geo_Model {
	
	
	
	


	
public static class SaveLoadManager {
	
	public static void save (Serializable data, String savefileName) throws Exception {
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(savefileName)))) {
			oos.writeObject(data); 
			
		}
	}
	
	public static Object load (String fileName) throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			return ois.readObject();
		}
	}
	
}
	

}
