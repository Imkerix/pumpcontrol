import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

	/**
	 * @param args
	 */
	private static final Logger log = Logger.getLogger(Main.class.getName());
	private PumpControl MyPumpControl = new PumpControl();
	
	public static void main(String[] args) {
		log.setLevel(Level.SEVERE);
		System.setProperty("java.util.logging.config.file", "logging.properties");
	}

}