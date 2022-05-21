import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSimulator {
	public CShowObj ShowObj = new CShowObj();
	static CMap map = new CMap();
	ArrayList<CMoveObject> L = new ArrayList<CMoveObject>();
	public void add(CMoveObject obj) {
		L.add(obj);
	}

	public void executestep(CShowObj ShowObj, CMap map) {
		for(int j = L.size()-1; j>=0; j--) {
		CMoveObject o = L.get(j);	
		if(map.distance[o.W][o.K]==1) {
			o.W=0;
			o.K=0;
			L.remove(j);
			continue;
		}
		o.SelMove(map, ShowObj);
		}
	}
	
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
	
	public void load_data() throws Exception {
		String name = "map1.txt";
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
			add(obj);
				}
		
		if(Lk.charAt(k)=='P') {
			CPerfect obj = new CPerfect(w,k);
			ShowObj.add(obj);
			add(obj);
				}
		
		if(Lk.charAt(k)=='O') {
			CExit obj = new CExit(w,k);
			ShowObj.add(obj);
			map.add(obj);
				}
		
		if(Lk.charAt(k)=='C') {
			CChaotic obj = new CChaotic(w,k);
			ShowObj.add(obj);
			add(obj);
				}	
			}
		}
	}
}
