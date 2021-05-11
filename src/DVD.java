/**
 * Represents a DVD. Has a title, publisher, and runtime.
 * @author Caden Pun 
 *
 */
public class DVD extends ItemTemplate{

	private int runtime;
	
	public DVD() {
		super();
	}
	
	public DVD(String title, String author, int runtime) {
		super(title, author);
		this.runtime = runtime;
	}
	
	public int getRunTime() {
		return runtime;
	}
}
