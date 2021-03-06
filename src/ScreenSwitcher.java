
/**
 * Interface which allows switching between screens
 * @author Harshith Pothula
 * @version 5/24
 *
 */
public interface ScreenSwitcher {
	public static final int SCREEN1 = 0;
	public static final int SCREEN2 = 1;
	public static final int SCREEN3 = 2;
	public static final int SCREEN4 = 3;
	
	public void switchScreen(int i);
}
