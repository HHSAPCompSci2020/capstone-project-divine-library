import java.awt.Point;
import java.awt.event.KeyEvent;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	// When you progress to a new prompt, modify this field.
	private Library library;
	
	
	public DrawingSurface() {
		library = new Library("testfiles/labyrinth/test4.txt");
	}
	

	public void draw() { 
		background(255);   
		fill(0);
		textAlign(LEFT);
		textSize(12);
		
		if (library != null) {
			library.draw(this, 0, 0, height, height);
		}
		
	}
	
	
	public void mousePressed() {
		
	}
	
	

	
}










