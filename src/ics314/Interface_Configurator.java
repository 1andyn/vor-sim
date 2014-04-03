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
		Image bg_image = new Image(disp,"rsrc/mapbg.jpg"); //0
		images.add(bg_image);
		Image comp_image = new Image(disp,"rsrc/compass.png"); //1
		images.add(comp_image);
		Image obs_image = new Image(disp,"rsrc/obs.png"); //2
		images.add(obs_image);
		Image plane_image = new Image(disp, "rsrc/plane.png"); //3
		images.add(plane_image);
		Image arw_left = new Image(disp, "rsrc/left.png"); //4
		images.add(arw_left);
		Image arw_cent = new Image(disp, "rsrc/center.png"); //5
		images.add(arw_cent);
		Image arw_right = new Image(disp, "rsrc/right.png"); //6
		images.add(arw_right);
		Image arw_top = new Image(disp, "rsrc/obs_ptr.png"); //7
		images.add(arw_top);
		Image from = new Image(disp, "rsrc/from.png"); //8
		images.add(from);
		Image to = new Image(disp, "rsrc/to.png"); //9
		images.add(to);
		Image cent = new Image(disp, "rsrc/cent.png"); //10
		images.add(cent);
		Image planet_image = new Image(disp, "rsrc/planet.png"); //11
		images.add(planet_image);
		Image obs_line = new Image(disp, "rsrc/obs_line.png"); //12
		images.add(obs_line);
	}
	
	public Image getWEImage(List<Image> images, Radio rad)
	{
        switch(rad.getToFrom()){
        case Interface_Const.CENTER: return images.get(10);
        case Interface_Const.TO: return images.get(9);
        case Interface_Const.FROM: return images.get(8);
        default: return images.get(10);
        }
	}
	
	public Image getTFImage(List<Image> images, Radio rad)
	{
		System.out.println(rad.getWestEast());
        switch(rad.getWestEast()){
        case Interface_Const.CENTER: return images.get(5);
        case Interface_Const.WEST: return images.get(6);
        case Interface_Const.EAST: return images.get(4);
        default: return images.get(5);
        }
	}
	
}
