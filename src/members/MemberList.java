package members;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import items.ItemTemplate;

/**
 * Represents the list of all the Members. Contains all the Members of the library.
 * @author James Jian
 * @version 5/24
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
	 * @param member Member
	 */
	public void addMember (Member member) {
		members.add(member);
	}
	
	/**
	 * remove a member from the member list
	 * @param index Index of member to be removed
	 */
	public void removeMember (int index) {
		members.remove(index);
	}
	
	/**
	 * verify whether if name and id match, if yes then change id into new ID
	 * @param ID Old ID number
	 * @param name Name
	 * @param newID New ID number
	 */
	public void changeMemberID (String ID, String name, String newID) {
		int index = 0;
		boolean good = true;

		for (Member m : members) {
			if (m.getID() == newID) {
				good = false;
				break;
			}
			if (m.getID() == ID) {
				good = false;
				break;
			}
			if (name == m.getName()) {
				good = false;
				break;
			}
		}
		
		if (good == true) {
			Member change = members.get(index);
			change.setID(newID);
		}
	}
	
	/**
	 * verify whether if name and id match, if yes then change name into new name
	 * @param ID ID number
	 * @param oldName Old Name
	 * @param newName New Name
	 */
	public void changeMemberName (String ID, String oldName, String newName) {
		for (int i = 0; i < members.size(); i++) {
			Member change = members.get(i);
			if (change.getID() == ID) {
				if (oldName == change.getName()) {
					change.setName(newName);
				}
			}
		}
	}
	
	/**
	 * Adds a borrowed item to a member
	 * @param ID ID number
	 * @param oldName Name of member
	 * @param item Item being borrowed
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
	 * Returns an item a member borrowed
	 * @param ID ID number
	 * @param name Name of member
	 * @param item Item being returned
	 * @return A string stating that a member did not borrow that item, a String of the items borrowed by the member, an error message is returned if something is wrong
	 */
	public String returned (String ID, String name, ItemTemplate item) {
		int index = 0;
		for (Member m : members) {
			if (m.getID() == ID) {
				if (name == m.getName()) {
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
	
	/**
	 * returns the member list
	 * @return the Member List in arraylist
	 */
	public ArrayList<Member> getMemberList(){
		return members;
	}
	
	/**
	 * check if this id exists in the member list
	 * @param id ID to be checked in the list
	 * @return The first member in the member list that matches the given ID
	 */
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
