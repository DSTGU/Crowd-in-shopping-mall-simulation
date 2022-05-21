import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Projekt {	
	static CSimulator sim = new CSimulator();
	public static void main(String[] args) throws Exception  {
		new CMyFrame();
		//sim.load_data();
		//sim.map.create();
		/*for(int i = 0; i <30; i++) {
		sim.executestep(sim.ShowObj, sim.map);
		sim.ShowObj.Show();
		TimeUnit.SECONDS.sleep(1);
		}*/
	}
}
