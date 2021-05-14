import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;
/**
 * The surface on which the Library can be accessed (Graphic Interface).
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
		
			
		popStyle();

	}
	
	
}
