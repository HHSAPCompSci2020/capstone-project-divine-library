import java.awt.Dimension;
import java.awt.Rectangle;
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
	private DrawingSurfaceShelves shelves;
	private DrawingSurfaceMembers list;
	
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurface() 
	{
		library = new Library ("BookList.txt","DvdList.txt", "MagazineList.txt", "MemberList.txt");
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
		text(library.getShelves().getBookShelf().get(0).toString(),10,10);
		
		popStyle();

	}
	

}
