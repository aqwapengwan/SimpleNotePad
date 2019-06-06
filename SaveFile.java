
package simplenotepad;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class SaveFile extends EventChooser{

	public SaveFile(JTextPane pane) {
		super(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		File fileToWrite = null;
      JFileChooser fc = new JFileChooser();
      int returnVal = fc.showSaveDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION)
         fileToWrite = fc.getSelectedFile();
      try {
         PrintWriter out = new PrintWriter(new FileWriter(fileToWrite));
         out.println(textPane.getText());
         JOptionPane.showMessageDialog(null, "File is saved successfully...");
         out.close();
      } catch (IOException ex) {
		}
	}
}
