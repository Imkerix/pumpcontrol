import java.util.logging.Logger;


public class Pump {
	private long runtimeInSec = 0;
	private int datenleitung;
	private long starttimenew;
	private long endtimenew;
	private static final Logger log = Logger.getLogger(Main.class.getName());

	
	Pump(int p_datenleitung){
		datenleitung = p_datenleitung;
		
	}
	public int changepowerstate(int p_powerstate){

		if(p_powerstate==0){
			//this.on();
			starttimenew = System.currentTimeMillis() / 1000;
			return 0;
		}
		if(p_powerstate==1){
			//this.off(); //would disable pump
			endtimenew = System.currentTimeMillis() / 1000;
			runtimeInSec += endtimenew - starttimenew;
			return 1;
		}
		else{
			log.info("changepowerstate mit etwas anderem als 0 oder 1 aufgerufen");
			return 3;
		}
	}
	
 	public long getRuntime() {
		return runtimeInSec;
	}

	public int getDatenleitung() {
		return datenleitung;
	}
	
}