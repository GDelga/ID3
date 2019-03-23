package presentacion;

import javax.swing.JFrame;

/**
 * @author Guillermo Delgado Yepes
 */
public abstract class GUIMain extends JFrame implements GUI{

	private static GUIMain instance;
	
	public static GUIMain getInstance() {
		if(instance == null) {
			instance = new GUIMainImp();
		}
		return instance;
	}

}
