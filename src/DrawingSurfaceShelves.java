import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import items.ItemTemplate;
import libraryObjects.Library;
import members.Member;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;
/**
 * Graphical representation of the shelves, has a list of items on these shelves.
 * @author Harshith Pothula
 *
 */
public class DrawingSurfaceShelves extends Screen {

	private ItemTemplate[][] items;	
	private Library lib;
	private DrawingSurface surface;
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceShelves(ItemTemplate[][] itemTemplates, Library lib, DrawingSurface s)
	{
		super(s.width,s.height);
		items = itemTemplates;
		this.lib = lib;
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
		
		float x = items.length;
		float y = items[0].length;
		
		for (int i = 1; i <= x; i++) {
			surface.line(i*(surface.width/x), 0, i*(surface.width/x), surface.height );
			surface.line(0, i*(surface.height/x), surface.width, i*(surface.height/x)) ;
		}
		surface.fill(0);
		surface.textSize(15);
		surface.textAlign(surface.CENTER, surface.CENTER);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				surface.text(items[i][j].getTitle(), i*(surface.width/x), j*(surface.height/y), surface.width/x, surface.height/y);
			}
		}
			
		surface.popStyle();
		
		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		}

	}
	
	public void mousePressed() {
		
		float x = items.length;
		float y = items[0].length;
		float mx = surface.mouseX;
		float my = surface.mouseY;
		ItemTemplate item = null;
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (item == null) {
					if (mx > i*(surface.width/x) && my > j*(surface.height/y) && mx < (i*(surface.width/x)) + surface.width/x && my < (j*(surface.height/y) + surface.height/y)) {
						item = items[i][j];
					}
				}
			}
		}
		
		if (surface.mouseButton == surface.LEFT) {
			if (item != null) {
				if(item.getStatus()) {
					String id = JOptionPane.showInputDialog(item.toString() + "\nEnter Member ID to borrow book.");
					if (id != null) {
						if (lib.getMemberList().IDMatch(id) != null) {
							
							if (lib.getMemberList().IDMatch(id).addBorrow(item)) {
								item.setAvailability(false, lib.getMemberList().IDMatch(id));
							} else {
								JOptionPane.showMessageDialog(null, "Borrow limit reached.");
							}
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, item.toString());
				}
			}
		}
		if (surface.mouseButton == surface.RIGHT) {
			if (item != null) {
				if(!(item.getStatus())) {
					String id = JOptionPane.showInputDialog(item.toString() + "\nEnter Member ID to return book.");
					if (id != null) {
						if (lib.getMemberList().IDMatch(id) != null && id == item.getBorrower()) {
							lib.getMemberList().IDMatch(id).returned(item);
							item.setAvailability(true, lib.getMemberList().IDMatch(id));
							
							if (item.isWaitlisted()) {
								if (lib.getMemberList().IDMatch(item.getWaitlisterID()).addBorrow(item)) {
									item.setAvailability(false, lib.getMemberList().IDMatch(item.getWaitlisterID()));
									item.setWaitlister(false, new Member());
								} else {
									JOptionPane.showMessageDialog(null, "Borrow limit reached for Waitlister ID " + item.getWaitlisterID() + ", could not borrow " + item.getTitle() + ".");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Member ID " + id + " is not the current borrower of this item.");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, item.toString());
				}
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
