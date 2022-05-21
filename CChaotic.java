import javax.swing.*;
import java.awt.*;

public class CChaotic extends CMoveObject{
	public CChaotic(){
		super();
		typ='C';
		img = new ImageIcon("imgC.png").getImage();
	}

	public CChaotic(int W, int K) {
		super(W, K);
		typ = 'C';
		img = new ImageIcon("imgC.png").getImage();
	}
}
