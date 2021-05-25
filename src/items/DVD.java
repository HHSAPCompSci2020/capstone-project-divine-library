package items;

/**
 * Represents a DVD. inherited all variables from itemTemplate, plus the runtime.
 * @author James Jian 
 * @author Caden Pun 
 * @author Harshith Pothula
 * @version 5/24
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
	 * returns runtime in the format hh:mm:ss
	 * @return runtime in the format hh:mm:ss
	 */
	public String getRuntime() {
		return runtime;
	}
	
	/**
	 * returns String of the book's title, author, length, and availability
	 * @return String of the book's title, author, length, and availability
	 */
	public String toString() {
		return "Title: " + getTitle() + 
			   "\nPublisher: " + getAuthor() + 
			   "\nLength: " + getRuntime() +
			   "\nAvailable: " + getAvailability();
	}
}
