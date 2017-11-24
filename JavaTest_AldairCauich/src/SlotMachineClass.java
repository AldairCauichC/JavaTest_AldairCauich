
public class SlotMachineClass {
	//attributes
	private  String [][] slot = new String[3][3];
	
	//constructor
	public SlotMachineClass(){
		for(int i=0; i<3 ; i++){
			for(int j=0 ; j<3 ; j++){
				this.slot[i][j] = "0" ;
			}
		} 
	}
	
	//methods
	
	public void newGame(){
		//String [][] BaseArray = new String[3][3];
		String [][]baseArray = {{"$","1","A"},{"$","1","A"},{"$","1","A"}};
		
		for(int i=0; i<3 ; i++){
			for(int j=0 ; j<3 ; j++){
				int fv = ((int)Math.floor(Math.random()*3));
				int sv = ((int)Math.floor(Math.random()*3));
				this.slot[i][j] = baseArray[fv][sv] ;
			}
		}
	}
	
	public void playGame(String[][] array){
		
		for(int i=0; i<3 ; i++){
			for(int j=0 ; j<3 ; j++){
				int fv = ((int)Math.floor(Math.random()*3));
				int sv = ((int)Math.floor(Math.random()*3));
				this.slot[i][j] = array[fv][sv] ;
			}
		}
	}
	
	public boolean verifyWon(String[][] board){
		if (board[1][0] == board[1][1] && board[1][0] == board[1][2]){
			return true;
		}else{
			return false;
		}
	}
	
	public String[][] getArray(){
		return this.slot;
	}
	public String getValue(int x, int y){
		return this.slot[x][y];
	}
	
	
	
}
