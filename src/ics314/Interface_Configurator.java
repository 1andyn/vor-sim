package ics314;

import java.util.ArrayList;
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
		Image needle = new Image(disp,"rsrc/needle.png"); //8
		images.add(needle);
		Image cent = new Image(disp,"rsrc/cent.png"); //9
		images.add(cent);
	}
	
	//Function for creating the morse code alphabet
	public void SetAlpha(ArrayList<String> alpha)
	{
		alpha.add(Vor_Const.M_A);
		alpha.add(Vor_Const.M_B);
		alpha.add(Vor_Const.M_C);
		alpha.add(Vor_Const.M_D);
		alpha.add(Vor_Const.M_E);
		alpha.add(Vor_Const.M_F);
		alpha.add(Vor_Const.M_G);
		alpha.add(Vor_Const.M_H);
		alpha.add(Vor_Const.M_I);
		alpha.add(Vor_Const.M_J);
		alpha.add(Vor_Const.M_K);
		alpha.add(Vor_Const.M_L);
		alpha.add(Vor_Const.M_M);
		alpha.add(Vor_Const.M_N);
		alpha.add(Vor_Const.M_O);
		alpha.add(Vor_Const.M_P);
		alpha.add(Vor_Const.M_Q);
		alpha.add(Vor_Const.M_R);
		alpha.add(Vor_Const.M_S);
		alpha.add(Vor_Const.M_T);
		alpha.add(Vor_Const.M_U);
		alpha.add(Vor_Const.M_V);
		alpha.add(Vor_Const.M_W);
		alpha.add(Vor_Const.M_X);
		alpha.add(Vor_Const.M_Y);
		alpha.add(Vor_Const.M_Z);
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
	
	public Transform getTransform(Display disp, int deflection, 
			Rectangle rect)
	{	/* Rotating by Negative angle turns needle to RIGHT */
		/* Rotating by Postive angle turns needle to LEFT */
		
		//int angle = deflection % Vor_Const.PI;
		int new_deflection = deflection;
		if(deflection > Vor_Const.PI) {
			new_deflection = -(Vor_Const.TWO_PI - deflection);
		} else if (deflection < -Vor_Const.PI) {
			new_deflection = (Vor_Const.TWO_PI + deflection);
		}
		
		new_deflection = new_deflection % Vor_Const.PI;
		if(new_deflection > Vor_Const.PI - Vor_Const.DEFLECTION_OFFSET) {
			new_deflection = Vor_Const.PI - new_deflection;
		} else if (new_deflection < (-Vor_Const.PI) + Vor_Const.DEFLECTION_OFFSET) {
			new_deflection = -(Vor_Const.PI + new_deflection);
		}
		
		float needle_angle;
		int angle = new_deflection;

		if(Math.abs(angle) > Vor_Const.DEF_MAX) {
			if(angle > 0) {
				needle_angle = Vor_Const.DEF_MAX_ANGLE;
			} else {
				needle_angle = -Vor_Const.DEF_MAX_ANGLE;
			}
		} else {
			needle_angle = angle * Vor_Const.ROTATE_OFFSET;
		}
		
		Transform transform = new Transform(disp);		      
        transform = new Transform(disp);
        transform.translate(Vor_Const.OBS_COORD + rect.width/2, 
        		(Vor_Const.NDL_Y + rect.height/2));
        transform.rotate(needle_angle);
        transform.translate(-rect.width/2, -
        		(Vor_Const.NDL_Y +rect.height/2));
        return transform;
	}
	
	public void drawStaticResources(PaintEvent e, List<Image> images)
	{
		Image red_pointer = images.get(Vor_Const.I_PTR);
		Image vor_dots = images.get(Vor_Const.I_DOT);
		e.gc.drawImage(red_pointer, Vor_Const.I_PTR_X, Vor_Const.I_PTR_Y);
		e.gc.drawImage(vor_dots, Vor_Const.I_DOT_X, Vor_Const.I_DOT_Y);		
	}
	
	public Image getGBImage(List<Image> images, int input)
	{
        switch(input) {
        case Vor_Const.BAD: return images.get(Vor_Const.I_BAD);
        case Vor_Const.GOOD: return images.get(Vor_Const.I_GOOD);
        default: return images.get(Vor_Const.I_GOOD);
        }
	}
	
	public Image getTFImage(List<Image> images, int tofrom)
	{
        switch(tofrom){
        case Vor_Const.TO: return images.get(Vor_Const.I_TO);
        case Vor_Const.FROM: return images.get(Vor_Const.I_FROM);
        default: return images.get(Vor_Const.I_CENT);
        }
	}
	
}
