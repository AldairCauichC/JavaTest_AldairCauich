package CatMouseGame;

public class CatClass {

	//Attribute
		int [][] cat = new int[5][5];
		
		//method
		public boolean CatchMouse(int x, int y){
			if(this.cat[x-1][y-1] == 1){
				return true;
			}else{
			return false;
			}
			
		}
		public void fullCat(int i, int j, int value){
			this.cat[i][j]=value;
		}
}
