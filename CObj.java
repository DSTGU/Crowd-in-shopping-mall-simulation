

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
	
	

}
