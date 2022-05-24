package Projekt;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CChaotic extends CMoveObject{

	Random gen = new Random();
	int counter = 0; // Do refaktoryzacji. Uzależnić od globalnego timera jak się go znajdzie
	int phase = 0;

	public CChaotic(){
		super();
		typ='C';
		img = new ImageIcon("imgC.png").getImage();
	}

	public CChaotic(int W, int K) {
		super(W, K);
		typ = 'C';
		img = new ImageIcon("imgC.png").getImage();
	}

	public void SelMove(CMap map, CShowObj ShowObj) {
		counter++;
		if(counter > (gen.nextInt()%60))
		{
			phase = (phase+1)%2;
		}
		if (phase == 0) {
			ArrayList<CPosition> neighbours = explore(ShowObj.L);
			if (neighbours.size() == 0)
				return;
			int r = gen.nextInt(0, neighbours.size());
			getPosition().Y = neighbours.get(r).Y;
			getPosition().X = neighbours.get(r).X;
		}
		if (phase == 1) {
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


}
