import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CPerfect extends CMoveObject{
	public CPerfect(){
		super();
		typ='P';
		img = new ImageIcon("imgP.png").getImage();
	}

	public CPerfect(int W, int K) {
		super(W, K);
		typ = 'P';
		img = new ImageIcon("imgP.png").getImage();
	}
	
	public void SelMove(CMap map, CShowObj ShowObj) {
		ArrayList<CPossition> neighbours = explore(ShowObj.L);
		if(neighbours.size()==0) 
			return;
		int mn = map.getdistance(getPossition())-1;
		for(int i = neighbours.size()-1; i >= 0; i--) {
			if(map.getdistance(neighbours.get(i))>mn)
				neighbours.remove(i);
		}
		if(neighbours.size()==0) return;
		int r=gen.nextInt(0, neighbours.size());
		getPossition().Y = neighbours.get(r).Y;
		getPossition().X = neighbours.get(r).X;
	}
}
