
public class TossGameClass {
	//Attributes
		private int heads;
		private int tails;
		private int tossDone;
		
		//constructor
		public TossGameClass(){
			this.heads = 0;
			this.tails = 0;
			this.tossDone = 0;
		}
		//methods
		public int getHeads(){
			return this.heads;
		}
		
		public int getTails(){
			return this.tails;
		}
		
		public int getTossDone(){
			return this.tossDone;
		}
		
		
		public void TossCoin(){
			int eleccion=((int)Math.floor(Math.random()*2+1));
			 
	        if (eleccion == 1){
	            this.heads= this.heads + 1;
	        }else{
	            this.tails= this.tails + 1;
	        }
	        
	        this.tossDone = this.tossDone + 1;
		}
}
