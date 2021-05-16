import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;
/**
 * Graphical representation of the Members. Has a list of items.
 * @author Harshith Pothula
 *
 */
public class DrawingSurfaceMembers extends PApplet {

	private ArrayList<Member> list;	
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceMembers(ArrayList<Member> arrayList) 
	{
		list = arrayList;
	}
	
	
	// METHODS
	// Add processing methods here. See the documentation at processing.org for reference.
	public void setup() 
	{
	}
	
	
	public void draw()
	{
		background(255);
		pushStyle();
		fill(0);
		textSize(25);
		textAlign(CENTER, CENTER);
		int x = list.size();
		for (int i = 0; i < x; i++) {
			line(0, i*(height/x), width, i*(height/x)) ;
			text(list.get(i).getName(), 0, i*(height/x), width/2, height/x);
			text(list.get(i).getID(), width/2, i*(height/x), width/2, height/x);
		}
		
		popStyle();

	}
	
	public void mousePressed() {
		float s = list.size();
		float x = mouseX;
		float y = mouseY;
		Member m = null;
		
//		for (int i = 0; i < s; i++) {
//			if (y > i*(height/x) && y < (i*(height/x)) +(i*(height/x))) {
//				if (m == null) {
//					m = list.get(i);
//				}
//			}
//		}
		
		m = list.get(0);
		if (m != null) {
			JOptionPane.showMessageDialog(null, m.toString());
		}
	}
}
