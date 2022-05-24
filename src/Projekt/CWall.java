package Projekt;
import javax.swing.*;
import java.awt.*;

public class CWall extends CObj {
	public CWall(){
		super();
		typ='W';
		img = new ImageIcon("imgW.png").getImage();
	}

	public CWall(int W, int K) {
		super(W, K);
		typ = 'W';
		img = new ImageIcon("imgW.png").getImage();
	}
}
