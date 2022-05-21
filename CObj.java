import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//opisuje obiekt, K - kolumna, W - wiersz, typ - typ obiektu(Perfect...)
public class CObj implements IObj {
	char typ='0';
	private CPossition pos = new CPossition();

	Image img = new ImageIcon("imgC.png").getImage();

	CObj(){
		pos=new CPossition();
		typ='0';
	}
	
	CObj(int Y, int X){
		pos = new CPossition(Y, X);
	}
	
	CObj(int Y, int X, char typ){
		this.typ=typ;
	}

	@Override
	public void gotoOut() {
		pos.Y=0;
		pos.X=0;
	}

	@Override
	public CPossition getPossition() {
		return pos;
	}

	public boolean yourpositionis(int W, int X) {
		if((this.pos.Y==W)&&(this.pos.X==X))
			return true;
		return false;
	}

	public void ShowInCharMap(ArrayList<String> charMap){
			String x = charMap.get(pos.Y);
			String y =x.substring(0, pos.X);
			String S = String.valueOf(typ);

			y=y+S+x.substring(pos.X+1, x.length());
			charMap.remove(pos.Y);
			charMap.add(pos.Y, y);
	}

	public ArrayList<CPossition> explore(ArrayList<CObj> L) {
		ArrayList<CPossition> neighbourhood = new ArrayList<CPossition>();
		neighbourhood.add(new CPossition(pos.Y-1, pos.X));
		neighbourhood.add(new CPossition(pos.Y+1, pos.X));
		neighbourhood.add(new CPossition(pos.Y, pos.X-1));
		neighbourhood.add(new CPossition(pos.Y, pos.X+1));
		for(CObj x: L) {
		for(int i = neighbourhood.size()-1; i>=0; i--) {
			if((x.yourpositionis(neighbourhood.get(i).Y, neighbourhood.get(i).X))==true)
				neighbourhood.remove(i);
			}
		}
		return neighbourhood;
	}

	public void paint (Graphics G2D) {
		G2D.drawImage(img,  pos.X*10,  pos.Y*10, null);
	}
}
