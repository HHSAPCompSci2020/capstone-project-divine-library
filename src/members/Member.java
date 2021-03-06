package members;
import java.util.ArrayList;

import items.ItemTemplate;

/**
 * Represents a member of the Library. Has a name, library ID, and list of borrowed items.
 * @author James Jian
 * @author Harshith Pothula
 * @author Caden Pun
 * @version 5/24
 */
public class Member {

	private String name, ID;
	private ArrayList<ItemTemplate> borrowed;
	
	public Member() {
		ID = "";
		name = "";
		borrowed = new ArrayList<ItemTemplate>();
	}
	
	/**
	 * Creates a Member with the assigned ID number, and give name
	 * @param ID ID number
	 * @param name Name
	 * @param borrowList List of items the member currently borrowed by the member
	 */
	public Member(String ID, String name, ArrayList<ItemTemplate> borrowList) {
		this.ID = ID;
		this.name = name.replace('_', ' ');
		borrowed = borrowList;
	}
	
	/**
	 * returns String of the Member's name, ID, and items currently borrowed
	 * @return String of the Member's name, ID, and items currently borrowed
	 */
	public String toString() {
		int remainder = 10 - borrowed.size();
		return "Name: " + name  + "\nID: " + ID + "\nItems currently borrowed: " + getList() + "\n# of additional items that can be borrowed: " + remainder;
	}

	/**
	 * returns a String of the items borrowed by the member
	 * @return a String of the items borrowed by the member
	 */
	public String getList() {
		String list = "";
		for (int i = 0; i < borrowed.size(); i++) {
			list += "\n" + borrowed.get(i).getTitle();
		}
		list += "\n";
		return list;
	}
	
	/**
	 * returns the arraylist of the borrowed item
	 * @return the borrowed items in arraylist
	 */
	public ArrayList<ItemTemplate> getArrayList () {
		return borrowed;
	}
	
	/**
	 * change the member's id
	 * @param newID in string
	 */
	public void setID (String newID) {
		ID = newID;
	}
	
	/**
	 * change the member's name
	 * @param newName in string
	 */
	public void setName (String newName) {
		name = newName;
	}
	
	/**
	 * add an item to the member's borrowed list
	 * @param item item wish to add
	 * @return True, when item is added, and false, when item cannot be added
	 */
	public boolean addBorrow (ItemTemplate item) {
		if (borrowed.size() < 10) {
			borrowed.add(item);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 *  remove an item from the member's borrowed list
	 * @param item item returned
	 * @return String stating if you successfully returned an item or did not borrow the item
	 */
	public String returned (ItemTemplate item) {
		if (borrowed.contains(item)) {
			borrowed.remove(item);
			return "successfully returned";
		}else {
			return "you did not borrow this item";
		}
	}
	
	/**
	 * returns the ID of the member
	 * @return the ID of the Member
	 */
	public String getID () {
		return ID;
	}
	
	/**
	 * returns the name of the member
	 * @return the name of the Member
	 */
	public String getName () {
		return name;
	}
	
}
