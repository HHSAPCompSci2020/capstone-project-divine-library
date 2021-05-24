import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

import libraryObjects.Library;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;
/**
 * The surface on which the Library can be accessed (Graphic Interface).
 * @author Harshith Pothula
 *
 */
public class DrawingSurfaceLibrary extends Screen {

	private Library library;	
	private DrawingSurfaceShelves shelves;
	private DrawingSurfaceMembers list;
	private DrawingSurfaceShelves s;
	private DrawingSurfaceMembers m;
	private PImage book, cd, mag;
	private DrawingSurface surface;

	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceLibrary(DrawingSurface s) 
	{
		super(s.width, s.height);
		library = new Library ("BookList.txt","DvdList.txt", "MagazineList.txt", "MemberList.txt");
		surface = s;
	}
	
	
	// METHODS
	// Add processing methods here. See the documentation at processing.org for reference.
	public void setup() 
	{
		book = surface.loadImage("BookShelf.png");
		cd = surface.loadImage("DVD.jpg");
		mag = surface.loadImage("MagazineRack.jpg");

	}
	
	/**
	 * Draws the images and boxes representing the shelves, member list, and waitlist.
	 */
	public void draw()
	{
		surface.background(255);
		surface.pushStyle();
		
		surface.image(book,                 (float) 0, (float) (surface.height/4.0),  (float)(surface.width/3.0), (float)(surface.height/3.0));
		surface.image(  cd,        (float)(surface.width/3.0), (float) (surface.height/4.0),  (float)(surface.width/3.0), (float)(surface.height/3.0));
		surface.image( mag, (float) (2.0*(surface.width/3.0)), (float) (surface.height/4.0),  (float)(surface.width/3.0), (float)(surface.height/3.0));
		
		surface.textSize(surface.height/12);
		surface.textAlign(surface.CENTER);
		surface.fill(0);
		surface.text("Books",                        (float) (surface.width/6.0), (float) (surface.height/10.0));
		surface.text("Waitlist", (float) (surface.width/6), (float) (surface.height/4 + surface.height/3 + surface.height/8));

		surface.text("DVDs",                         (float) (surface.width/2.0), (float) (surface.height/10.0));
		surface.text("Waitlist", (float) (surface.width/2), (float) (surface.height/4 + surface.height/3 + surface.height/8));

		surface.text("Newspapers \n& Magazines", (float) (5*(surface.width/6.0)), (float) (surface.height/10.0));
		surface.text("Waitlist", (float) (5*(surface.width/6.0)), (float) (surface.height/4 + surface.height/3 + surface.height/8));

		surface.text("Members",                      (float) (surface.width/2), (float) (surface.height - surface.height/10));
		    
		surface.noFill();
		surface.strokeWeight(3);
		surface.rect((float) 0,                 (float) (surface.height/4.0),  (float)(surface.width/3.0), (float)(surface.height/3.0));
		surface.rect((float)(surface.width/3.0),        (float) (surface.height/4.0),  (float)(surface.width/3.0), (float)(surface.height/3.0));
		surface.rect((float) (2.0*(surface.width/3.0)), (float) (surface.height/4.0),  (float)(surface.width/3.0), (float)(surface.height/3.0));
		
		surface.rect((float) 0,                 (float) (surface.height/4.0 + surface.height/3.0),  (float)(surface.width/3.0), (float)(surface.height/5.0));
		surface.rect((float)(surface.width/3.0),        (float) (surface.height/4.0 + surface.height/3.0),  (float)(surface.width/3.0), (float)(surface.height/5.0));
		surface.rect((float) (2.0*(surface.width/3.0)), (float) (surface.height/4.0 + surface.height/3.0),  (float)(surface.width/3.0), (float)(surface.height/5.0));
		
		surface.popStyle();
		
	}
	
	
	/**
	 * Depending on the coordinates of the mouse press, the screen will switch to a shelf, member list, or waitlist.
	 */
	public void mousePressed() {
		float x = surface.mouseX;
		float y = surface.mouseY;
		
		if (x>0          && y>surface.height/4                   && x<surface.width/3      && y<surface.height/4 +surface.height/3) {
			surface.setShelf("BOOK");
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		}
		if (x>surface.width/3    && y>surface.height/4        && x < (2*surface.width/3) && y<(surface.height/4 +surface.height/3)) {
			surface.setShelf("DVD");
			surface.switchScreen(ScreenSwitcher.SCREEN2);

		}
		if (x>(2*surface.width/3) && y > surface.height/4  &&  x<surface.width        && y<surface.height/4 +surface.height/3){
			surface.setShelf("MAG");
			surface.switchScreen(ScreenSwitcher.SCREEN2);

		}
		if (x > 0  && y > surface.height/4.0 + surface.height/3.0 + surface.height/5.0 && x < surface.width && y < surface.height) {
			surface.switchScreen(ScreenSwitcher.SCREEN3);
		}
		
		if (x>0          && y>surface.height/4 +surface.height/3                  && x<surface.width/3      && y<surface.height/4 +surface.height/3+ surface.height/5.0) {
			surface.setShelf("BOOK");
			surface.switchScreen(ScreenSwitcher.SCREEN4);
		}

		if (x>surface.width/3    && y>surface.height/4 +surface.height/3       && x < (2*surface.width/3) && y<(surface.height/4 +surface.height/3+ surface.height/5.0)) {
			surface.setShelf("DVD");
			surface.switchScreen(ScreenSwitcher.SCREEN4);
		}
		
		if (x>(2*surface.width/3) && y > surface.height/4 +surface.height/3 &&  x<surface.width        && y<surface.height/4 +surface.height/3+ surface.height/5.0){
			surface.setShelf("MAG");
			surface.switchScreen(ScreenSwitcher.SCREEN4);
		}
	}
	
	
}
