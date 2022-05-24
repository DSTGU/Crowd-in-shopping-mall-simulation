package Projekt;
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


	@Override
	public void SelMove(CMap map, CShowObj ShowObj) {
		ArrayList<CPosition> neighbours = explore(ShowObj.L);
		if(neighbours.size()==0) 
			return;
		int mn = map.getdistance(neighbours.get(0));
		for(CPosition j: neighbours) {
			if(map.getdistance(j)<mn)
				mn=map.getdistance(j);
		}
		for(int i = neighbours.size()-1; i >= 0; i--) {
			if(map.getdistance(neighbours.get(i))>mn)
				neighbours.remove(i);
		}
		int r=gen.nextInt(0, neighbours.size());
		getPosition().Y = neighbours.get(r).Y;
		getPosition().X = neighbours.get(r).X;
	}
}
