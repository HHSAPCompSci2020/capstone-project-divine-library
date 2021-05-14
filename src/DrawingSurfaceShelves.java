import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
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
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceShelves(ItemTemplate[][] itemTemplates)
	{
		items = itemTemplates;
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
		text("Items to be added", 10, 100);
			
		popStyle();

	}
	
	
}
