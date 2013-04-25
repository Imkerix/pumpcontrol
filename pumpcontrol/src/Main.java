import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

	/**
	 * @param args
	 */
	private static final Logger log = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		PumpControl MyPumpControl = new PumpControl();
		log.setLevel(Level.INFO);
		System.setProperty("java.util.logging.config.file", "logging.properties");
		
		
	}

}