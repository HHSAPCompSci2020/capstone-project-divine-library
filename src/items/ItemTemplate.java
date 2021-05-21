package items;


/*
 * This is a template for books, magazines, and DVDs. Has a boolean determing if checked out or not.
 * @author Caden Pun
 */
public class ItemTemplate {

	private String title, author;
	private boolean available;
	
	/*
	 * Sets an empty title, author, and is not available
	 */
	public ItemTemplate() {
		title = "";
		author = "";
		available = false;
	}
	
	/**
	 * Sets the title and author to the given values and make it available
	 * @param t Title of the item
	 * @param a Author/Publisher of the item
	 * @pre t and a need to be a single string where different words are separated by underscores only
	 */
	public ItemTemplate(String t, String a) {
		title = t.replace('_', ' ');
		author = a.replace('_', ' ');
		available = true;
	}
	
	/**
	 * Returns the availability of the item
	 * @return Yes or No
	 */
	public String getAvailability() {
		if (available)
			return "Yes";
		else 
			return "No";
	}
	
	public boolean getStatus() {
		return available;
	}
	
	/**
	 * Sets availability to the given value
	 * @param a availability of the item
	 */
	public void setAvailability(boolean a) {
		available = a;
	}
	
	/**
	 * @return the Title of the item
	 */
	public String getTitle() {
		return title;
	}
	
	/***
	 * @return the Author/Publisher of the item
	 */
	public String getAuthor() {
		return author;
	}
	
}
