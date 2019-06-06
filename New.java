
package simplenotepad;

import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class New extends EventChooser{

	public New(JTextPane pane) {
		super(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		textPane.setText("");
	}
}
