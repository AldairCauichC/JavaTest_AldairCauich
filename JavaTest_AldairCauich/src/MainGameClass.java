
import javax.swing.JOptionPane;
public class MainGameClass {
	
	public static void main(String args[]){
		
		int tryGame = 0; 
		while(tryGame == 0){
			String[] options = {"Toss Coin", "Cat & Mouse", "Slot Machine"};
			int game = JOptionPane.showOptionDialog(null, "What Game you want to Play?", "Games", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			switch(game){
			////////////////////Toss Coin Game
			case 0:
				int decision = JOptionPane.showConfirmDialog(null, "You want to toss the coin?", "Toss Coin Game", JOptionPane.YES_NO_OPTION);
				switch(decision){
				case 0:
					int tryAgain = 0;
					while(tryAgain == 0){
						TossGameClass coin = new TossGameClass();
						for (int i=1 ; i<=10; i++){
							coin.TossCoin();
							//System.out.println("Total of Heads: "+coin.getHeads());
							//System.out.println("Total of Tails: "+coin.getTails());
							//System.out.println("Total of Toss Done: "+coin.getTossDone());
							JOptionPane.showMessageDialog(null, "Total of Heads: "+coin.getHeads()+"\nTotal of Tails: "+coin.getTails()+"\nTotal of Toss Done: "+coin.getTossDone(), "Toss Coin Game", JOptionPane.DEFAULT_OPTION, null);
						}
						tryAgain = JOptionPane.showConfirmDialog(null, "You want to toss the coin again?", "Toss Coin Game", JOptionPane.YES_NO_OPTION);	
					}
					break;
				case 1:
					//JOptionPane.showMessageDialog(null, "Thank you for playing, Come Back Soon", "Toss Coin Game", JOptionPane.DEFAULT_OPTION, null);
					break;
				default:
					System.out.println("Incorrect Option");
					break;
				}
				
				JOptionPane.showMessageDialog(null, "Thank you for playing Toss Coin, Come Back Soon", "Toss Coin Game", JOptionPane.DEFAULT_OPTION, null);

				break;
				/////////////////////////Cat & Mouse Game
			case 1:
				JOptionPane.showMessageDialog(null, "Welcome to Cat & Mouse Game", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
				int option = JOptionPane.showConfirmDialog(null, "You want to play?", "Cat & Mouse Game", JOptionPane.YES_NO_OPTION);
				
				switch(option){
				
				case 0:
					
					int tryTimes = 5;
					int tryAgain = 0;
					int win = 0;
					int lose = 0;
					
					//Start the game
					while(tryAgain == 0){
						
						//Object Cat and Mouse Created
						MouseClass mouse = new MouseClass();
						CatClass cat = new CatClass();
						for (int i=0; i<5; i++){
							for(int j=0 ; j<5 ; j++){
								cat.fullCat(i, j, mouse.getArray(i, j));
							}
						}
						//Enter coordinates to find the mouse
						JOptionPane.showMessageDialog(null, "You have to find the cat by entering Coordinates between 1-5, Example: 2,2", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
						
						do{
							String coIn = JOptionPane.showInputDialog("Enter the coordinate to find the Mouse: ");
							String[] co = coIn.split(",");
							int x = Integer.parseInt(co[0]);
							int y = Integer.parseInt(co[1]);
							if(cat.CatchMouse(x, y)){
								JOptionPane.showMessageDialog(null, "You Find the Mouse, You Win!!!", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
								win++;
								break;
							}else{
								JOptionPane.showMessageDialog(null, "Mouse is not there!!!", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
							}
							tryTimes--;
							if(tryTimes == 0){
								JOptionPane.showMessageDialog(null, "Out of Chances, You Lose!!!", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
								JOptionPane.showMessageDialog(null, "The Mouse coordinate was ("+mouse.MousePositionX()+","+mouse.MousePositionY()+")", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
								lose++;
							}
						}while(tryTimes > 0);
						tryTimes=5;
						JOptionPane.showMessageDialog(null, "win: "+win+" Lose: "+lose, "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
						//Ask if you want to try again
						tryAgain = JOptionPane.showConfirmDialog(null, "You want to play again?", "Cat & Mouse Game", JOptionPane.YES_NO_OPTION);
					}
					break;
				case 1:
					//When you select not to play.
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid Option", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
					break;
				}
				JOptionPane.showMessageDialog(null, "Thank you for playin Cat & Mouse, Come Back Soon!!!", "Cat & Mouse Game", JOptionPane.DEFAULT_OPTION, null);
				break;
				//////////////////////////// Slot Game
			case 2:
				JOptionPane.showMessageDialog(null, "Welcome to Slot Machine", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
				int option1 = JOptionPane.showConfirmDialog(null, "You want to play?", "Slot Machine Game", JOptionPane.YES_NO_OPTION);
				
				switch(option1){
				
				case 0:
					//Create objects and variables 
					SlotMachineClass coin = new SlotMachineClass();
					int tryAgain= 0;
					while(tryAgain == 0){
						
						String numstring = JOptionPane.showInputDialog("Enter number of coins, 1 coin = 1 Try. ");
						int numcoin = Integer.parseInt(numstring);
						for(int i = 0 ; i<numcoin ; i++){
							//Displays the Start board 
							coin.newGame();
							JOptionPane.showMessageDialog(null, "Start with:\n    "
									+coin.getValue(0,0)+" "+coin.getValue(0,1)+" "+coin.getValue(0,2)+"\n"+
									"->["+coin.getValue(1,0)+" "+coin.getValue(1,1)+" "+coin.getValue(1,2)+"]<-\n"
									+"    "+coin.getValue(2,0)+" "+coin.getValue(2,1)+" "+coin.getValue(2,2)
									, "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
						
							String [][] board = coin.getArray();
							coin.playGame(board);
							//Displays the End board
							JOptionPane.showMessageDialog(null, "End with:\n    "
									+coin.getValue(0,0)+" "+coin.getValue(0,1)+" "+coin.getValue(0,2)+"\n"+
									"->["+coin.getValue(1,0)+" "+coin.getValue(1,1)+" "+coin.getValue(1,2)+"]<-\n"
									+"    "+coin.getValue(2,0)+" "+coin.getValue(2,1)+" "+coin.getValue(2,2)
									, "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
						if(coin.verifyWon(coin.getArray())){
							JOptionPane.showMessageDialog(null, "Win Lottery!!!", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
							break;
						}else{
							JOptionPane.showMessageDialog(null, "You Lose\n Tries Left: "+(numcoin-(i+1)), "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
							
						}
						
						}
						
						tryAgain = JOptionPane.showConfirmDialog(null, "You want to play again?", "Slot Machine Game", JOptionPane.YES_NO_OPTION);
					}
						break;
				case 1:
					//When you select not to play
					break;
				default: 
					JOptionPane.showMessageDialog(null, "Invalid", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);

					break;
				}
				JOptionPane.showMessageDialog(null, "Thank you for playing Slot Machine, Come Back Soon", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}
			
			tryGame = JOptionPane.showConfirmDialog(null, "You want to play another game?", "Games", JOptionPane.YES_NO_OPTION);
		
		}
		JOptionPane.showMessageDialog(null, "Thank you for playing, Come Back Soon", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
		
	}

}
