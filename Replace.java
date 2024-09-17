
package simplenotepad;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class Replace extends EventChooser{
	
	public Replace(JTextPane pane) {
		super(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String s = (String)JOptionPane.showInputDialog(null);
		textPane.replaceSelection(s);
	}
	
}
