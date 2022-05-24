package Projekt;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CMyPanel extends JPanel implements ActionListener {
	Timer timer;
	CSimulator sim = new CSimulator();
	final int Panel_width = 3440;
	final int Panel_height = 1440;
	int counter=0;

	CMyPanel(String mapFilename) throws Exception{
		this.setPreferredSize(new Dimension(Panel_width, Panel_height));
		this.setBackground(Color.black);
		timer = new Timer(50, this);
		sim.start(mapFilename);
		timer.start();
		
	}
	
	public void paint (Graphics G) {
		super.paint(G);
		Graphics2D G2D = (Graphics2D) G;
		for(CObj i: sim.ShowObj.L) {
			i.paint(G2D);
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		sim.executestep(sim.ShowObj, sim.map);
		//sim.ShowObj.Show();
		sim.stat.compute(sim.L, sim.map);
		counter++;
		if(counter==1000) {
			try {
				sim.stat.savetofile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		repaint();


	}
}
