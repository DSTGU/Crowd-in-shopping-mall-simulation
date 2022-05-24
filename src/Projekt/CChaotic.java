package Projekt;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CChaotic extends CMoveObject{

	Random gen = new Random();
	int timer = 0;
	int counter = 0;
	int phase = -1;
	//int initObjCount = CMap.getObjCount();

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

		timer = CMyPanel.counter;
		counter++;
		if(counter-20 > timer*phase*0.5+(gen.nextInt()%180)) //Im później tym mniej "skonfundowani" są chaotiki
		{
			phase *= -1;
		}

		if (phase == -1) { //Jeśli faza == -1 to losowo
			ArrayList<CPosition> neighbours = explore(ShowObj.L);
			if (neighbours.size() == 0)
				return;
			int r = gen.nextInt(0, neighbours.size());
			getPosition().Y = neighbours.get(r).Y;
			getPosition().X = neighbours.get(r).X;
		}
		if (phase == 1) { //Jeśli faza == 1 to perfekcyjnie
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
