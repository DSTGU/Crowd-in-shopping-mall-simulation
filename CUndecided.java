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
	
	public void SelMove(CMap map, CShowObj ShowObj) {
		ArrayList<Pair> neighbours = explore(ShowObj.L);
		if(neighbours.size()==0) 
			return;
		int mn = map.distance[neighbours.get(0).X][neighbours.get(0).Y];
		for(Pair j: neighbours) {
			if(map.distance[j.X][j.Y]<mn)
				mn=map.distance[j.X][j.Y];
		}
		for(int i = neighbours.size()-1; i >= 0; i--) {
			if(map.distance[neighbours.get(i).X][neighbours.get(i).Y]>mn)
				neighbours.remove(i);
		}
		int r=gen.nextInt(0, neighbours.size());
		W = neighbours.get(r).X;
		K = neighbours.get(r).Y;
	}
}
