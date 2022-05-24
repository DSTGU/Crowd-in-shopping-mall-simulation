package Projekt;
import java.util.ArrayList;

public class CMap {

	private int[][] distance = new int[0][];
	private int maxW = -1;
	private int maxK = -1;
	ArrayList<CObj> L = new ArrayList<CObj>();

	public int getdistance(CPossition pos){

		return distance[pos.Y][pos.X];
	}

	public void add(CObj obj) {
		L.add(obj);
	}
	
	public void create() {
		for(CObj num: L) {
			
			if(num.getPossition().Y>maxW) {
				maxW=num.getPossition().Y;
			}
			if(num.getPossition().X>maxK) {
				maxK=num.getPossition().X;
			}
		}
		
		distance= new int[maxW+1][maxK+1];
		for(int i = 0; i<=maxW; i++ ) {
			for(int j = 0; j <= maxK; j++) {
				distance[i][j]=10000;
			}
		}
		ArrayList<CPossition> PAIR = new ArrayList<CPossition>();
		for(CObj S: L) {
			if(S.typ=='O') {
				distance[S.getPossition().Y][S.getPossition().X]=0;
				PAIR.add(new CPossition(S.getPossition().Y,S.getPossition().X));
			}
		}
		for(int i = 0; i < PAIR.size();i++) {
			CPossition r = PAIR.get(i);
			CObj o = new CObj(r.Y, r.X);
			for(CPossition p: o.explore(L)) {
				if((distance[r.Y][r.X]+1)<distance[p.Y][p.X]) {
					distance[p.Y][p.X]=distance[r.Y][r.X]+1;
					PAIR.add(p);
				}
			}
		}
	}
	
	void SHOW() {
		
		for(int i = 0; i<=maxW; i++ ) {
			for(int j = 0; j <= maxK; j++) {
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
	}
}