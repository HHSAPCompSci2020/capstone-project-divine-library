import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
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
public class DrawingSurface extends PApplet {

	private Library library;	
	private DrawingSurfaceShelves m;
	private DrawingSurfaceMembers list;
	private PImage book, cd, mag;

	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurface() 
	{
		library = new Library ("BookList.txt","DvdList.txt", "MagazineList.txt", "MemberList.txt");
	}
	
	
	// METHODS
	// Add processing methods here. See the documentation at processing.org for reference.
	public void setup() 
	{
		book = loadImage("BookShelf.png");
		cd = loadImage("DVD.jpg");
		mag = loadImage("MagazineRack.jpg");

	}
	
	
	public void draw()
	{
		background(255);
		pushStyle();
		
		image(book,                 (float) 0, (float) (width/5.0),  (float)(width/3.0), (float)(height/3.0));
		image(  cd,        (float)(width/3.0), (float) (width/5.0),  (float)(width/3.0), (float)(height/3.0));
		image( mag, (float) (2.0*(width/3.0)), (float) (width/5.0),  (float)(width/3.0), (float)(height/3.0));
		
		textSize(height/12);
		textAlign(CENTER);
		fill(0);
		text("Books",                        (float) (width/6.0), (float) (width/10.0));
		text("DVDs",                         (float) (width/2.0), (float) (width/10.0));
		text("Newspapers \n& Magazines", (float) (5*(width/6.0)), (float) (width/10.0));
		    
		noFill();
		strokeWeight(3);
		rect((float) 0, (float) (width/5.0),  (float)(width/3.0), (float)(height/3.0));
		rect((float)(width/3.0), (float) (width/5.0),  (float)(width/3.0), (float)(height/3.0));
		rect((float) (2.0*(width/3.0)), (float) (width/5.0),  (float)(width/3.0), (float)(height/3.0));
		
		popStyle();

	}
	
	public void mousePressed() {
		
	}
	public void keyPressed() {
//		if (super.keyCode == KeyEvent.VK_SPACE && m == null) {
//
//			m = new DrawingSurfaceShelves();
//			
//			PApplet.runSketch(new String[]{""}, m);
//			PSurfaceAWT surf2 = (PSurfaceAWT) m.getSurface();
//			PSurfaceAWT.SmoothCanvas canvas2 = (PSurfaceAWT.SmoothCanvas) surf2.getNative();
//			JFrame window2 = (JFrame)canvas2.getFrame();
//
//			window2.setBounds(500,50,800, 600);
//			window2.setMinimumSize(new Dimension(100,100));
//			window2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//			window2.setResizable(true);
//			canvas2.requestFocus();
//			
//			
//		} else if (super.keyCode == KeyEvent.VK_SPACE) {
//			
//			PSurfaceAWT surf2 = (PSurfaceAWT) m.getSurface();
//			PSurfaceAWT.SmoothCanvas canvas2 = (PSurfaceAWT.SmoothCanvas) surf2.getNative();
//			JFrame window2 = (JFrame)canvas2.getFrame();
//			
//			window2.setVisible(!window2.isVisible());
//			
//		}
	}

}
