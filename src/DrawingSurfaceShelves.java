import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import items.ItemTemplate;
import libraryObjects.Library;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;
/**
 * Graphical representation of the shelves, has a list of items on these shelves.
 * @author Harshith Pothula
 *
 */
public class DrawingSurfaceShelves extends PApplet {

	private ItemTemplate[][] items;	
	private Library lib;
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceShelves(ItemTemplate[][] itemTemplates, Library lib)
	{
		items = itemTemplates;
		this.lib = lib;
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
		
		float x = items.length;
		float y = items[0].length;
		
		for (int i = 1; i <= x; i++) {
			line(i*(width/x), 0, i*(width/x), height );
			line(0, i*(height/x), width, i*(height/x)) ;
		}
		fill(0);
		textSize(15);
		this.textAlign(CENTER, CENTER);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				text(items[i][j].getTitle(), i*(width/x), j*(height/y), width/x, height/y);
			}
		}
			
		popStyle();

	}
	
	public void mousePressed() {
		
		float x = items.length;
		float y = items[0].length;
		float mx = mouseX;
		float my = mouseY;
		ItemTemplate item = null;
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (item == null) {
					if (mx > i*(width/x) && my > j*(height/y) && mx < (i*(width/x)) + width/x && my < (j*(height/y) + height/y)) {
						item = items[i][j];
					}
				}
			}
		}
		
		if (item != null) {
			if(item.getStatus()) {
				String id = JOptionPane.showInputDialog(item.toString() + "\nEnter Member ID to borrow book.");
				if (id != null) {
					if (lib.getMemberList().IDMatch(id) != null) {
						lib.getMemberList().IDMatch(id).addBorrow(item);
						item.setAvailability(false, lib.getMemberList().IDMatch(id));
						
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, item.toString());
			}
		}
//		if (true) {
//			JOptionPane.showMessageDialog(null, "You hit the red rectangle!");
//		} else if (true) {
//			int answer = JOptionPane.showConfirmDialog(null, "Quit the program?");
//			if (answer == JOptionPane.YES_OPTION) {
//				System.exit(0);
//			}
//		} else if (true) {
//			String answer = JOptionPane.showInputDialog("Name this rectangle!");
//			if (answer == null)
//				answer = "";
//		} 
		
	}
	
}
