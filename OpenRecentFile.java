
package simplenotepad;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JTextPane;


public class OpenRecentFile extends EventChooser{
	String path;
	public OpenRecentFile(JTextPane pane, String fileName) {
		super(pane);
		path = fileName;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		try{
         FileReader reader = new FileReader(path);
         BufferedReader br = new BufferedReader(reader);
         textPane.read(br,null);
         br.close();
         textPane.requestFocus();
      }catch(Exception e1){
      }
	}
}
