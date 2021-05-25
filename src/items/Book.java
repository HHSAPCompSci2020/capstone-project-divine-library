package items;

/**
 * Represents a book. inherited all variables from itemTemplate, plus the number of pages.
 * @author James Jian
 * @author Harshith Pothula
 * @author Caden Pun 
 * @version 5/24
 */
public class Book extends ItemTemplate{
	
	private String numPages;
	
	public Book() {
		super();
	}
	
	/**
	 * Sets the book's title, author, and length to the given values
	 * @param title of the book in string
	 * @param author of the book in string
	 * @param length Total number of pages
	 * @pre title and publisher need to be a single string where different words are separated by underscores only
	 */
	public Book(String title, String author, String length) {
		super(title, author);
		numPages = length;
	}
	
	/**
	 * returns the total number of pages in the book
	 * @return the total number of pages in the book
	 */
	public String getLength() {
		return numPages;
	}
	
	/**
	 * returns an availability statement in string
	 * @return String of the book's title, author, length, and availability
	 */
	public String toString() {
		return "Title: " + getTitle() + 
			   "\nAuthor: " + getAuthor() + 
			   "\nLength: " + getLength() + " Pages" +
			   "\nAvailable: " + getAvailability();
	}
	
	
}
