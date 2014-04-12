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
	
	public static void main(String[] args) 
	{
		
		//Initial Display Interface Variables
		final Display Disp = new Display();
		final Shell Disp_Shell = new Shell(Disp,SWT.SHELL_TRIM & ~ SWT.RESIZE);
		Disp_Shell.setText("VOR Simulator");
		GridLayout Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Iface_Const.ColumnCount;
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
		G_Data.widthHint = Iface_Const.BG_PIXELS;
		G_Data.heightHint = Iface_Const.BG_PIXELS;
		Onboard_Disp.setLayoutData(G_Data);
			
		final Image obs = imagelist.get(0);
		final Rectangle rect = obs.getBounds();
		final Image obs_ptr = imagelist.get(1);
		
		final Canvas cmp_cvs = new Canvas(Onboard_Disp, SWT.NO_REDRAW_RESIZE |
				SWT.DOUBLE_BUFFERED);
		cmp_cvs.setLocation(0,0);

		cmp_cvs.addPaintListener(new PaintListener() {
		      public void paintControl(PaintEvent e) {
		    	  
		        Transform transform = new Transform(Disp);		      
		        transform = new Transform(Disp);
		        transform.translate(0 + rect.width/2, 
		        		(Iface_Const.OBS_Y_OFFSET + rect.height/2));
		        transform.rotate(-vor_rad.getOBSAngle());
		        transform.translate(-rect.width/2, -
		        		(Iface_Const.OBS_Y_OFFSET +rect.height/2));
		        e.gc.setTransform(transform);
		        e.gc.drawImage(obs, 0,Iface_Const.OBS_Y_OFFSET);
		        transform.dispose();
		     
		        e.gc.setTransform(null);		      	        
		        
		        /* Static Draws */
		        e.gc.drawImage(obs_ptr, 93, 238);
        
		      }
		    });

		//Column #2 Tools
		Group Simulator_Inputs = new Group(Disp_Shell, SWT.NONE);
		Simulator_Inputs.setText("Simulator Inputs");
		Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Iface_Const.SUB_COL_COUNT;
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.horizontalSpan = Iface_Const.SUB_COL_COUNT;
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
