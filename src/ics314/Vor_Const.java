package ics314;

public interface Vor_Const {
	
	//Image Resource Constants
	static final int I_OBS = 0;
	static final int I_PTR = 1;
	static final int I_FROM = 2;
	static final int I_TO = 3;
	static final int I_BAD = 4;
	static final int I_GOOD = 5;
	static final int I_DOT = 6;
	static final int I_ICON = 7;
	static final int I_NDLE = 8;
	
	//Inversion
	static final int INVERT = -1;
	
	//Color
	static final int WHITE_R = 255;
	static final int WHITE_G = 255;
	static final int WHITE_B = 255;
	
	
	//GOOD BAD
	static final int BAD = 0;
	static final int GOOD = 1;
	
	//Direction Constants
	static final int FROM = 1;
	static final int TO = 0;
	
	//Angle Rotation Amounts
	static final int PERPENDICULAR = 90;
	static final int HALF_PI = 90;
	static final int PI = 180;
	static final int THREE_FORTH_PI = 270;
	static final int TWO_PI = 360;
	
	//Widget Constants
	static final int OBS_COORD = 0;
	static final int DISP_COLUMN = 1;
	static final int SUB_COL_COUNT = 2;
	static final int ColumnCount = 3;
	static final int FillTwoColumns = 2;
	static final int SingleColumn = 1;
	static final int FillSingleRow = 1;
	static final int MINANGLE = 0;
	static final int MAXANGLE = 359;
	static final int START_COORD = 0;
	static final int START_ANGLE = 0;
	static final int ANGLE_INCR = 1;
	static final int ANGLE_PAGEINCR = 20;
	static final int BG_PIXELS = 367;
	static final int NEEDLE_WIDTH = 4;
	
	//Button consts
	static final String buttonTitle = "New Radio";
	static final int button_X = 132;
	static final int button_Y = 45;
	static final int button_TY = 50;
	
	//Math
	static final float DEGREES_PER_PI = 180;
	
	//Fixed Coordinates
	static final int I_PTR_X = 177;
	static final int I_PTR_Y = 92;
	static final int I_DOT_X = 1;
	static final int I_DOT_Y = 40;
	static final int GB_X = 110;
	static final int GB_Y = 160;
	static final int TF_X = 210;
	static final int TF_Y = 160;
	static final int LABEL_X = 10;
	static final int LABEL_Y = 20;
	static final int SPINNER_X = 160;
	static final int SPINNER_Y = 20;
	
	//Needle Constants
	static final int NDL_X = 0;
	static final int NDL_Y = -65;
	
}
