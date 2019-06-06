
package simplenotepad;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class OpenFile extends EventChooser{
	
	public OpenFile(JTextPane pane) {
		super(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		final JFileChooser fileChooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("txt","TXT");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION){
         File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			SimpleNotePad.recentFiles.add(0,path);
			
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
}
