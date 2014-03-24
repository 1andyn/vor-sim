package ics314;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
		Shell Disp_Shell = new Shell(Disp,SWT.SHELL_TRIM & ~ SWT.RESIZE);
		Disp_Shell.setText("VOR Simulator");
		GridLayout Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Interface_Const.ColumnCount;
		Disp_Shell.setLayout(Disp_Layout);
		GridData G_Data = new GridData(GridData.FILL, GridData.CENTER, true, false);
		Interface_Configurator icfg = new Interface_Configurator();
		
		//Resource Setup
		List<Image> imagelist = new ArrayList<Image>();
		icfg.LoadImages(Disp, imagelist);

		//Column #1 VOR Background
		G_Data.widthHint = Interface_Const.BG_PIXELS;
		G_Data.heightHint = Interface_Const.BG_PIXELS;
		Label background = new Label(Disp_Shell,SWT.BORDER);
		background.setImage(imagelist.get(0));
		background.setData(G_Data);
		
		Group Onboard_Disp = new Group(Disp_Shell, SWT.NONE);
		Onboard_Disp.setText("Onboard Display");
		Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Interface_Const.DISP_COLUMN;
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.widthHint = Interface_Const.BG_PIXELS/2;
		G_Data.heightHint = Interface_Const.BG_PIXELS + 20;
		G_Data.horizontalSpan = Interface_Const.SingleColumn;
		Onboard_Disp.setLayoutData(G_Data);
		
		
		Label compass = new Label(Onboard_Disp,SWT.CENTER);
		compass.setImage(imagelist.get(1));
		compass.setLocation(Interface_Const.onboard_x, Interface_Const.cmp_y);
		compass.pack();

		Label obs = new Label(Onboard_Disp,SWT.CENTER);
		obs.setImage(imagelist.get(2));
		obs.setLocation(Interface_Const.onboard_x, Interface_Const.obs_y);
		obs.pack();

		//Column #2 Tools
		Group Simulator_Inputs = new Group(Disp_Shell, SWT.NONE);
		Simulator_Inputs.setText("Simulator Inputs");
		Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Interface_Const.SUB_COL_COUNT;
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.horizontalSpan = Interface_Const.SUB_COL_COUNT;
		Simulator_Inputs.setLayoutData(G_Data);
		
		/* X Coord Setup*/
		Label PlaneCoordLabelX = new Label(Simulator_Inputs, SWT.SINGLE | SWT.BORDER);
		PlaneCoordLabelX.setText("Plane Coordinates X: ");	
		PlaneCoordLabelX.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		//Label Creations for User Interactables

		/*
	    Spinner PlaneX = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneX);*/
	    
		Label PlaneCoordLabelY = new Label(Simulator_Inputs, SWT.SINGLE | SWT.BORDER);
		PlaneCoordLabelY.setText("Plane Coordinates Y: ");
		PlaneCoordLabelY.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		/*
		Spinner PlaneY = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneY);*/
	    
		Label PlaneAngleLabel = new Label(Simulator_Inputs, SWT.SINGLE | SWT.BORDER);
		PlaneAngleLabel.setText("Plane Angle (Degrees): ");
		PlaneAngleLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
	
		/*
	    Spinner PlaneAngle = new Spinner(Disp_Shell, SWT.READ_ONLY);
	    icfg.SpinnerAngleConfig(PlaneAngle);*/	
		
		Label OBSLabel = new Label(Simulator_Inputs, SWT.SINGLE | SWT.BORDER);
		OBSLabel.setText("OBS Knob Angle (Degrees): ");
		OBSLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));

		
		/*
		Spinner OBSAngle = new Spinner(Disp_Shell, SWT.READ_ONLY);
		icfg.SpinnerAngleConfig(OBSAngle);*/

	
		Disp_Shell.pack();
		Disp_Shell.open();
		
		while(!Disp_Shell.isDisposed()) {
			if(!Disp.readAndDispatch()) {
				Disp.sleep();
			}
		}
		Disp.dispose();
	}
	
	private static void InitializeCompass(Shell shell, List<Image> img){
		Composite row = new Composite (shell, SWT.NONE);
		row.setLayout(new GridLayout(Interface_Const.SUB_COL_COUNT,true));
		row.setLayoutData(new GridData(GridData.FILL,SWT.BEGINNING, true, false));
		
		/* Compass Display */
		Label compass = new Label(shell,SWT.BORDER);
		compass.setImage(img.get(1));
		compass.setLayoutData(new GridData(GridData.FILL, SWT.BEGINNING, true, false));
		
		/* X Coord Setup*/
		Label PlaneCoordLabelX = new Label(shell, SWT.BORDER);
		PlaneCoordLabelX.setText("Plane Coordinates X: ");	
		PlaneCoordLabelX.setLayoutData(new GridData(GridData.FILL, SWT.BEGINNING, true, false));
	}
	
	private static void InitializeOBS(Shell shell){
		
	}
	
	
}
