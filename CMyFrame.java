import java.awt.*;
import javax.swing.*;

public class CMyFrame extends JFrame {
	CMyPanel panel;
	
	CMyFrame() throws Exception{
		panel = new CMyPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

}
