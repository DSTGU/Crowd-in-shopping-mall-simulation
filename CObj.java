import java.util.ArrayList;

//opisuje obiekt, K - kolumna, W - wiersz, typ - typ obiektu(Perfect...)
public class CObj {
	public int K,W;
	char typ='0';
	
	
	CObj(){
		K=0;
		W=0;
		typ='0';
	}
	
	CObj(int W, int K){
		this.K=K;
		this.W=W;			
	}
	
	CObj(int W, int K, char typ){
		this.typ=typ;
		this.K=K;
		this.W=W;	
	}
	
	public boolean yourpositionis(int W, int K) {
		if((this.W==W)&&(this.K==K))
			return true;
		return false;
	}
	public ArrayList<Pair> explore(ArrayList<CObj> L) { 
		ArrayList<Pair> neighbourhood = new ArrayList<Pair>();
		neighbourhood.add(new Pair(W-1, K));
		neighbourhood.add(new Pair(W+1, K));
		neighbourhood.add(new Pair(W, K-1));
		neighbourhood.add(new Pair(W, K+1));
		for(CObj x: L) {
		for(int i = neighbourhood.size()-1; i>=0; i--) {
			if((x.yourpositionis(neighbourhood.get(i).X, neighbourhood.get(i).Y))==true)
				neighbourhood.remove(i);
			}
		}
		return neighbourhood;
	}
}
