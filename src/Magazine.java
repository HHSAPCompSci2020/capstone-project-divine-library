/**
 * Represents a magazine. Has an author, title, and publish date.
 * @author Caden Pun 
 *
 */
public class Magazine extends ItemTemplate{

	private int edition;
	
	public Magazine() {
		super();
	}
	
	public Magazine(String title, String author, int edition) {
		super(title, author);
		this.edition = edition;
	}
	
	public int getEdition() {
		return edition;
	}
}
