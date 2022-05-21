import java.util.ArrayList;

public class CMap {

	int[][] distance = new int[0][]; 
	int maxW = -1;
	int maxK = -1;
	ArrayList<CObj> L = new ArrayList<CObj>();
	
	public void add(CObj obj) {
		L.add(obj);
	}
	
	public void create() {
		for(CObj num: L) {
			
			if(num.W>maxW) {
				maxW=num.W;
			}
			if(num.K>maxK) {
				maxK=num.K;
			}
		}
		
		distance= new int[maxW+1][maxK+1];
		for(int i = 0; i<=maxW; i++ ) {
			for(int j = 0; j <= maxK; j++) {
				distance[i][j]=100;
			}
		}
		ArrayList<Pair> PAIR = new ArrayList<Pair>();
		for(CObj S: L) {
			if(S.typ=='O') {
				distance[S.W][S.K]=0;
				PAIR.add(new Pair(S.W,S.K));
			}
		}
		for(int i = 0; i < PAIR.size();i++) {
			Pair r = PAIR.get(i);
			CObj o = new CObj(r.X, r.Y);
			for(Pair p: o.explore(L)) {
				if((distance[r.X][r.Y]+1)<distance[p.X][p.Y]) {
					distance[p.X][p.Y]=distance[r.X][r.Y]+1;				
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