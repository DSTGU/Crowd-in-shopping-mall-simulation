
import java.util.ArrayList;

//wyswietlanie aktorow na mapie
public class CShowObj {
	public ArrayList<CObj> L = new ArrayList<CObj>();
	public void add(CObj obj) {
		L.add(obj);
	}
	
	public void Show() {
		int maxK=-1;
		int maxW=-1;
		
		for(CObj num: L) {
			
			if(num.W>maxW) {
				maxW=num.W;
			}
			if(num.K>maxK) {
				maxK=num.K;
			}
			
		}
		String star="";
		for(int i = 0; i <= maxK; i++) {
			star=star+" ";
		}
		ArrayList<String> List = new ArrayList<String>();
		for(int i = 0; i<=maxW;i++) {
			List.add(star);
		}
		
		for(CObj num: L) {
			
			String x = List.get(num.W);
			String y =x.substring(0, num.K);
			String S = String.valueOf(num.typ);
			
			y=y+S+x.substring(num.K+1, x.length());
			List.remove(num.W);
			List.add(num.W, y);			
		}
		
		for(String num: List) {
			System.out.println(num);
		}	
	}
}