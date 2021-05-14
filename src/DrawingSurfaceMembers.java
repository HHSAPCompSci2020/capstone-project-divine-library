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
		fill(255);
		textSize(25);
		text(list.get(0).toString(), 10, 10);
		
		popStyle();

	}
	
	
}
