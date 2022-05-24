package Projekt;
import java.awt.*;
import java.util.ArrayList;

public interface IObj {
   public void paint(Graphics G2D);
   public void ShowInCharMap(ArrayList<String> charMap);
   public boolean yourpositionis(int W, int K);
   public CPossition getPossition();
   public void gotoOut();
}
