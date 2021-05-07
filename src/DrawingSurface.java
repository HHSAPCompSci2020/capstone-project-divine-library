import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;
/**
 * The surface on which the Library can be accessed (Graphic Interface).
 * @author Harshith Pothula
 *
 */
public class DrawingSurface extends PApplet {

	private Library library;	
	
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurface() 
	{
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
		textSize(10);
		text("TEST",10,10);
		
		popStyle();

	}
}
