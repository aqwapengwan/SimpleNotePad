
package simplenotepad;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class SimpleNotePad extends JFrame{
	//renamed variables lines 29-38 for increased readability
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
	 JMenu openRecent = new JMenu("Open Recent");
    JTextPane pane = new JTextPane();
    JMenuItem newFile = new JMenuItem("New File");
    JMenuItem saveFile = new JMenuItem("Save File");
    JMenuItem printFile = new JMenuItem("Print File");
	 JMenuItem openFile = new JMenuItem("Open File");
	//delete undo as it is not implemented
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
	 JMenuItem replace = new JMenuItem("Replace");
	 static ArrayList<String> recentFiles = new ArrayList<String>(5);
	 
    public SimpleNotePad() {
        setTitle("A Simple Notepad Tool");
        fileMenu.add(newFile);
        fileMenu.addSeparator();
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(printFile);
		  fileMenu.addSeparator();
		  fileMenu.add(openFile);
		  addRecent();
		  fileMenu.add(openRecent);
        editMenu.add(undo);
        editMenu.add(copy);
        editMenu.add(paste);
		  editMenu.add(replace);
		  //made new class for New, Save, Print, Copy, and Paste to decrease bloat
		  //deleted set action commands because they were no longer used
        newFile.addActionListener(new New(pane));
        saveFile.addActionListener(new SaveFile(pane));
        printFile.addActionListener(new PrintFile(pane));
        copy.addActionListener(new Copy(pane));
        paste.addActionListener(new Paste(pane));
		  openFile.addActionListener(new OpenFile(pane));
		  replace.addActionListener(new Replace(pane));
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);
        add(new JScrollPane(pane));
        setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
	 
    public static void main(String[] args) {
        SimpleNotePad app = new SimpleNotePad();
    }
	 
   //deleted actionListener action in main class as it is now split up into several classes
//also gets rid of long if/else statement like switch
	 
	 public void addRecent(){
		 for(int i = 0; i < 5; i++){
			 if(recentFiles.get(i) != null){
				 String s = recentFiles.get(i);
				 Path p = Paths.get(s);
				 String file = p.getFileName().toString();
				 JMenuItem x = new JMenuItem(file);
				 openRecent.add(x);
				 x.addActionListener(new OpenRecentFile(pane,s));
			 }
		 }
	 }
}
