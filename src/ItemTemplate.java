
/*
 * This is a template for books, magazines, and DVDs. Has a boolean determing if checked out or not.
 * @author Caden Pun
 */
public class ItemTemplate {

	private String title, author;
	private boolean available;
	
	public ItemTemplate() {
		title = "";
		author = "";
		available = false;
	}
	
	public ItemTemplate(String t, String a) {
		title = t;
		author = a;
		available = true;
	}
	
	public boolean getAvailability() {
		return available;
	}
	
	public void setAvailability(boolean a) {
		available = a;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
}
