package ics314;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
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
	
	public static void main(String[] args) {
		
		//Initial Display Interface Variables
		Display Disp = new Display();
		Shell Disp_Shell = new Shell(Disp);
		Composite Parent = new Composite(Disp_Shell, SWT.NONE);
		GridLayout Disp_Layout = new GridLayout(
				Interface_Const.ColumnCount, false);
		Interface_Configurator icfg = new Interface_Configurator();
		
		//Set Layout to Use
		Disp_Shell.setLayout(Disp_Layout);
		
		//Image Setup
		List<Image> imagelist = new ArrayList<Image>();
		icfg.LoadImages(Disp, imagelist);
		
		//Column #1 Vor Background
		Label MapLabel = new Label (Disp_Shell, SWT.BORDER);
		MapLabel.setText("Simulator Map");

		Label background = new Label(Parent,SWT.NONE);
		background.setImage(imagelist.get(0));
		
		//Label Creations for User Interactables
		Label PlaneCoordLabelX = new Label(Disp_Shell, SWT.BORDER);
		PlaneCoordLabelX.setText("Plane Coordinates X: ");	
	    Spinner PlaneX = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneX);
	    
		Label PlaneCoordLabelY = new Label(Disp_Shell, SWT.BORDER);
		PlaneCoordLabelY.setText("Plane Coordinates Y: ");
	    Spinner PlaneY = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneY);
		
		Label PlaneAngleLabel = new Label(Disp_Shell, SWT.BORDER);
		PlaneAngleLabel.setText("Plane Angle (Degrees): ");
	    Spinner PlaneAngle = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerAngleConfig(PlaneAngle);	
		
		Label OBSLabel = new Label(Disp_Shell, SWT.BORDER);
		OBSLabel.setText("OBS Knob Angle (Degrees): ");
		Spinner OBSAngle = new Spinner(Disp_Shell, SWT.READ_ONLY);
		icfg.SpinnerAngleConfig(OBSAngle);
	
		Disp_Shell.setLayout(new FillLayout());
		//Disp_Shell.pack();
		Disp_Shell.open();
		
		while(!Disp_Shell.isDisposed()) {
			if(!Disp.readAndDispatch()) {
				Disp.sleep();
			}
		}
		Disp.dispose();
	}
	
}
