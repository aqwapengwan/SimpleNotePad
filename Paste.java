
package simplenotepad;

import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.text.Position;
import javax.swing.text.StyledDocument;


public class Paste extends EventChooser{

	public Paste(JTextPane pane) {
		super(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		StyledDocument doc = textPane.getStyledDocument();
            Position position = doc.getEndPosition();
            System.out.println("offset"+position.getOffset());
            textPane.paste();
	}
}
