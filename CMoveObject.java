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
	
	public void SelMove(CMap map, CShowObj ShowObj) {
		ArrayList<Pair> neighbours = explore(ShowObj.L);
		if(neighbours.size()==0) 
			return;
		int r=gen.nextInt(0, neighbours.size());
		W = neighbours.get(r).X;
		K = neighbours.get(r).Y;
	}
}
