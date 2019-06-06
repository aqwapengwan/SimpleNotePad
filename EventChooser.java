
package simplenotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;

//abstract class for all events with ActionListener
public abstract class EventChooser implements ActionListener{
	public JTextPane textPane;
	
	public EventChooser(JTextPane pane){
		textPane = pane;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
	}
}
