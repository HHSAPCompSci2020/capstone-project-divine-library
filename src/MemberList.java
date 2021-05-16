import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the list of all the Members. Contains all the Members of the library.
 * @author James Jian
 *
 */
public class MemberList {
	
	private ArrayList<Member> members;

	public MemberList() {
		members = new ArrayList<Member> ();
	}
	
	public MemberList(String memberfile) {
		members = new ArrayList<Member> ();
		this.readData(memberfile,  members);
	}
	
	/**
	 * add a member to the member list
	 * @param member
	 */
	public void addMember (Member member) {
		members.add(member);
	}
	
	/**
	 * remove a member from the member list
	 * @param index
	 */
	public void removeMember (int index) {
		members.remove(index);
	}
	
	/**
	 * 
	 * @param ID
	 * @param name
	 * @param newID
	 */
	public void changeMemberID (String ID, String name, String newID) {
		int index = 0;
		for (Member m : members) {
			if (m.getID() == ID) {
				if (name == m.getName()) {
					Member change = members.get(index);
					change.setID(newID);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param ID
	 * @param oldName
	 * @param newName
	 */
	public void changeMemberName (String ID, String oldName, String newName) {
		int index = 0;
		for (Member m : members) {
			if (m.getID() == ID) {
				if (oldName == m.getName()) {
					Member change = members.get(index);
					change.setName(newName);
				}
			}
		}
	}
	
	/**
	 * Adds a borrowed item to a member
	 * @param ID
	 * @param oldName
	 * @param item
	 * @return A string stating that a member has reached the borrowing limit if they have 10 borrowed items, a String of the items borrowed by the member, an error message is returned if something is wrong
	 */
	public String addBorrowedItem (String ID, String oldName, ItemTemplate item) {
		int index = 0;
		for (Member m : members) {
			if (m.getID() == ID) {
				if (oldName == m.getName()) {
					Member change = members.get(index);
					if (change.getArrayList().size() == 10) {
						return "sorry, but you have reached the borrowed limit";
					}
					change.addBorrow(item);
					return change.getList();
				}
			}
		}
		return "error";
	}
	
	/**
	 * Returns an item
	 * @param ID
	 * @param oldName
	 * @param item
	 * @return A string stating that a member did not borrow that item, a String of the items borrowed by the member, an error message is returned if something is wrong
	 */
	public String returned (String ID, String oldName, ItemTemplate item) {
		int index = 0;
		for (Member m : members) {
			if (m.getID() == ID) {
				if (oldName == m.getName()) {
					Member change = members.get(index);
					if (change.getArrayList().size() > 0 || !change.getArrayList().contains(item)) {
						return "you did not borrow this item.";  
					}
					change.returned(item);
					return change.getList();
				}
			}
		}
		return "error";
	}
	
	public ArrayList<Member> getMemberList(){
		return members;
	}
	
	public Member IDMatch(String id) {
		for (int x = 0; x < members.size(); x++) {
			if (members.get(x).getID().equals(id)) {
				return members.get(x);
			}
		}
		return null;
	}
	
	private  void readData (String filename, ArrayList<Member> members) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					
					while (in.hasNext()) {
						String line = in.nextLine();
						String name = line.substring(0, line.indexOf(" "));
						String id = line.substring(line.indexOf(" ") + 1);
						members.add(new Member(id, name, new ArrayList<ItemTemplate>()));
						count++;
					}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
}
