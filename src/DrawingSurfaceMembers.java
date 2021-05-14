import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;
/**
 * The surface on which the Library can be accessed (Graphic Interface).
 * @author Harshith Pothula
 *
 */
public class DrawingSurfaceMembers extends PApplet {

	private ArrayList<ItemTemplate> list;	
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceMembers(ArrayList<ItemTemplate> l) 
	{
		list = l;
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
