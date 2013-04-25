import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;


public class PumpControl {
	
	private Pump[] allpumps;
	private IOPortAccess theWorldOutside = new IOPortAccess();
	private byte sperrbyte;
	private static final Logger log = Logger.getLogger(Main.class.getName());

	
	PumpControl() {
		allpumps = new Pump[8];
		for(int i = 0; i<allpumps.length; i++){
			allpumps[i]= new Pump(i);
		}
		
		
		mksperrbyte();
	}
	
	public void Startpumping(){
		for(int i = 0; i<=allpumps.length; i++){		
			theWorldOutside.writePort(i, sperrbyte >> i);
		}
	}
	
	public byte mksperrbyte(){
		Arrays.sort(allpumps);
		for(Pump p : allpumps){
			log.info("Runtime der Pumpe "+""+p.getRuntime());
		}
		return (byte) 0b11111000;
	}
}
