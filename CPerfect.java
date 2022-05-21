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
	
	public void SelMove(CMap map, CShowObj ShowObj) {
		ArrayList<Pair> neighbours = explore(ShowObj.L);
		if(neighbours.size()==0) 
			return;
		int mn = map.distance[W][K]-1;
		for(int i = neighbours.size()-1; i >= 0; i--) {
			if(map.distance[neighbours.get(i).X][neighbours.get(i).Y]>mn)
				neighbours.remove(i);
		}
		if(neighbours.size()==0) return;
		int r=gen.nextInt(0, neighbours.size());
		W = neighbours.get(r).X;
		K = neighbours.get(r).Y;
	}
}
