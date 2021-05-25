package libraryObjects;
import members.MemberList;

/**
 * This represents a Library. It has a MemberList and Shelves.
 * @author James Jian
 * @version 5/24
 *
 */
public class Library {
	private MemberList list;
	private Shelf shelf;
	
	/**
	 * Creates a Library with the given books, dvds, magazines, and members from txt files
	 * @param bookfile text file containing list of books
	 * @param dvdfile text file containing list of DVDs
	 * @param magazinefile text file containing list of magazines & newspapers
	 * @param memberfile text file containing list of members
	 */
	public Library (String bookfile, String dvdfile, String magazinefile, String memberfile) {
		shelf = new Shelf(bookfile, dvdfile, magazinefile);
		list = new MemberList(memberfile);
	}
	
	/**
	 * Returns the shelves
	 * @return the shelves
	 */
	public Shelf getShelves() {
		return shelf;
	}
	
	/**
	 * Returns the member list
	 * @return the list of members
	 */
	public MemberList getMemberList() {
		return list;
	}
}
