/**
 * Represents a book. Has an author, title, and # of pages.
 * @author Caden Pun 
 *
 */
public class Book extends ItemTemplate{
	
	private int numPages;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, int length) {
		super(title, author);
		numPages = length;
	}
	
	public int getLength() {
		return numPages;
	}
	
	
}
