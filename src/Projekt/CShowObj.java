package Projekt;
import java.util.ArrayList;

//wyswietlanie aktorow na mapie
public class CShowObj extends CMap {
	public void Show() {
		int maxY=-1;
		int maxX=-1;
		
		for(CObj num: L) {
			
			if(num.getPosition().Y>maxY) {
				maxY=num.getPosition().Y;
			}
			if(num.getPosition().X>maxX) {
				maxX=num.getPosition().X;
			}
			
		}
		String star="";
		for(int i = 0; i <= maxX; i++) {
			star=star+" ";
		}
		ArrayList<String> charMap = new ArrayList<String>();
		for(int i = 0; i<=maxY;i++) {
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