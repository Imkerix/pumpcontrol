import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class PumpControl {
	
	private Pump[] allpumps;
	private IOPortAccess theWorldOutside = new IOPortAccess();
	private byte sperrbyte;
	
	
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
			System.out.println(p.getRuntime());
		}
		return 0;
	}
}
