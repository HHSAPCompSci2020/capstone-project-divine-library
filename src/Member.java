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
	
	public Member(int ID, String name, ArrayList<ItemTemplate> borrowList) {
		this.ID = ID;
		this.name = name;
		borrowed = new ArrayList<ItemTemplate>();
	}
	
	
}
