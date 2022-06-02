package Projekt;

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.io.File;*/

public class Projekt {
	static int tempdebug = 0; // Wyłącza output normalny żeby można było podebugować w spokoju bez lawiny w commandline
	//static CSimulator sim = new CSimulator(); // Ta linijka wygląda na niepotrzebą ponieważ symulacja jest inicjowana w klasie CMyPanel, ale jeszcze jej nie usuwam bo tak w sumie to nie wiem
	public static void main(String[] args) throws Exception  {
		new CMyFrame("map4x2.txt"); // Nazwa mapy obecnie stosowanej, przejście w głąb kodu
	}

}