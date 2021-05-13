/**
 * Represents a book. Has an author, title, and # of pages.
 * @author Caden Pun 
 *
 */
public class Book extends ItemTemplate{
	
	private String numPages;
	
	public Book() {
		super();
	}
	
	/**
	 * Sets the book's title, author, and length to the given values
	 * @param title Title
	 * @param author Author
	 * @param length Total number of pages
	 * @pre title and publisher need to be a single string where different words are separated by underscores only
	 */
	public Book(String title, String author, String length) {
		super(title, author);
		numPages = length;
	}
	
	/**
	 * Returns the total number of pages in the book
	 */
	public String getLength() {
		return numPages;
	}
	
	public String toString() {
		return "Title: " + getTitle() + 
			   "\nAuthor: " + getAuthor() + 
			   "\nLength: " + getLength() + " Pages" +
			   "\nAvailable: " + getAvailability();
	}
	
	
}
