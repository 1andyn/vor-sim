package ics314;

import java.util.List;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Spinner;

public class Interface_Configurator {
	
	//Function for Configurating Spinner for User Input
	public void SpinnerAngleConfig (Spinner input_spin){
		input_spin.setMinimum(Vor_Const.MINANGLE);
		input_spin.setMaximum(Vor_Const.MAXANGLE);
		input_spin.setSelection(Vor_Const.START_ANGLE);
		input_spin.setIncrement(Vor_Const.ANGLE_INCR);
		input_spin.setPageIncrement(Vor_Const.ANGLE_PAGEINCR);	
	}
	//Function for Loading Resource Images
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
		Image dot = new Image(disp, "rsrc/dots.png"); //6
		images.add(dot);
		Image icon = new Image(disp, "rsrc/shellicon.gif"); //7
		images.add(icon);
	}
	
	//Function for Rotating OBS
	public Transform getTransform(Display disp, Radio vor_rad, 
			Rectangle rect)
	{
		Transform transform = new Transform(disp);		      
        transform = new Transform(disp);
        transform.translate(Vor_Const.OBS_COORD + rect.width/2, 
        		(Vor_Const.OBS_COORD + rect.height/2));
        transform.rotate(-vor_rad.getOBSAngle());
        transform.translate(-rect.width/2, -
        		(Vor_Const.OBS_COORD +rect.height/2));
        return transform;
	}
	
	public void drawStaticResources(PaintEvent e, List<Image> images)
	{
		Image red_pointer = images.get(Vor_Const.I_PTR);
		Image vor_dots = images.get(Vor_Const.I_DOT);
		e.gc.drawImage(red_pointer, Vor_Const.I_PTR_X, Vor_Const.I_PTR_Y);
		e.gc.drawImage(vor_dots, Vor_Const.I_DOT_X, Vor_Const.I_DOT_Y);		
	}
	
	public void drawDeflectionLine(Display disp, PaintEvent e, int deviation)
	{
		Device device = disp.getCurrent();
		Color white = new Color (device, Vor_Const.WHITE_R,
				Vor_Const.WHITE_G,Vor_Const.WHITE_B);
		e.gc.setForeground(white);
		e.gc.setLineWidth(Vor_Const.NEEDLE_WIDTH);
		
		int dev = -5;
		
		int offset = 4;
		
		int Angle = offset*dev;
		double Rad = Math.toRadians(Angle);
		
		int Needle_X, Needle_Y;
		Needle_X = (int) (Vor_Const.NEEDLE_BOTTOM_X * Math.cos(Rad) +
				Vor_Const.NEEDLE_BOTTOM_Y * Math.sin(Rad));
		Needle_Y = (int) (-Vor_Const.NEEDLE_BOTTOM_X * Math.sin(Rad) +
				Vor_Const.NEEDLE_BOTTOM_Y * Math.cos(Rad));
		
		e.gc.drawLine(Vor_Const.NEEDLE_TOP_X, Vor_Const.NEEDLE_TOP_Y, 
				Needle_X, Needle_Y);
	}
	
	public Image getGBImage(List<Image> images, Radio rad)
	{
        switch(rad.getGoodBad()) {
        case Vor_Const.BAD: return images.get(Vor_Const.I_BAD);
        case Vor_Const.GOOD: return images.get(Vor_Const.I_GOOD);
        default: return images.get(Vor_Const.I_GOOD);
        }
	}
	
	public Image getTFImage(List<Image> images, int tofrom)
	{
		System.out.println(tofrom);
        switch(tofrom){
        case Vor_Const.TO: return images.get(Vor_Const.I_TO);
        case Vor_Const.FROM: return images.get(Vor_Const.I_FROM);
        default: return images.get(Vor_Const.I_FROM);
        }
	}
	
}
