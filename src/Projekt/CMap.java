package Projekt;
import java.util.ArrayList;

public class CMap {

	private int[][] distance = new int[0][];
	private int maxY = -1;
	private int maxX = -1;
	ArrayList<CObj> L = new ArrayList<CObj>();
	static int lSize;

	public int getdistance(CPosition pos){
		return distance[pos.Y][pos.X];
	}

	public void add(CObj obj) {
		L.add(obj);
	}
	
	public void create() {
		for(CObj num: L) {
			
			if(num.getPosition().Y>maxY) {
				maxY=num.getPosition().Y;
			}
			if(num.getPosition().X>maxX) {
				maxX=num.getPosition().X;
			}
		}
		
		distance= new int[maxY+1][maxX+1];
		for(int i = 0; i<=maxY; i++ ) {
			for(int j = 0; j <= maxX; j++) {
				distance[i][j]=10000;
			}
		}
		ArrayList<CPosition> PAIR = new ArrayList<CPosition>();
		for(CObj S: L) {
			if(S.typ=='O') {
				distance[S.getPosition().Y][S.getPosition().X]=0;
				PAIR.add(new CPosition(S.getPosition().Y,S.getPosition().X));
			}
		}
		for(int i = 0; i < PAIR.size();i++) {
			CPosition r = PAIR.get(i);
			CObj o = new CObj(r.Y, r.X);
			for(CPosition p: o.explore(L)) {
				if((distance[r.Y][r.X]+1)<distance[p.Y][p.X]) {
					distance[p.Y][p.X]=distance[r.Y][r.X]+1;
					PAIR.add(p);
				}
			}
		}
	}
	
	void SHOW() {
		
		for(int i = 0; i<=maxY; i++ ) {
			for(int j = 0; j <= maxX; j++) {
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
	}
}