package items;

/**
 * Represents a magazine or newspaper. Has an title, publisher, and edition.
 * @author Caden Pun 
 *
 */
public class Magazine extends ItemTemplate{

	private String edition;
	
	public Magazine() {
		super();
	}
	
	/**
	 * Sets this Magazine or Newspaper's title, publisher, edition with the given values.
	 * @param title Title
	 * @param publisher Publisher
	 * @param edition Edition 
	 * @pre title and publisher need to be a single string where different words are separated by underscores only. Edition is in the format mm/yyyy
	 */
	public Magazine(String title, String publisher, String edition) {
		super(title, publisher);
		this.edition = edition;
	}
	
	/**
	 * @return the item's edition in the format mm/yyyy
	 */
	public String getEdition() {
		return edition;
	}
	
	/**
	 * @return String of the book's title, author, length, and availability
	 */
	public String toString() {
		return "Title: " + getTitle() + 
				"\nPublisher: " + getAuthor() + 
				"\nEdition: " + getEdition() +
				"\nAvailable: " + getAvailability();
	}
}
