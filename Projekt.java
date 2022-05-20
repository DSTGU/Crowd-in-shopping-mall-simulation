import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Projekt {
	
	public static ArrayList<String> read_data(String name) throws Exception {
		BufferedReader ReadF = null;
		ArrayList<String> L = new ArrayList<String>();
		try {
			ReadF = new BufferedReader(new FileReader(name));
			String numstring = ReadF.readLine();
			while(numstring != null) {					
				L.add (numstring);
				numstring = ReadF.readLine();	
			}
			
		} catch (Exception er) {
			return null;
		}
		ReadF.close();
		return L;
		
	}
	
	static CShowObj ShowObj = new CShowObj();
	static CMap map = new CMap();
	static CSimulator sim = new CSimulator();
	public static void main(String[] args) throws Exception  {
		String name = "map1.txt";
		
		//Funkcja tworzy listê obiektów do wyœwietlenia(sciany...)
		ArrayList<String> Lp = read_data(name);
		for(int w =0; w<=Lp.size()-1;w++){
		String Lk=Lp.get(w);
		for(int k = 0; k <= Lk.length()-1;k++) {			
		if(Lk.charAt(k)=='W') {
			CWall obj = new CWall(w,k);
			ShowObj.add(obj);
			map.add(obj);
				}
		
		if(Lk.charAt(k)=='U') {
			CUndecided obj = new CUndecided(w,k);
			ShowObj.add(obj);
			sim.add(obj);
				}
		
		if(Lk.charAt(k)=='P') {
			CPerfect obj = new CPerfect(w,k);
			ShowObj.add(obj);
			sim.add(obj);
				}
		
		if(Lk.charAt(k)=='O') {
			CExit obj = new CExit(w,k);
			ShowObj.add(obj);
			map.add(obj);
				}
		
		if(Lk.charAt(k)=='C') {
			CChaotic obj = new CChaotic(w,k);
			ShowObj.add(obj);
			sim.add(obj);
				}	
			}
		}
		
		map.create();
		for(int i = 0; i <30; i++) {
		sim.executestep(ShowObj, map);
		ShowObj.Show();
		TimeUnit.SECONDS.sleep(1);
		}
	}
}
