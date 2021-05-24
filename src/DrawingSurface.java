

import java.awt.Point;
import java.util.ArrayList;

import libraryObjects.Library;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet implements ScreenSwitcher {

	private float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	private Library library;	
	private DrawingSurfaceLibrary lib;
	private DrawingSurfaceShelves shelves;
	private DrawingSurfaceMembers members;
	private DrawingSurfaceWaitlist waiting;
	
	public DrawingSurface() {
		
		library = new Library ("BookList.txt","DvdList.txt", "MagazineList.txt", "MemberList.txt");
		screens = new ArrayList<Screen>();
		keys = new ArrayList<Integer>();
		
		
		 lib = new DrawingSurfaceLibrary(this);
		screens.add(lib);
		
		shelves = new DrawingSurfaceShelves(library.getShelves().getBookShelf(), library,this);
		screens.add(shelves);
		
		members = new DrawingSurfaceMembers(library.getMemberList().getMemberList(), this);
		screens.add(members);
		
		waiting = new DrawingSurfaceWaitlist(library.getShelves().getBookShelf(), library, this);
		screens.add(waiting);
		activeScreen = screens.get(0);
		
	}
	
	public void settings() {
		// size(DRAWING_WIDTH, DRAWING_HEIGHT, P2D);
		size(activeScreen.DRAWING_WIDTH, activeScreen.DRAWING_HEIGHT);
	}
	
	public void setup() {
		surface.setResizable(true);
		for (Screen s : screens)
			s.setup();
	}
	
	/**
	 * Draws the selected screen
	 */
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		pushMatrix();
		
//		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		popMatrix();
	}
	
	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}


	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}
	
	/**
	 * @param i Number of the screen to be switched to
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
	
	/**
	 * Sets a shelf to a different itemTemplate
	 * @param s type of shelf
	 */
	public void setShelf(String s) {
		if (s.equals("BOOK")) {
			screens.set(1, new DrawingSurfaceShelves(library.getShelves().getBookShelf(), library,this));
			screens.set(3, new DrawingSurfaceWaitlist(library.getShelves().getBookShelf(), library,this));

		}
		if (s.equals("DVD")) {
			screens.set(1, new DrawingSurfaceShelves(library.getShelves().getDVDShelf(), library,this));
			screens.set(3, new DrawingSurfaceWaitlist(library.getShelves().getDVDShelf(), library,this));

		}
		if (s.equals("MAG")) {
			screens.set(1, new DrawingSurfaceShelves(library.getShelves().getMagazineShelf(), library,this));
			screens.set(3, new DrawingSurfaceWaitlist(library.getShelves().getMagazineShelf(), library,this));

		}
	}

}
