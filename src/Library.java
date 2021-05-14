/**
 * This represents a Library. It has a MemberList and Shelves.
 * @author James Jian
 *
 */
public class Library {
	private MemberList list;
	private Shelf shelf;
	
	public Library () {
		
	}
	
	public Library (String bookfile, String dvdfile, String magazinefile, String memberfile) {
		shelf = new Shelf(bookfile, dvdfile, magazinefile);
		list = new MemberList(memberfile);
	}
	
	/**
	 * @return the shelves
	 */
	public Shelf getShelves() {
		return shelf;
	}
	
	/**
	 * @return the list of members
	 */
	public MemberList getMemberList() {
		return list;
	}
}
