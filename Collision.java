
public class Collision {

	private static int ycoord, xcoord;
	private static boolean keyTaken;
	
	public static void setY(int y) {		
		ycoord=y;
	}
	
	public static int getY() {		
		return ycoord;
	}
	
	public static void setX(int x) {		
		xcoord=x;
	}
	
	public static int getX() {		
		return xcoord;
	}
	
	public static void setTaken(boolean taken) {		
		keyTaken = taken;
	}
	
	public static boolean getTaken() {		
		return keyTaken;
	}
	
	
	
	public static int[][] moveXY(int[][] map, int pX, int pY,int xst, int yst){
		if(yst != 0){
			switch(map[pY+yst][pX]){
				case 0:
					pY = pY+(yst);
					break;
				case 1:
					break;
				case 2:
					map[pY+(yst)][pX]=0;
					pY = pY+(yst);
					break;
				case 3:
					map[pY][pX]=0;
					setTaken(true);
					pY = pY+(yst);
					break;
				case 4:
					if(map[pY+(yst*2)][pX]==0){
						map[pY+(yst)][pX]=0;
						map[pY+(yst*2)][pX]=4;
						pY = pY+(yst);
					}
					break;
			}
		}
		if(xst != 0){
			switch(map[pY][pX+xst]){
				case 0:
					pX = pX+xst;
					break;
				case 1:
					break;
				case 2:
					map[pY][pX+(xst)]=0;
					pX = pX+(xst);
					break;
				case 3:
					map[pY][pX]=0;
					pX = pX+(xst);
					setTaken(true);
					break;
				case 4:
					if(map[pY][pX+(xst*2)]==0){
						map[pY][pX+(xst)]=0;
						map[pY][pX+(xst*2)]=4;
						pX = pX+(xst);
					}
					break;
			}
		}
		setX(pX);
		setY(pY);
		return map;
	}
	
	public static int[][] moveX(int[][] map, int pX, int pY, int xst){
		if(xst != 0){
			switch(map[pY][pX+xst]){
				case 0:
					pX = pX+xst;
					break;
				case 1:
					break;
				case 2:			
					break;
				case 3:
					break;
				case 4:
					if(map[pY][pX+(xst*2)]==0){
						map[pY][pX+(xst)]=0;
						map[pY][pX+(xst*2)]=4;
						pX = pX+(xst);
					}
					break;
			}
		}
		setX(pX);
		return map;
	}
	
	
}
