package ics314;

import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Spinner;

public class Interface_Configurator {
	
	public void SpinnerCoordConfig (Spinner input_spin){
		input_spin.setMinimum(Interface_Const.MINCOORD);
	    input_spin.setMaximum(Interface_Const.MAXCOORD);
	    input_spin.setSelection(Interface_Const.START_COORD);
	    input_spin.setIncrement(Interface_Const.COORD_INCREMENT);
	    input_spin.setPageIncrement(Interface_Const.COORD_PAGE_INCREMENT);
	}
	
	public void SpinnerAngleConfig (Spinner input_spin){
		input_spin.setMinimum(Interface_Const.MINANGLE);
		input_spin.setMaximum(Interface_Const.MAXANGLE);
		input_spin.setSelection(Interface_Const.START_ANGLE);
		input_spin.setIncrement(Interface_Const.ANGLE_INCR);
		input_spin.setPageIncrement(Interface_Const.ANGLE_PAGEINCR);	
	}
	
	public void LoadImages(Display disp,List<Image> images){
		Image bg_image = new Image(disp,"rsrc/mapbg.jpg");
		images.add(bg_image);
		Image comp_image = new Image(disp,"rsrc/cmpas.jpg");
		images.add(comp_image);
		Image obs_image = new Image(disp,"rsrc/obs.jpg");
		images.add(obs_image);
	}
}
