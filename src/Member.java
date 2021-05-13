import java.util.ArrayList;

/**
 * Represents a member of the Library. Has a name and library ID. You can see the # of items that can be borrowed (List).
 * @author James Jian
 *
 */
public class Member {

	private int ID;
	private String name;
	private ArrayList<ItemTemplate> borrowed;
	
	public Member() {
		ID = -1;
		name = "";
		borrowed = new ArrayList<ItemTemplate>();
	}
	
	/**
	 * Creates a Member with the assigned ID number, and give name
	 * @param ID ID number
	 * @param name Name
	 * @param borrowList List of items the member currently borrowed by the member
	 */
	public Member(int ID, String name, ArrayList<ItemTemplate> borrowList) {
		this.ID = ID;
		this.name = name.replace('_', ' ');
		borrowed = borrowList;
	}
	
	public String toString() {
		return "Name: " + name  + "\nID: " + ID + "\nItems currently borrowed: " + getlist();
	}

	/**
	 * Returns a String of the items borrowed by the member
	 */
	public String getlist() {
		String list = "";
		for (int i = 0; i < borrowed.size(); i++) {
			list += borrowed.get(i) + ", ";
		}
		return list;
	}
	
}
