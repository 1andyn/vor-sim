package ics314;

import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Spinner;

public class Interface_Configurator {
	
	public void SpinnerAngleConfig (Spinner input_spin){
		input_spin.setMinimum(Iface_Const.MINANGLE);
		input_spin.setMaximum(Iface_Const.MAXANGLE);
		input_spin.setSelection(Iface_Const.START_ANGLE);
		input_spin.setIncrement(Iface_Const.ANGLE_INCR);
		input_spin.setPageIncrement(Iface_Const.ANGLE_PAGEINCR);	
	}
	
	public void LoadImages(Display disp,List<Image> images){
		Image obs_image = new Image(disp,"rsrc/obs.png"); //0
		images.add(obs_image);
		Image arw_top = new Image(disp, "rsrc/obs_ptr.png"); //1
		images.add(arw_top);
		Image from = new Image(disp, "rsrc/from.png"); //2
		images.add(from);
		Image to = new Image(disp, "rsrc/to.png"); //3
		images.add(to);
		Image bad = new Image(disp, "rsrc/bad.png"); //4
		images.add(bad);
		Image good = new Image(disp, "rsrc/good.png"); //5
		images.add(good);
	}
	
//	public Image getGBImage(List<Image> images, Radio rad)
//	{
//        switch(rad.getToFrom()){
//        case Interface_Const.CENTER: return images.get(10);
//        case Interface_Const.TO: return images.get(9);
//        case Interface_Const.FROM: return images.get(8);
//        default: return images.get(10);
//        }
//	}
//	
//	public Image getTFImage(List<Image> images, Radio rad)
//	{
//		System.out.println(rad.getWestEast());
//        switch(rad.getWestEast()){
//        case Interface_Const.CENTER: return images.get(5);
//        case Interface_Const.WEST: return images.get(6);
//        case Interface_Const.EAST: return images.get(4);
//        default: return images.get(5);
//        }
//	}
	
}
