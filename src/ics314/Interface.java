package ics314;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
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
		final List<Image> imagelist = new ArrayList<Image>();
		icfg.LoadImages(Disp, imagelist);

		//Column #1 VOR Background
		Group Map_Disp = new Group(Disp_Shell, SWT.NONE);
		Map_Disp.setText("VOR Map");
		Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = 1;
		Map_Disp.setBackgroundImage(imagelist.get(0));
		Map_Disp.setBackgroundMode(SWT.INHERIT_FORCE);
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.widthHint = Interface_Const.BG_PIXELS;
		G_Data.heightHint = Interface_Const.BG_PIXELS;
		Map_Disp.setLayoutData(G_Data);
		
		
		final Label plane = new Label(Map_Disp, SWT.NO_BACKGROUND & SWT.TRANSPARENT);
		plane.setImage(imagelist.get(11));
		plane.pack();
		plane.setLocation(Interface_Const.p_cx,Interface_Const.p_cy);
		
		 Canvas canvas = new Canvas(Map_Disp,SWT.NO_REDRAW_RESIZE);
	    canvas.addPaintListener(new PaintListener() {
	        public void paintControl(PaintEvent e) {
	         e.gc.drawImage(imagelist.get(3),0,0);
	        }
	    });
		
		//Secondary displays
		
		Group Onboard_Disp = new Group(Disp_Shell, SWT.NONE);
		Onboard_Disp.setText("Onboard Display");
		Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Interface_Const.DISP_COLUMN;
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.widthHint = Interface_Const.BG_PIXELS/2;
		G_Data.heightHint = Interface_Const.BG_PIXELS + 5;
		G_Data.horizontalSpan = Interface_Const.SingleColumn;
		Onboard_Disp.setLayoutData(G_Data);
		
		final Label comp_plane = new Label(Onboard_Disp,SWT.CENTER);
		comp_plane.setImage(imagelist.get(3));
		comp_plane.pack();
		comp_plane.setLocation(Interface_Const.cmpp_x,Interface_Const.cmpp_y);
		
		final Label obs_ptr = new Label(Onboard_Disp,SWT.CENTER);
		obs_ptr.setImage(imagelist.get(7));
		obs_ptr.pack();
		obs_ptr.setLocation(95, 255);
		
		final Label dir_ptr = new Label(Onboard_Disp,SWT.CENTER);
		dir_ptr.setImage(imagelist.get(10)); //10 for Blank (Center, 9 for TO, 8 for FROM
		dir_ptr.pack();
		dir_ptr.setLocation(115, 295);
		
		final Label dir_ptr2 = new Label(Onboard_Disp,SWT.CENTER);
		dir_ptr2.setImage(imagelist.get(5)); //5 for Blank Center, 4 for left, 6 for right
		dir_ptr2.pack();
		dir_ptr2.setLocation(40, 320);

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
		G_Data.heightHint = 60;
		Simulator_Inputs.setLayoutData(G_Data);
		
		/* X Coord Setup*/
		Label PlaneCoordLabelX = new Label(Simulator_Inputs, SWT.SINGLE);
		PlaneCoordLabelX.setText("Plane Coordinates X: ");	
		PlaneCoordLabelX.pack();
		PlaneCoordLabelX.setLocation(40, 25);
		//Label Creations for User Interactables

	    final Spinner PlaneX = new Spinner(Simulator_Inputs, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneX);
	    PlaneX.pack();
	    PlaneX.setLocation(170, 23);
	    
		Label PlaneCoordLabelY = new Label(Simulator_Inputs, 
				SWT.SINGLE & SWT.BORDER);
		PlaneCoordLabelY.setText("Plane Coordinates Y: ");
		PlaneCoordLabelY.pack();
		PlaneCoordLabelY.setLocation(40, 51);
		
		final Spinner PlaneY = new Spinner(Simulator_Inputs, SWT.READ_ONLY);
	    icfg.SpinnerCoordConfig(PlaneY);
	    PlaneY.pack();
	    PlaneY.setLocation(170, 50);
	    
		Label PlaneAngleLabel = new Label(Simulator_Inputs, SWT.SINGLE);
		PlaneAngleLabel.setText("Plane Angle (Degrees): ");
		PlaneAngleLabel.pack();
		PlaneAngleLabel.setLocation(330,25);
	
	    final Spinner PlaneAngle = new Spinner(Simulator_Inputs, SWT.READ_ONLY);
	    icfg.SpinnerAngleConfig(PlaneAngle);
		PlaneAngle.pack();
		PlaneAngle.setLocation(510,23);
	    
		Label OBSLabel = new Label(Simulator_Inputs, SWT.SINGLE);
		OBSLabel.setText("OBS Knob Angle (Degrees): ");
		OBSLabel.pack();
		OBSLabel.setLocation(330,51);

		final Spinner OBSAngle = new Spinner(Simulator_Inputs, SWT.READ_ONLY);
		icfg.SpinnerAngleConfig(OBSAngle);
		OBSAngle.pack();
		OBSAngle.setLocation(510,50);

		Disp_Shell.pack();
		Disp_Shell.open();
		
		PlaneX.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = PlaneX.getSelection();
		        int digits = PlaneX.getDigits();
		        System.out.println("PlaneX is " + (selection / Math.pow(10, digits)));
		      }
		    });
		
		PlaneY.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = PlaneY.getSelection();
		        int digits = PlaneY.getDigits();
		        System.out.println("PlaneY is " + (selection / Math.pow(10, digits)));
		      }
		    });
		
		PlaneAngle.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = PlaneAngle.getSelection();
		        int digits = PlaneAngle.getDigits();
		        System.out.println("Plane Angle is " + (selection / Math.pow(10, digits)));
		      }
		    });
		
		OBSAngle.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = OBSAngle.getSelection();
		        int digits = OBSAngle.getDigits();
		        System.out.println("OBS Angle is " + (selection / Math.pow(10, digits)));
		      }
		    });
		
		
		while(!Disp_Shell.isDisposed()) {
			if(!Disp.readAndDispatch()) {
				Disp.sleep();
			}
		}
		Disp.dispose();
	}
	
}
