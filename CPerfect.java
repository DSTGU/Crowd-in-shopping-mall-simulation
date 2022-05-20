import java.util.ArrayList;

public class CPerfect extends CMoveObject{
	public CPerfect(){
		super();
		typ='P';
	}
	
	public CPerfect(int W, int K) {
		super(W, K);
		typ = 'P';
	}
	public void SelMove(ArrayList<Triple> L, CMap map) {
		if(L.size()==0) return;
		int x = map.distance[W][K]-1;
		
		
		for(int i = L.size()-1; i>=0;i--) {
			if(L.get(i).z>x)
				L.remove(i);
		}
		
		if(L.size()==0) return;
		int r=gen.nextInt(0, L.size());
		W = L.get(r).x;
		K = L.get(r).y;
	}
}
