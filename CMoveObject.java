import java.util.ArrayList;
import java.util.Random;

public class CMoveObject extends CObj {
	Random gen = new Random();
	public CMoveObject(){
		super();
	}
	
	public CMoveObject(int W, int X) {
		super(W,X);
	}
	
	public void SelMove(CMap map, CShowObj ShowObj) {
		ArrayList<CPossition> neighbours = explore(ShowObj.L);
		if(neighbours.size()==0) 
			return;
		int r=gen.nextInt(0, neighbours.size());
		getPossition().Y = neighbours.get(r).Y;
		getPossition().X = neighbours.get(r).X;
	}
}
