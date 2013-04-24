import java.util.ArrayList;


public class PumpControl {
	
	private Pump[] allpumps;
	private IOPortAccess theWorldOutside = new IOPortAccess();
	private byte sperrbyte;
	
	PumpControl() {
		allpumps = new Pump[8];
		this.mksperrbyte();
	}
	
	public void Startpumping(){
		for(int i = 0; i<=allpumps.length; i++){		
			theWorldOutside.writePort(i, sperrbyte >> i);
		}
	}
	
	public byte mksperrbyte(){
		ArrayList<Pump> fifeLazyPumps = new ArrayList<Pump>();
		
		for(Pump p :allpumps){
			
		}
		return 0;
	}
}
