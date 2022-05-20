import java.util.ArrayList;
import java.util.Random;

public class CMoveObject extends CObj {
	Random gen = new Random();
	public CMoveObject(){
		super();
	}
	
	public CMoveObject(int W, int K) {
		super(W,K);
	}
	
	public void SelMove(ArrayList<Triple> L, CMap map) {
		if(L.size()==0) return;
		int r=gen.nextInt(0, L.size());
		W = L.get(r).x;
		K = L.get(r).y;
	}
}
