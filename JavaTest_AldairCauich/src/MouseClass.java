
public class MouseClass {
	//Attributes
		private int x;
		private int y;
		int[][] mouse = new int[5][5];
		//Constructor
		public MouseClass(){
			this.x = ((int)Math.floor(Math.random()*5));
			this.y = ((int)Math.floor(Math.random()*5));		
			for(int i=0; i<5 ; i++){
				for(int j=0 ; j<5 ; j++){
					this.mouse[i][j] = 0;
				}
			}
			this.mouse[x][y] = 1;
		}
		//Method
		public int MousePositionX(){
			return this.x+1;
		}
		public int MousePositionY(){
			return this.y+1;
		}
		public int getArray(int x, int y){
			return this.mouse[x][y];
		}
		
	
}
