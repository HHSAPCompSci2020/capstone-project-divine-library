import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import members.Member;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;
/**
 * Graphical representation of the Members. Has a list of items.
 * @author Harshith Pothula
 *
 */
public class DrawingSurfaceMembers extends Screen {

	private ArrayList<Member> list;	
	private DrawingSurface surface;
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceMembers(ArrayList<Member> arrayList, DrawingSurface s) 
	{
		super(s.width, s.height);
		list = arrayList;
		surface = s;
	}
	
	
	// METHODS
	// Add processing methods here. See the documentation at processing.org for reference.
	public void setup() 
	{
	}
	
	
	public void draw()
	{
		surface.background(255);
		surface.pushStyle();
		surface.fill(0);
		surface.textSize(25);
		surface.textAlign(surface.CENTER,surface.CENTER);
		int x = list.size();
		for (int i = 0; i < x; i++) {
			surface.line(0, i*(surface.height/x), surface.width, i*(surface.height/x)) ;
			surface.text(list.get(i).getName(), 0, i*(surface.height/x), surface.width/2,surface.height/x);
			surface.text(list.get(i).getID(), surface.width/2, i*(surface.height/x), surface.width/2, surface.height/x);
		}
		
		surface.popStyle();

		
		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		}
	}
	
	public void mousePressed() {
		float s = list.size();
		float x = surface.mouseX;
		float y = surface.mouseY;
		Member m = null;
		
		for (int i = 0; i < s; i++) {
			if (m == null) {
			if (y > i*(surface.height/s) && y < (i+1)*(surface.height/s)) {
					m = list.get(i);
				}
			}
		}
		
		if (surface.mouseButton == surface.LEFT) {
			if (m != null) {
				JOptionPane.showMessageDialog(null, m.toString());
			}
		}
		if (surface.mouseButton == surface.RIGHT) {
			if (m != null) {
				String newName = JOptionPane.showInputDialog(m.toString() + "\nEnter New Member Name.");
				if (newName != null && !(newName.isEmpty())) {
					if (m.getName() != null) {
						m.setName(newName);
					}
				}
			}
		}
	}
	
	
}
