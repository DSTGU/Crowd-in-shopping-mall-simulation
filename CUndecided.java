import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CUndecided extends CMoveObject{
	public CUndecided(){
		super();
		typ='U';
		img = new ImageIcon("imgU.png").getImage();
	}
	
	public CUndecided(int W, int K) {
		super(W, K);
		typ = 'U';
		img = new ImageIcon("imgU.png").getImage();
	}


	
	public void SelMove(CMap map, CShowObj ShowObj) {
		ArrayList<CPossition> neighbours = explore(ShowObj.L);
		if(neighbours.size()==0) 
			return;
		int mn = map.getdistance(neighbours.get(0));
		for(CPossition j: neighbours) {
			if(map.getdistance(j)<mn)
				mn=map.getdistance(j);
		}
		for(int i = neighbours.size()-1; i >= 0; i--) {
			if(map.getdistance(neighbours.get(i))>mn)
				neighbours.remove(i);
		}
		int r=gen.nextInt(0, neighbours.size());
		getPossition().Y = neighbours.get(r).Y;
		getPossition().X = neighbours.get(r).X;
	}
}
