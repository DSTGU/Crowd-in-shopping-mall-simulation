import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CMyPanel extends JPanel implements ActionListener {
	final int Panel_width = 500;
	final int Panel_height = 500;
	Image imgW; 
	Image imgO;
	Image imgP;
	Image imgU;
	Image imgC;
	Image backgroundimg; 
	Timer timer;
	CSimulator sim = new CSimulator();
	
	
	
	CMyPanel() throws Exception{
		this.setPreferredSize(new Dimension(Panel_width, Panel_height));
		this.setBackground(Color.black);
		imgW = new ImageIcon("imgW.png").getImage();
		imgO = new ImageIcon("imgO.png").getImage();
		imgP = new ImageIcon("imgP.png").getImage();
		imgU = new ImageIcon("imgU.png").getImage();
		imgC = new ImageIcon("imgC.png").getImage();
		timer = new Timer(500, this);
		sim.load_data();
		sim.map.create();
		timer.start();
		
	}
	
	public void paint (Graphics G) {
		super.paint(G);
		Graphics2D G2D = (Graphics2D) G;
		for(CObj i: sim.ShowObj.L) {
			if(i.typ=='W')
				G2D.drawImage(imgW,  i.K*10,  i.W*10, null);
			if(i.typ=='O')
				G2D.drawImage(imgO,  i.K*10,  i.W*10, null);
			if(i.typ=='P')
				G2D.drawImage(imgP,  i.K*10,  i.W*10, null);
			if(i.typ=='C')
				G2D.drawImage(imgC,  i.K*10,  i.W*10, null);
			if(i.typ=='U')
				G2D.drawImage(imgU,  i.K*10,  i.W*10, null);		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sim.executestep(sim.ShowObj, sim.map);
		sim.ShowObj.Show();
		repaint();
	}
}
