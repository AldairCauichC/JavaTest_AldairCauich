
import javax.swing.JOptionPane;
public class MainSlotMachine {

	
	public static void main(String args[]){
		
		JOptionPane.showMessageDialog(null, "Welcome to Slot Machine", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
		int option = JOptionPane.showConfirmDialog(null, "You want to play?", "Slot Machine Game", JOptionPane.YES_NO_OPTION);
		
		switch(option){
		
		case 0:
			//Create objects and variables 
			SlotMachineClass coin = new SlotMachineClass();
			int tryAgain= 0;
			while(tryAgain == 0){
				//Displays the Start board 
				coin.newGame();
				System.out.println("Start with: ");
				System.out.println(coin.getValue(0,0)+" "+coin.getValue(0,1)+" "+coin.getValue(0,2));
				System.out.println(coin.getValue(1,0)+" "+coin.getValue(1,1)+" "+coin.getValue(1,2));
				System.out.println(coin.getValue(2,0)+" "+coin.getValue(2,1)+" "+coin.getValue(2,2));
				
				String [][] board = coin.getArray();
				coin.playGame(board);
				//Displays the End board
				System.out.println("End with: ");
				System.out.println(coin.getValue(0,0)+" "+coin.getValue(0,1)+" "+coin.getValue(0,2));
				System.out.println(coin.getValue(1,0)+" "+coin.getValue(1,1)+" "+coin.getValue(1,2));
				System.out.println(coin.getValue(2,0)+" "+coin.getValue(2,1)+" "+coin.getValue(2,2));
				if(coin.verifyWon(coin.getArray())){
					JOptionPane.showMessageDialog(null, "Win Lottery!!!", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
				}else{
					JOptionPane.showMessageDialog(null, "You Lose", "Slot Machine Game", JOptionPane.DEFAULT_OPTION, null);
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
	}
	
}
