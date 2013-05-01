import java.util.logging.Logger;


public class PumpControl {
	
	private Pumpe[] allpumps;
	private IOPortAccess theWorldOutside = new IOPortAccess();
	private byte sperrbyte;
	private static final Logger log = Logger.getLogger(Main.class.getName());
	private int[] free = new int[8];

	
	PumpControl() {
		allpumps = new Pumpe[8];
		for(int i = 0; i<allpumps.length; i++){
			allpumps[i]= new Pumpe("D"+Integer.toString(i));
		}
		
		
		mksperrbyte();
	}
	public void Startpumping(int p_pumpe, char p_mode){
			if(p_mode== '-' && p_pumpe == -1){
				for(int i = 0; i<=allpumps.length; i++){		
					theWorldOutside.writePort(i, sperrbyte >> i);
				}
			}
			else if(p_mode== '+' && p_pumpe == -1){
				for(int i = 0; i<=allpumps.length; i++){		
					theWorldOutside.writePort(i, sperrbyte >> i);
				}
			}
			else if(p_mode== '-' && p_pumpe != -1){
				if(free[p_pumpe]==0){
					theWorldOutside.writePort(p_pumpe, sperrbyte >> p_pumpe);
				}
				else{
					log.info("Einzelne Gesperrte Pumpe aufgerufen! Bit zur zeit des Aufrufes "+free[p_pumpe]);
				}
			}
			else if(p_mode== '+' && p_pumpe != -1){
				if(free[p_pumpe]==0){
					theWorldOutside.writePort(p_pumpe, sperrbyte >> p_pumpe);
				}
				else{
					log.info("Einzelne Gesperrte Pumpe aufgerufen! Bit zur zeit des Aufrufes "+free[p_pumpe]);
				}
			}
			else{
				
				log.info("Komische Werte aufgerufen, trotzdem falsch! Bit in free zur zeit des Aufrufes "+free[p_pumpe] + "int p_pumpe zur zeit des Aufrufes "+p_pumpe+"char  p_mode zur zeit des aufrufes "+ p_mode);
			}
		
	}
	
	public byte mksperrbyte(){
		// Beginn init //
		Pumpe[] sorted = new Pumpe[8];
		Pumpe temp;
		// Beginn init //
		// Beginn mk array entrys to compare with  //
		for(int i = 0; i<8; i++){
			sorted[i] = allpumps[i];
		}
		// End mk array entrys to compare with  //
		// Beginn Some Bubblesort //
		boolean isSorted = false;
		while(isSorted==false){
			isSorted = true;
			for(int i = 0; i<7; i++){
				if(sorted[i].getRuntime()>sorted[i+1].getRuntime()){
					temp = sorted[i+1];
					sorted[i+1] = sorted[i];
					sorted[i]=temp;
					isSorted=false;
				}	
			}
		}
		// End Some Bubblesort //
		// Beginn create sperrbyte //
		for(int i = 0; i<8; i++){
			if(allpumps[i].equals(sorted[0]) || allpumps[i].equals(sorted[1]) ||
					allpumps[i].equals(sorted[2]) || allpumps[i].equals(sorted[3]) ||
					allpumps[i].equals(sorted[4])){
				free[i] = 0;
			}
			else{
				free[i] = 1;
			}
			log.info("Runtime der Pumpe "+""+allpumps[i].getRuntime());
		}
		// End create sperrbyte //
		// Beginn only return left //
		System.out.println((free[0]+""+free[1]+""+free[2]+""+free[3]+""+free[4]+""+free[5]+""+free[6]+""+free[7]));
		return  (byte) (free[0]+free[1]+free[2]+free[3]+free[4]+free[5]+free[6]+free[7]);
		// End only return left //
	}
}
