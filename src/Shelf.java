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
	
	private ItemTemplate[][] books, dvds, magazines;
	
	public Shelf() {
		books = new ItemTemplate[5][5];
		dvds = new ItemTemplate[5][5];
		magazines = new ItemTemplate[5][5];
	}
	
	public Shelf(String bookfile, String dvdfile, String magazinefile) {
		//right now preset to 5,5 might change later
		books = new ItemTemplate[5][5];
		dvds = new ItemTemplate[5][5];
		magazines = new ItemTemplate[5][5];
		this.readData(bookfile, books);
		this.readData(dvdfile, dvds);
		this.readData(magazinefile, magazines);
	}
	
	
	public void readData (String filename, ItemTemplate[][] items) {
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
						for(int i = 0; i < line.length(); i++)
							if (count < items.length && i < items[count].length)
								items[i][count] = line.charAt(i);

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


