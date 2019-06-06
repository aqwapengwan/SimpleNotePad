
package simplenotepad;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class PrintFile extends EventChooser{

	public PrintFile(JTextPane pane) {
		super(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		try{
         PrinterJob pjob = PrinterJob.getPrinterJob();
         pjob.setJobName("Sample Command Pattern");
         pjob.setCopies(1);
         pjob.setPrintable(new Printable() {
            public int print(Graphics pageGraphics, PageFormat pageFormat, int pageNum) {
               if (pageNum>0)
                  return Printable.NO_SUCH_PAGE;
               pageGraphics.drawString(textPane.getText(), 500, 500);
               textPane.paint(pageGraphics);
               return Printable.PAGE_EXISTS;
            }
         });

         if (pjob.printDialog() == false)
            return;
         pjob.print();
         } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(null,"Printer error" + pe, "Printing error",
						  JOptionPane.ERROR_MESSAGE);
         }
	}
}
