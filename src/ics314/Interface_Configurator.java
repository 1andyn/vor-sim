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
		Image comp_image = new Image(disp,"rsrc/compass.png");
		images.add(comp_image);
		Image obs_image = new Image(disp,"rsrc/obs.png");
		images.add(obs_image);
		Image plane_image = new Image(disp, "rsrc/plane.png");
		images.add(plane_image);
		Image arw_left = new Image(disp, "rsrc/left.png");
		images.add(arw_left);
		Image arw_cent = new Image(disp, "rsrc/center.png");
		images.add(arw_cent);
		Image arw_right = new Image(disp, "rsrc/right.png");
		images.add(arw_right);
		Image arw_top = new Image(disp, "rsrc/obs_ptr.png");
		images.add(arw_top);
		Image from = new Image(disp, "rsrc/from.png");
		images.add(from);
		Image to = new Image(disp, "rsrc/to.png");
		images.add(to);
	}
}
