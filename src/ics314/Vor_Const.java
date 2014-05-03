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
	static final int I_CENT = 9;
	
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
	static final int OFF = -1;
	
	// Math Constants
	static final int PERPENDICULAR = 90;
	static final int HALF_PI = 90;
	static final int PI = 180;
	static final int THREE_FORTH_PI = 270;
	static final int TWO_PI = 360;
	static final float DEGREES_PER_PI = 180;
	
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
	static final int button_X = 133;
	static final int button_Y = 45;
	static final int button_TY = 50;
	
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
	static final int ABEAM_OFFSET = 1;
	
	//Needle Constants
	static final int NDL_X = 0;
	static final int NDL_Y = -65;
	static final int DEF_MAX = 10;
	static final int DEF_MAX_ANGLE = 40;
	static final float ROTATE_OFFSET = 3.5f;
	static final int DEFLECTION_OFFSET = 11;
	
	//Morse Code Constants
	static final String M_A = ".-";
	static final String M_B = "-...";
	static final String M_C = "-.-.";
	static final String M_D = "-..";
	static final String M_E = ".";
	static final String M_F = "..-.";
	static final String M_G = "--.";
	static final String M_H = "....";
	static final String M_I = "..";
	static final String M_J = ".---";
	static final String M_K = "-.-";
	static final String M_L = ".-..";
	static final String M_M = "--";
	static final String M_N = "-.";
	static final String M_O = "---";
	static final String M_P = ".--.";
	static final String M_Q = "--.-";
	static final String M_R = ".-.";
	static final String M_S = "...";
	static final String M_T = "-";
	static final String M_U = "..-";
	static final String M_V = "...-";
	static final String M_W = ".--";
	static final String M_X = "-..-";
	static final String M_Y = "-.--";
	static final String M_Z = "--..";
}
