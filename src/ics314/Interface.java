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
	
	public static void main(String[] args) 
	{
		
		//Initial Display Interface Variables
		final Display Disp = new Display();
		final Shell Disp_Shell = new Shell(Disp,SWT.SHELL_TRIM & ~ SWT.RESIZE);
		Disp_Shell.setText("VOR Simulator");
		GridLayout Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Interface_Const.ColumnCount;
		Disp_Shell.setLayout(Disp_Layout);
		GridData G_Data = new GridData(GridData.FILL, GridData.CENTER, true, false);
		final Interface_Configurator icfg = new Interface_Configurator();
		
		final Radio vor_rad = new Radio();
		
		//Resource Setup
		final List<Image> imagelist = new ArrayList<Image>();
		icfg.LoadImages(Disp, imagelist);
		
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
		
		final Canvas cmp_cvs = new Canvas(Onboard_Disp, SWT.NO_REDRAW_RESIZE |
				SWT.DOUBLE_BUFFERED);
		cmp_cvs.setLocation(0,0);

		cmp_cvs.addPaintListener(new PaintListener() {
		      public void paintControl(PaintEvent e) {

		    	vor_rad.updateDisplays();
		    	  
		        Transform transform = new Transform(Disp);		      
		        transform = new Transform(Disp);
		        transform.translate(0 + rect.width/2, (205 + rect.height/2));
		        transform.rotate(-vor_rad.getOBSAngle());
		        transform.translate(-rect.width/2, -(205+rect.height/2));
		        e.gc.setTransform(transform);
		        e.gc.drawImage(obs, 0,205);
		        transform.dispose();
		     
		        e.gc.setTransform(null);		      
		        e.gc.drawImage(icfg.getTFImage(imagelist, vor_rad),38, 320);
		        
		        
		        /* Static Draws */
		        e.gc.drawImage(obs_ptr, 93, 238);
        
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
		
		OBSAngle.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        int selection = OBSAngle.getSelection();
		        int digits = OBSAngle.getDigits();
		        int value = (int) (selection / Math.pow(10, digits));
		        //System.out.println("OBS Angle is " + value);
		        vor_rad.setOBSAngle(value);
		        cmp_cvs.redraw();
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
