import java.util.ArrayList;

public class CSimulator {
	ArrayList<CMoveObject> L = new ArrayList<CMoveObject>();
	public void add(CMoveObject obj) {
		L.add(obj);
	}
	
	boolean IsObjectAt(int W, int K, ArrayList<CObj> L) {
		for(CObj S: L) {
			if((S.W==W)&&(S.K==K)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Triple> explore(CMoveObject obj, ArrayList<CObj> L, int[][] distance) {
		ArrayList<Triple> triple = new ArrayList<Triple>(); 
		int W = obj.W;
		int K = obj.K;
		if((IsObjectAt(W-1, K, L))==false){		
			triple.add(new Triple(W-1,K,distance[W-1][K]));
		}
		if((IsObjectAt(W+1, K, L))==false){
			triple.add(new Triple(W+1,K,distance[W+1][K]));	
		}
		if((IsObjectAt(W, K-1, L))==false){
			triple.add(new Triple(W,K-1,distance[W][K-1]));
		}
		if((IsObjectAt(W, K+1, L))==false){
			triple.add(new Triple(W,K+1,distance[W][K+1]));
		}
		return triple;
	}

	public void executestep(CShowObj ShowObj, CMap map) {
		for(int j = L.size()-1; j>=0; j--) {
		
		if(map.distance[L.get(j).W][L.get(j).K]==1) {
			L.get(j).W=0;
			L.get(j).K=0;			
			L.remove(j);
			continue;
		}
			
		ArrayList<Triple> Tr = explore(L.get(j), ShowObj.L, map.distance);
		//for(Triple i: Tr)
			//System.out.println(i.x+" "+i.y+" "+i.z);
		//System.out.println(Tr.size());
		L.get(j).SelMove(Tr, map);
		}
	}
}
