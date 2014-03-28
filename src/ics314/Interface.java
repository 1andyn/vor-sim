package ics314;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
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
		final Display Disp = new Display();
		final Shell Disp_Shell = new Shell(Disp,SWT.SHELL_TRIM & ~ SWT.RESIZE);
		Disp_Shell.setText("VOR Simulator");
		GridLayout Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Interface_Const.ColumnCount;
		Disp_Shell.setLayout(Disp_Layout);
		GridData G_Data = new GridData(GridData.FILL, GridData.CENTER, true, false);
		Interface_Configurator icfg = new Interface_Configurator();
		
		final Radio vor_rad = new Radio();
		
		//Resource Setup
		final List<Image> imagelist = new ArrayList<Image>();
		icfg.LoadImages(Disp, imagelist);

		//Column #1 VOR Background
		Group Map_Disp = new Group(Disp_Shell, SWT.NONE);
		Map_Disp.setText("VOR Map");
		Map_Disp.setBackgroundMode(SWT.INHERIT_FORCE);
		Map_Disp.setLayout(new FillLayout());
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.widthHint = Interface_Const.BG_PIXELS;
		G_Data.heightHint = Interface_Const.BG_PIXELS + 5;
		Map_Disp.setLayoutData(G_Data);
		
		
		final Image plane = imagelist.get(11);
		final Rectangle plane_box = plane.getBounds();
		final Image background = imagelist.get(0);
		
		final Canvas canvas = new Canvas(Map_Disp,SWT.NO_REDRAW_RESIZE);
	    canvas.addPaintListener(new PaintListener() {
	        public void paintControl(PaintEvent e) {
		        e.gc.drawImage(background, 0, 0);
		        
		        int x = vor_rad.getXCoord();
		        int y = vor_rad.getYCoord();
		        Transform transform = new Transform(Disp);
		        transform.translate(x + plane_box.width/2, y + plane_box.height/2);
		        transform.rotate(-vor_rad.getPlaneAngle());
		        transform.translate(-(x + plane_box.width/2), -(y + plane_box.height/2));
		        e.gc.setTransform(transform);
		        e.gc.drawImage(plane, vor_rad.getXCoord(),vor_rad.getYCoord());
		        transform.dispose();

	        }
	    });
	    canvas.pack();
		
		//Secondary displays
		Group Onboard_Disp = new Group(Disp_Shell, SWT.NONE);
		Onboard_Disp.setText("Onboard Display");
		FillLayout sec_layout = new FillLayout();
		sec_layout.type = SWT.VERTICAL;
		Onboard_Disp.setLayout(sec_layout);
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.widthHint = Interface_Const.BG_PIXELS/2 + 5;
		G_Data.heightHint = Interface_Const.BG_PIXELS + 5;
		Onboard_Disp.setLayoutData(G_Data);
			
		final Image compass = imagelist.get(1);
		final Rectangle rect = compass.getBounds();
		final Image obs = imagelist.get(2);
		final Image cmp_plane = imagelist.get(3);
		final Image obs_ptr = imagelist.get(7);
		final Image CENT_TF = imagelist.get(10);
		final Image CENT_WE = imagelist.get(5);
		final Canvas cmp_cvs = new Canvas(Onboard_Disp, SWT.NO_REDRAW_RESIZE);
		cmp_cvs.setLocation(0,0);

		cmp_cvs.addPaintListener(new PaintListener() {
		      public void paintControl(PaintEvent e) {

		        Transform transform = new Transform(Disp);
		        transform.translate(rect.width/2, rect.height/2);
		        transform.rotate(vor_rad.getPlaneAngle());
		        transform.translate(-rect.width/2, -rect.height/2);
		        e.gc.setTransform(transform);
		        e.gc.drawImage(compass, 0,0);
		        transform.dispose();
		        
		        transform = new Transform(Disp);
		        transform.translate(0 + rect.width/2, (205 + rect.height/2));
		        transform.rotate(vor_rad.getOBSAngle());
		        transform.translate(-rect.width/2, -(205+rect.height/2));
		        e.gc.setTransform(transform);
		        e.gc.drawImage(obs, 0,205);
		        transform.dispose();
		     
		        e.gc.setTransform(null);
		        e.gc.drawImage(cmp_plane,85,80);
		        e.gc.drawImage(obs_ptr, 93, 238);
		        e.gc.drawImage(CENT_TF,115,300);
		        e.gc.drawImage(CENT_WE, 38, 320);
		        
		      }
		    });

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
		        int value = (int) (selection / Math.pow(10, digits));
		        vor_rad.setXCoord(value + Interface_Const.p_cx);
		        System.out.println("PlaneX is " + value);
		        canvas.redraw();
		      }
		    });
		
		PlaneY.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = PlaneY.getSelection();
		        int digits = PlaneY.getDigits();
		        int value = (int) (selection / Math.pow(10, digits));
		        vor_rad.setYCoord(value*Interface_Const.INVERT + 
		        		Interface_Const.p_cy);
		        System.out.println("PlaneY is " + value);
		        canvas.redraw();
		      }
		    });
		
		PlaneAngle.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = PlaneAngle.getSelection();
		        int digits = PlaneAngle.getDigits();
		        int value = (int) (selection / Math.pow(10, digits));
		        System.out.println("Plane Angle is " + value);
		        vor_rad.setPlaneAngle(value);
		        cmp_cvs.redraw();
		        canvas.redraw();
		      }
		    });
		
		OBSAngle.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = OBSAngle.getSelection();
		        int digits = OBSAngle.getDigits();
		        int value = (int) (selection / Math.pow(10, digits));
		        System.out.println("OBS Angle is " + value);
		        vor_rad.setOBSAngle(value);
		        cmp_cvs.redraw();
		        canvas.redraw();
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
