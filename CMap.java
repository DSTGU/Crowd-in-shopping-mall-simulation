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
			for(Pair p: explore(r.X,r.Y)) {
				PAIR.add(p);
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
	
	boolean IsObjectAt(int W, int K) {
		for(CObj S: L) {
			if((S.W==W)&&(S.K==K)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Pair> explore(int W, int K) {
		
		ArrayList<Pair> pair = new ArrayList<Pair>(); 
		
		if((IsObjectAt(W-1, K))==false){
			if((distance[W][K]+1)<distance[W-1][K]) {
					distance[W-1][K]=distance[W][K]+1;
					pair.add(new Pair(W-1,K));
			}
		}
		if((IsObjectAt(W+1, K))==false){
			if((distance[W][K]+1)<distance[W+1][K]) {
					distance[W+1][K] = distance[W][K]+1;
					pair.add(new Pair(W+1,K));
			}
		}
		if((IsObjectAt(W, K-1))==false){
			if((distance[W][K]+1)<distance[W][K-1]) {
					distance[W][K-1]= distance[W][K]+1;
					pair.add(new Pair(W,K-1));
			}
		}
		if((IsObjectAt(W, K+1))==false){
			if((distance[W][K]+1)<distance[W][K+1]) {
					distance[W][K+1]= distance[W][K]+1;
					pair.add(new Pair(W,K+1));
			}
		}
		return pair;
	}
	
}