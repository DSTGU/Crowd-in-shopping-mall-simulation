import javax.swing.*;
import java.awt.*;

public class CExit extends CObj {
	public CExit(){
		super();
		typ='O';
		img = new ImageIcon("imgO.png").getImage();
	}

	public CExit(int W, int K) {
		super(W, K);
		typ = 'O';
		img = new ImageIcon("imgO.png").getImage();

	}
}
