package items;

import members.Member;

/**
 * This is a template for books, magazines, and DVDs. includes basic information of an item such as title, author, whether if it has been borrowed or not
 * @author James Jian
 * @author Caden Pun
 * @author Harshith Pothula
 * @version 5/24
 */
public class ItemTemplate {

	private String title, author;
	private boolean available, waitlisted;
	private Member borrower, waitlister;
	
	/**
	 * Sets an empty title, author, and is not available
	 */
	public ItemTemplate() {
		title = "";
		author = "";
		available = false;
		waitlisted = false;
		borrower = new Member();
		waitlister = new Member();
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
		waitlisted = false;
		borrower = new Member();
		waitlister = new Member();
	}
	
	/**
	 * Returns the availability of the item in string
	 * @return a statement: Yes or No
	 */
	public String getAvailability() {
		if (available)
			return "Yes";
		else 
			return "No, borrowed by: ID#" + borrower.getID();
	}
	
	/**
	 * Returns the availability of the item in boolean 
	 * @return true or false based on availability
	 */
	public boolean getStatus() {
		return available;
	}
	
	/**
	 * Returns if the item is waitlisted
	 * @return true or false based on waitlist status
	 */
	public boolean isWaitlisted() {
		return waitlisted;
	}
	
	/**
	 * Sets availability to the given value
	 * @param a false if item is being borrowed, true if item is being returned
	 * @param b Member borrowing/returning the item
	 */
	public void setAvailability(boolean a, Member b) {
		available = a;
		borrower = b;
	}
	
	/**
	 * Sets waitlist status to the given value
	 * @param a boolean waitlist status of the item, 
	 * @param b a member object
	 */
	public void setWaitlister(boolean a, Member b) {
		waitlisted = a;
		waitlister = b;
	}
	
	/**
	 * returns the title of the book
	 * @return the Title of the item
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * returns the author/publisher of the item
	 * @return the Author/Publisher of the item
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * get the waitlister's id
	 * @return waitlister's id
	 */
	public String getWaitlisterID() {
		return waitlister.getID();
	}
	
	/**
	 * get the borrower's id
	 * @return borrower's id
	 */
	public String getBorrower() {
		return borrower.getID();
	}
	
	/**
	 * returns the waitlist status in string
	 * @return string waitlist status statement
	 */
	public String getWaitlistStatus() {
		return "Title: " + getTitle() + 
				   "\nAuthor: " + getAuthor() + 
				   "\nWaitlisted by: ID#" + getWaitlisterID();
	}
	
}
