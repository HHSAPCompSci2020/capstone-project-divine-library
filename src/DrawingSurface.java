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
	private DrawingSurfaceShelves shelves;
	private DrawingSurfaceMembers list;
	private DrawingSurfaceShelves s;
	private DrawingSurfaceMembers m;
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
		
		image(book,                 (float) 0, (float) (height/4.0),  (float)(width/3.0), (float)(height/3.0));
		image(  cd,        (float)(width/3.0), (float) (height/4.0),  (float)(width/3.0), (float)(height/3.0));
		image( mag, (float) (2.0*(width/3.0)), (float) (height/4.0),  (float)(width/3.0), (float)(height/3.0));
		
		textSize(height/12);
		textAlign(CENTER);
		fill(0);
		text("Books",                        (float) (width/6.0), (float) (height/10.0));
		text("DVDs",                         (float) (width/2.0), (float) (height/10.0));
		text("Newspapers \n& Magazines", (float) (5*(width/6.0)), (float) (height/10.0));
		text("Members",                      (float) (width/2), (float) (height/4 + height/3 + height/8));
		    
		noFill();
		strokeWeight(3);
		rect((float) 0,                 (float) (height/4.0),  (float)(width/3.0), (float)(height/3.0));
		rect((float)(width/3.0),        (float) (height/4.0),  (float)(width/3.0), (float)(height/3.0));
		rect((float) (2.0*(width/3.0)), (float) (height/4.0),  (float)(width/3.0), (float)(height/3.0));
		rect((float) 0,                 (float) (height/4 + height/3), (float) width, (float) (height/4));
		popStyle();
		
	}
	
	
	
	public void mousePressed() {
		float x = mouseX;
		float y = mouseY;
		
		if (x>0          && y>height/4                   && x<width/3      && y<height/4 +height/3) {
			s = new DrawingSurfaceShelves(library.getShelves().getBookShelf(), library);
		}
		 if (x>width/3    && y>height/4        && x < (2*width/3) && y<(height/4 +height/3)) {
			s = new DrawingSurfaceShelves(library.getShelves().getDVDShelf(), library);
		}
		 if (x>(2*width/3) && y > height/4  &&  x<width        && y<height/4 +height/3){
			s = new DrawingSurfaceShelves(library.getShelves().getMagazineShelf(), library);
		}
		 if (x > 0       && y > height/4 + height/3    && x < width      && y < height/2 + height/3) {
			m = new DrawingSurfaceMembers(library.getMemberList().getMemberList());
		}
		
		if (s != null) {
			PApplet.runSketch(new String[]{""}, s);
			PSurfaceAWT surf2 = (PSurfaceAWT) s.getSurface();
			PSurfaceAWT.SmoothCanvas canvas2 = (PSurfaceAWT.SmoothCanvas) surf2.getNative();
			JFrame window2 = (JFrame)canvas2.getFrame();

			window2.setBounds(500,50,800, 600);
			window2.setMinimumSize(new Dimension(100,100));
			window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window2.setResizable(true);
			canvas2.requestFocus();

		}
		
		if (m != null) {
			PApplet.runSketch(new String[]{""}, m);
			PSurfaceAWT surf2 = (PSurfaceAWT) m.getSurface();
			PSurfaceAWT.SmoothCanvas canvas2 = (PSurfaceAWT.SmoothCanvas) surf2.getNative();
			JFrame window2 = (JFrame)canvas2.getFrame();

			window2.setBounds(500,50,800, 600);
			window2.setMinimumSize(new Dimension(100,100));
			window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window2.setResizable(true);
			canvas2.requestFocus();

		}
		
	}
	
	
}
