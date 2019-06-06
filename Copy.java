
package simplenotepad;

import java.awt.event.ActionEvent;
import javax.swing.JTextPane;


public class Copy extends EventChooser{

	public Copy(JTextPane pane) {
		super(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		textPane.copy();
	}
}
