import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a shelf in a Library. Contains Books, DVDs, Magazines. Checks if one of these items has been borrowed or not.
 * @author James Jian, Harshith Pothula, Caden Pun
 *
 */
public class Shelf {
	
	private ArrayList<ItemTemplate> books, dvds, magazines;
	
	public Shelf() {
		books = new ArrayList<ItemTemplate>();
		dvds = new ArrayList<ItemTemplate>();
		magazines = new ArrayList<ItemTemplate>();
	}
	
	public Shelf(String bookfile, String dvdfile, String magazinefile) {
		books = new ArrayList<ItemTemplate>();
		dvds = new ArrayList<ItemTemplate>();
		magazines = new ArrayList<ItemTemplate>();		
		this.readData(bookfile, books, 1);
		this.readData(dvdfile, dvds, 2);
		this.readData(magazinefile, magazines, 3);
	}
	
	
	private void readData (String filename, ArrayList<ItemTemplate> items, int type) {
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
						String title = line.substring(0, line.indexOf(" "));
						line = line.substring(line.indexOf(" ") + 1);
						String author = line.substring(0, line.indexOf(" "));
						String misc = line.substring(line.indexOf(" ") + 1);
						if (type == 1) {
							books.add(new Book(title, author, misc));
						}
						else if (type == 2) {
							dvds.add(new DVD(title, author, misc));

						}
						else if (type == 3) {
							magazines.add(new Magazine(title, author, misc));

						}
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
	
	/**
	 * Returns an ArrayList containing books
	 */
	public ArrayList<ItemTemplate> getBookShelf(){
		return books;
	}
	
	/**
	 * Returns an ArrayList containing DVDs
	 */
	public ArrayList<ItemTemplate> getDVDShelf(){
		return dvds;
	}
	
	/**
	 * Returns an ArrayList containing Magazines and Newspapers
	 * @return
	 */
	public ArrayList<ItemTemplate> getMagazineShelf(){
		return magazines;
	}
}


