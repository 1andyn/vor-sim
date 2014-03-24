package ics314;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
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
		Disp_Shell.setText("VOR Simulator");
		GridLayout Disp_Layout = new GridLayout(
				Interface_Const.ColumnCount, false);
		GridData G_Data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		Interface_Configurator icfg = new Interface_Configurator();
		
		//Set Layout to Use
		Disp_Shell.setLayout(Disp_Layout);
		//Image Setup
		List<Image> imagelist = new ArrayList<Image>();
		icfg.LoadImages(Disp, imagelist);
		
		//Column #1 Vor Background
		Label background = new Label(Disp_Shell,SWT.BORDER);
		background.setImage(imagelist.get(0));
		background.setData(G_Data);
		
		//Label Creations for User Interactables
		G_Data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		Label PlaneCoordLabelX = new Label(Disp_Shell, SWT.BORDER);
		PlaneCoordLabelX.setText("Plane Coordinates X: ");	
		PlaneCoordLabelX.setData(G_Data);
	    Spinner PlaneX = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneX);
	    PlaneX.setData(G_Data);
	    
		Label PlaneCoordLabelY = new Label(Disp_Shell, SWT.BORDER);
		PlaneCoordLabelY.setData(G_Data);
		PlaneCoordLabelY.setText("Plane Coordinates Y: ");
	    Spinner PlaneY = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneY);
		PlaneY.setData(G_Data);
	    
		Label PlaneAngleLabel = new Label(Disp_Shell, SWT.BORDER);
		PlaneAngleLabel.setText("Plane Angle (Degrees): ");
		PlaneAngleLabel.setData(G_Data);
	    Spinner PlaneAngle = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerAngleConfig(PlaneAngle);	
	    PlaneAngle.setData(G_Data);
		
		Label OBSLabel = new Label(Disp_Shell, SWT.BORDER);
		OBSLabel.setText("OBS Knob Angle (Degrees): ");
		OBSLabel.setData(G_Data);
		Spinner OBSAngle = new Spinner(Disp_Shell, SWT.READ_ONLY);
		icfg.SpinnerAngleConfig(OBSAngle);
		OBSAngle.setData(G_Data);
	
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
