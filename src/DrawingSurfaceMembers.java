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
public class DrawingSurfaceMembers extends PApplet {

	private Library library;	
		
	// CONSTRUCTOR - Initialize any added fields here.
	public DrawingSurfaceMembers(Library l) 
	{
		library = l;
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
	
	public void mousePressed() {
//		float x = super.mouseX * (DRAWING_WIDTH/(float)width);
//		float y = mouseY * (DRAWING_HEIGHT/(float)height);
//		
//		for (int i = 0; i < boxes.length; i++) {
//			Rectangle e = boxes[i];
//			if (e.contains(x,y)) {
//				if (m != null)
//					m.setColor(colors[i]);
//			}
//				
//		}
	}
	
	public void keyPressed() {
//		if (super.keyCode == KeyEvent.VK_SPACE && m == null) {
//
//			m = new DrawingSurface2();
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
//			
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
