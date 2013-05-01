import java.util.logging.Logger;


public class Pumpe{

	private long runtimeInSec;
	private String datenleitung;
	private long starttimenew = 0; //wird nur fuer abfrage auf 0 gesetzt
	private IOPortAccess sharedWorld;
	private static final Logger log = Logger.getLogger(Main.class.getName());

	
	Pumpe(String p_datenleitung, IOPortAccess p_sharedWorld){
		datenleitung = p_datenleitung;	
		sharedWorld = p_sharedWorld;
	}
	
	public int changepowerstate(int p_powerstate){

		if(p_powerstate==1 && starttimenew == 0){ //verhindert das maschine 2 mal angeschaltet wird
			sharedWorld.writePort(Integer.parseInt(datenleitung.substring(1)), 1 << /*byte ?*/);
			starttimenew = System.currentTimeMillis() / 1000;
			return 1;
		}
		if(p_powerstate==0 && starttimenew != 0){ //verhindert das maschine 2 mal ausgeschaltet wird
			//this.off(); //would disable pump
			runtimeInSec += (System.currentTimeMillis() / 1000) - starttimenew;
			starttimenew = 0;
			return 0;
		}
		else{
			log.info("changepowerstate mit etwas anderem als 0 oder 1 aufgerufen");
			return 3;
		}
	}
	
 	public long getRuntime() {
		return runtimeInSec;
	}

	public String getDatenleitung() {
		return datenleitung;
	}
	
	public boolean notAus(){
		//this.off();
		return true;
	}
	
}