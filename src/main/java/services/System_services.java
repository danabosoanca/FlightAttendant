package services;



import java.nio.file.Path;
import java.nio.file.Paths;

public class System_services {

	private static final String USER_FOLDER = System.getProperty("user.dir");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER);
    private static final Path USERS_PATH1 = System_services.getPathToFile("src/main/resources/glob.png");
    private static final Path USERS_PATH2 = System_services.getPathToFile("src/main/resources/login.png");
    private static final Path USERS_PATH3 = System_services.getPathToFile("src/main/resources/register.png");
  
    
    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get("", path));
    }
    
    public static Path getPath1() {
    	return USERS_PATH1;
    }
    
    public static Path getPath2() {
    	return USERS_PATH2;
    }
    
    public static Path getPath3() {
    	return USERS_PATH3;
    }
    
    
}