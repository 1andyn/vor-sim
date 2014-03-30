package ics314;

public interface Interface_Const {
	
	//Inversion
	static final int INVERT = -1;
	
	//Direction Constants
	static final int FROM = 1;
	static final int TO = -1;
	static final int CENTER = 0;
	static final int WEST = -1;
	static final int EAST = 1;
	
	//Widget Constants
	static final int DISP_COLUMN = 1;
	static final int SUB_COL_COUNT = 2;
	static final int ColumnCount = 3;
	static final int FillTwoColumns = 2;
	static final int SingleColumn = 1;
	static final int FillSingleRow = 1;
	static final int MAXCOORD = 180;
	static final int MINCOORD = -180;
	static final int MINANGLE = 0;
	static final int MAXANGLE = 360;
	static final int START_COORD = 0;
	static final int COORD_INCREMENT = 5;
	static final int COORD_PAGE_INCREMENT = 10;
	static final int START_ANGLE = 0;
	static final int ANGLE_INCR = 1;
	static final int ANGLE_PAGEINCR = 20;
	static final int BG_PIXELS = 400;
	
	//Math
	static final float DEGREES_PER_PI = 180;
	
	//Fixed Coordinates
	static final int onboard_x = 3;
	static final int obs_y = 220;
	static final int cmp_y = 18;

	static final int cmpp_x = 88;
	static final int cmpp_y = 100;
	
	static final int p_cx = 185; //CENTER X COORDINATE FOR PLANE
	static final int p_cy = 192;//CENTER Y COORDINATE FOR PLANE
	
	static final int LINE_X_CENTER = 0;
	static final int LINE_Y_CENTER = 8;
	
	//Angle Offsets
	static final int HORIZONTAL_OFFSET = 135;
	static final int VERTICAL_OFFSET = 45;
}
