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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class Interface {
	
	public static void main(String[] args) 
	{
		final Interface_Configurator icfg = new Interface_Configurator();
		final Calculation calc = new Calculation();
		final Radio vor_rad = new Radio();		
		
		//Initial Display Interface Variables
		final Display Disp = new Display();
		final Shell Disp_Shell = new Shell(Disp,SWT.SHELL_TRIM & ~ SWT.RESIZE);
		Disp_Shell.setText("VOR Simulator");

		//Resource Setup (For Images)
		final List<Image> imagelist = new ArrayList<Image>();
		icfg.LoadImages(Disp, imagelist);
		Disp_Shell.setImage(imagelist.get(Vor_Const.I_ICON));
		
		GridLayout Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Vor_Const.ColumnCount;
		Disp_Shell.setLayout(Disp_Layout);
		GridData G_Data = new GridData(GridData.FILL, GridData.CENTER, true, false);

		//Primary Display (OBS CODE)
		Group Onboard_Disp = new Group(Disp_Shell, SWT.NONE);
		Onboard_Disp.setText("Onboard Display");
		FillLayout sec_layout = new FillLayout();
		sec_layout.type = SWT.VERTICAL;
		Onboard_Disp.setLayout(sec_layout);
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.widthHint = Vor_Const.BG_PIXELS;
		G_Data.heightHint = Vor_Const.BG_PIXELS;
		Onboard_Disp.setLayoutData(G_Data);
		
		final Image obs = imagelist.get(Vor_Const.I_OBS);
		final Image needle = imagelist.get(Vor_Const.I_NDLE);
		final Rectangle rect = obs.getBounds();
		final Rectangle n_rect = needle.getBounds();
		
		final Canvas cmp_cvs = new Canvas(Onboard_Disp, SWT.NO_REDRAW_RESIZE |
				SWT.DOUBLE_BUFFERED);
		cmp_cvs.setLocation(Vor_Const.OBS_COORD,Vor_Const.OBS_COORD);

		cmp_cvs.addPaintListener(new PaintListener() {
		      public void paintControl(PaintEvent e) {
		    	  
		        Transform transform = icfg.getTransform(Disp, vor_rad, rect);
		        e.gc.setTransform(transform);
		        e.gc.drawImage(obs, Vor_Const.OBS_COORD,
		        		Vor_Const.OBS_COORD);
		        transform.dispose();
		        e.gc.setTransform(null);		      	        		      
		       
		        /* Static Draws */
		       icfg.drawStaticResources(e, imagelist);
		       
		       int z = calc.calculateBad(vor_rad);
		       /* Draw GoodBad */
		       e.gc.drawImage(icfg.getGBImage(imagelist, z),
		    		   Vor_Const.GB_X, Vor_Const.GB_Y);
		       
		       int x = calc.calculateToFrom(vor_rad);
		       /* Draw ToFrom */
		       e.gc.drawImage(icfg.getTFImage(imagelist, x),
		    		   Vor_Const.TF_X, Vor_Const.TF_Y);
		       
		       int y = calc.calculateDeflection(vor_rad);
		       
		       /* Draw Needle */
		       transform = icfg.getTransform(Disp, y, n_rect);
		       e.gc.setTransform(transform);
		       e.gc.drawImage(needle, Vor_Const.NDL_X, Vor_Const.NDL_Y);
		       
		      }
		    });

		//Column #2 Tools
		Group Simulator_Inputs = new Group(Disp_Shell, SWT.NONE);
		Simulator_Inputs.setText("Simulator Inputs");
		Disp_Layout = new GridLayout();
		Disp_Layout.numColumns = Vor_Const.SUB_COL_COUNT;
		G_Data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		G_Data.horizontalSpan = Vor_Const.SUB_COL_COUNT;
		G_Data.heightHint = 60;
		Simulator_Inputs.setLayoutData(G_Data);		
	    
		Label OBSLabel = new Label(Simulator_Inputs, SWT.SINGLE);
		OBSLabel.setText("OBS Knob Angle (Degrees): ");
		OBSLabel.pack();
		OBSLabel.setLocation(Vor_Const.LABEL_X,Vor_Const.LABEL_Y);
		
		final Label radioText = new Label(Simulator_Inputs, SWT.SINGLE);
		radioText.setText("Radio Angle:  " + vor_rad.getRadioAngle());
		radioText.pack();
		radioText.setLocation(Vor_Const.LABEL_X,Vor_Const.button_TY);

		final Spinner OBSAngle = new Spinner(Simulator_Inputs, SWT.WRAP);
		icfg.SpinnerAngleConfig(OBSAngle);
		OBSAngle.pack();
		OBSAngle.setLocation(Vor_Const.SPINNER_X, Vor_Const.SPINNER_Y);
		
		final Button radioButton = new Button(Simulator_Inputs, SWT.PUSH);
		radioButton.setText(Vor_Const.buttonTitle);
		radioButton.setLocation(Vor_Const.button_X, Vor_Const.button_Y);
		radioButton.pack();

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
		
		radioButton.addSelectionListener(new SelectionAdapter() {
			@Override
		    public void widgetSelected(SelectionEvent e) {
		        vor_rad.generateRandomRadio();
		        vor_rad.generateRandomGoodBad();
		        radioText.setText("Radio Angle:  " + vor_rad.getRadioAngle());
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
