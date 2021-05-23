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
public class DrawingSurfaceWaitlist extends Screen {

	private ItemTemplate[][] items;	
	private Library lib;
	private DrawingSurface surface;
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceWaitlist(ItemTemplate[][] itemTemplates, Library lib, DrawingSurface s)
	{
		super(s.width,s.height);
		items = itemTemplates;
		this.lib = lib;
		surface = s;
		
		ArrayList<ItemTemplate> list = new ArrayList<ItemTemplate>();
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[0].length; j ++) {
				if (!items[j][i].getStatus())
					list.add(items[j][i]);
			}
		}
		
		items = convertToArray(list);
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
		
		if (item != null) {
			
			if(!item.isWaitlisted()) {
				String id = JOptionPane.showInputDialog(item.toString() + "\nEnter Member ID to waitlist book.");
				if (id != null) {
					if (lib.getMemberList().IDMatch(id) != null) {
						item.setWaitlister(true, lib.getMemberList().IDMatch(id));
						
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, item.getWaitlistStatus());
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
	
	private ItemTemplate[][] convertToArray(ArrayList<ItemTemplate> items) {
		ItemTemplate[][] a = new ItemTemplate[5][5];
		
		if (items.size() >= 25) {
			int x = (int) Math.sqrt(items.size()) + 1;
			a = new ItemTemplate[x][x];
		}
		int n = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (items.size() > n) {
					a[j][i] = items.get(n);
				}
				else {
					a[j][i] = new ItemTemplate();
				}
				n++;
			}
		}
		
		return a;
	}
	
}
