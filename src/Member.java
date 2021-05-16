import java.util.ArrayList;

/**
 * Represents a member of the Library. Has a name, library ID, and list of borrowed items.
 * @author James Jian
 * @author Harshith Pothula
 * @author Caden Pun
 *
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
	
	public String toString() {
		return "Name: " + name  + "\nID: " + ID + "\nItems currently borrowed: " + getList();
	}

	/**
	 * @return a String of the items borrowed by the member
	 */
	public String getList() {
		String list = "";
		for (int i = 0; i < borrowed.size(); i++) {
			list += borrowed.get(i).getTitle() + ", ";
		}
		return list;
	}
	
	/**
	 * @return the borrowed items
	 */
	public ArrayList<ItemTemplate> getArrayList () {
		return borrowed;
	}
	
	/**
	 * change the member's id
	 * @param newID
	 */
	public void setID (String newID) {
		ID = newID;
	}
	
	/**
	 * change the member's name
	 * @param newName
	 */
	public void setName (String newName) {
		name = newName;
	}
	
	/**
	 * add an item to the member's borrowed list
	 * @param item
	 */
	public void addBorrow (ItemTemplate item) {
		borrowed.add(item);
	}
	/**
	 * remove an item from the member's borrowed list
	 * @param item
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
	 * gives the ID of the member
	 * @return
	 */
	public String getID () {
		return ID;
	}
	
	/**
	 * gives the name of the member
	 * @return 
	 */
	public String getName () {
		return name;
	}
	
}
