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
						int id = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
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
