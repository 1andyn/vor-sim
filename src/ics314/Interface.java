package ics314;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Interface {
		
	
	public static void main(String[] args) {
		Display Disp = new Display();
		Shell Disp_Shell = new Shell(Disp);
		
		Label PlaneCoordLabel = new Label(Disp_Shell, SWT.BORDER);
		PlaneCoordLabel.setText("Plane Coordinates (x,y): ");
		Label PlaneAngleLabel = new Label(Disp_Shell, SWT.BORDER);
		PlaneAngleLabel.setText("Plane Angle (Degrees): ");
		Label OBSLabel = new Label(Disp_Shell, SWT.BORDER);
		OBSLabel.setText("OBS Knob Angle (Degrees): ");
		
		Disp_Shell.setLayout(new FillLayout());
		Disp_Shell.open();
		
		while(!Disp_Shell.isDisposed()) {
			if(!Disp.readAndDispatch()) {
				Disp.sleep();
			}
		}
		Disp.dispose();
	}
}
