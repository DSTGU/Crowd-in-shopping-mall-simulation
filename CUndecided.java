import java.util.ArrayList;

public class CUndecided extends CMoveObject{
	public CUndecided(){
		super();
		typ='U';
	}
	
	public CUndecided(int W, int K) {
		super(W, K);
		typ = 'U';
	}
	public void SelMove(ArrayList<Triple> L, CMap map) {
		if(L.size()==0) return;
		int x;
		x = L.get(0).z;
		for(Triple l: L) {
			if(l.z<L.get(0).z)
				x=l.z;
		}
		
		for(int i = L.size()-1; i>=0;i--) {
			if(L.get(i).z>x)
				L.remove(i);
		}
		int r=gen.nextInt(0, L.size());
		W = L.get(r).x;
		K = L.get(r).y;
	}
}
