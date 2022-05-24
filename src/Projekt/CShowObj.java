package Projekt;
import java.util.ArrayList;

//wyswietlanie aktorow na mapie
public class CShowObj extends CMap {	
	public void Show() {
		int maxK=-1;
		int maxW=-1;
		
		for(CObj num: L) {
			
			if(num.getPosition().Y>maxW) {
				maxW=num.getPosition().Y;
			}
			if(num.getPosition().X>maxK) {
				maxK=num.getPosition().X;
			}
			
		}
		String star="";
		for(int i = 0; i <= maxK; i++) {
			star=star+" ";
		}
		ArrayList<String> charMap = new ArrayList<String>();
		for(int i = 0; i<=maxW;i++) {
			charMap.add(star);
		}
		
		for(CObj num: L) {
			num.ShowInCharMap(charMap);
		}
		
		for(String num: charMap) {
			System.out.println(num);
		}	
	}
}