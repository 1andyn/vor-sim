package ics314;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Interface {
	public static void main(String[] args) {
		Display iface_Disp = new Display();
		Shell iface_Shell = new Shell(iface_Disp);
		
		iface_Shell.setLayout(new FillLayout());
		iface_Shell.open();
		
		while(!iface_Shell.isDisposed()) {
			if(!iface_Disp.readAndDispatch()) {
				iface_Disp.sleep();
			}
		}
		iface_Disp.dispose();
	}
}
