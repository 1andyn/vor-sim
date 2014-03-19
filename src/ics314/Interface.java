package ics314;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class Interface {
	
	/*
	 * First column will be dedicated to MAP Display
	 * Second column will be dedicated to onboard VOR and Compass Display
	 * Third and fourt will be dedicated to Buttons, Texts, Interactbles 
	 */
	private static int ColumnCount = 4;
	private static int FillTwoColumns = 2;
	private static int SingleColumn = 1;
	private static int FillSingleRow = 1;
	private static int MAXCOORD = 300;
	private static int MINCOORD = -300;
	private static int START_COORD = 0;
	private static int COORD_INCREMENT = 1;
	private static int COORD_PAGE_INCREMENT = 20;
	
	public static void main(String[] args) {
		
		//Initial Display Interface Variables
		Display Disp = new Display();
		Shell Disp_Shell = new Shell(Disp);
		GridLayout Disp_Layout = new GridLayout(ColumnCount, false);
		
		//Set Layout to Use
		Disp_Shell.setLayout(Disp_Layout);
		
		
		GridData G_data = new GridData(SWT.FILL, SWT.TOP, true, false, 
				FillTwoColumns, FillSingleRow);
		
		//Label Creations for User Interactables
		
	    Group PlaneGroup = new Group(Disp_Shell, SWT.NONE);
	    PlaneGroup.setText("This is my group");
	    G_data = new GridData(SWT.FILL, SWT.FILL, true, false);
	    G_data.horizontalSpan = FillTwoColumns;
	    PlaneGroup.setLayoutData(G_data);
	    PlaneGroup.setLayout(new RowLayout(SWT.VERTICAL));	
		
		Label PlaneCoordLabelX = new Label(Disp_Shell, SWT.BORDER);
		PlaneCoordLabelX.setText("Plane Coordinates X: ");
				
	    Spinner PlaneX = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    PlaneX.setMinimum(MINCOORD);
	    PlaneX.setMaximum(MAXCOORD);
	    PlaneX.setSelection(START_COORD);
	    PlaneX.setIncrement(COORD_INCREMENT);
	    PlaneX.setPageIncrement(COORD_PAGE_INCREMENT);
	    GridData SpinGDX = new GridData(SWT.FILL, SWT.FILL, true, false);
	    SpinGDX.widthHint = SWT.DEFAULT;
	    SpinGDX.heightHint = SWT.DEFAULT;
	    SpinGDX.horizontalSpan = SingleColumn;
	    PlaneX.setLayoutData(SpinGDX);
	    
		Label PlaneCoordLabelY = new Label(Disp_Shell, SWT.BORDER);
		PlaneCoordLabelY.setText("Plane Coordinates Y: ");
		
	    Spinner PlaneY = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    PlaneY.setMinimum(MINCOORD);
	    PlaneY.setMaximum(MAXCOORD);
	    PlaneY.setSelection(START_COORD);
	    PlaneY.setIncrement(COORD_INCREMENT);
	    PlaneY.setPageIncrement(COORD_PAGE_INCREMENT);
	    GridData SpinGDY = new GridData(SWT.FILL, SWT.FILL, true, false);
	    SpinGDY.widthHint = SWT.DEFAULT;
	    SpinGDY.heightHint = SWT.DEFAULT;
	    SpinGDY.horizontalSpan = SingleColumn;
	    PlaneY.setLayoutData(SpinGDY);
		

		
		Label PlaneAngleLabel = new Label(Disp_Shell, SWT.BORDER);
		PlaneAngleLabel.setText("Plane Angle (Degrees): ");
		Label OBSLabel = new Label(Disp_Shell, SWT.BORDER);
		OBSLabel.setText("OBS Knob Angle (Degrees): ");
		
		Disp_Shell.setLayout(new FillLayout());
		Disp_Shell.pack();
		Disp_Shell.open();
		
		while(!Disp_Shell.isDisposed()) {
			if(!Disp.readAndDispatch()) {
				Disp.sleep();
			}
		}
		Disp.dispose();
	}
}
