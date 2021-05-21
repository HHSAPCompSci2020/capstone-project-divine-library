package items;

/**
 * Represents a DVD. Has a title, publisher, and runtime.
 * @author Caden Pun 
 *
 */
public class DVD extends ItemTemplate{

	private String runtime;
	
	public DVD() {
		super();
	}
	
	/**
	 * Sets the DVD's title, publisher, and run time to the given values
	 * @param title Title
	 * @param publisher Publisher
	 * @param runtime Runtime
	 * @pre title and publisher need to be a single string where different words are separated by underscores only. runtime is in the format hh:mm:ss
	 */
	public DVD(String title, String publisher, String runtime) {
		super(title, publisher);
		this.runtime = runtime;
	}
	
	/**
	 * @return runtime in the format hh:mm:ss
	 */
	public String getRuntime() {
		return runtime;
	}
	
	/**
	 * @return String of the book's title, author, length, and availability
	 */
	public String toString() {
		return "Title: " + getTitle() + 
			   "\nPublisher: " + getAuthor() + 
			   "\nLength: " + getRuntime() +
			   "\nAvailable: " + getAvailability();
	}
}
