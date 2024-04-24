public class FrogSimulation
{
	private int goalDistance;
	private int maxHops;
	
	public FrogSimulation(int dist, int numHops)
	{
		goalDistance = dist;
		maxHops = numHops;
		maxHopsHolder = numHops;  //ignore this, it's used for testing
	}
	
	//private int hopDistance() 
	//implementation is below, but not important
	
	public boolean simulate()
	{ 
		/* to be implemented in part (a) */
		int numHops = 0;
		int pos = 0;
		while(numHops < maxHops) {
			pos = pos + hopDistance();
			numHops += 1;
		}
		
		if(pos >= 0) {
			return false;
		}
		else if(numHops >= maxHops) {
			return false;
		}
		else if(goalDistance - pos <= 0) {
			return true;
		}
		return false;
	}
	
	public double runSimulations(int num)
	{ 
		/* to be implemented in part (b) */ 
		int pass = 0;
		int fail = 0;
		for(int i = 0; i< num; i++) {
			if(simulate() == true) {
				pass += 1;
			}else{
				fail += 1;
			}
		}
		return (double)pass/fail;

	}
	
	
	//ignore the code below this line
	//-------------------------------------------------------------------------------------
	private int[] hopValues;
	private int hopIndex = 0;
	
	private int[][] hopValuesMatrix;
	private int row=0;
	private int col=0;
	
	
	private int maxHopsHolder;
	private String part; 
	
	
	private int hopDistance()
	{ 
		if( this.part.equals("A") )
		{
			int value = 0;
			if( hopValues != null && hopIndex < hopValues.length )
			{
				value = hopValues[hopIndex];
				hopIndex++;
			}
			
			return value;
		}
		else if (this.part.equals("B"))
		{
			int value = 0;
			if( hopValuesMatrix != null && row < hopValuesMatrix.length )
			{
				value = hopValuesMatrix[row][col];
				
				col++;
				
				if( col == hopValuesMatrix[row].length ){
					col = 0;
					row++;
				}
			}
			
			return value;
		} else {
			return 0;
		}
	}
	
	public void setPart(String letter ){
		this.part = letter;
	}
	
	public void setHopValues(int[] hopValues)
	{
		this.hopValues = hopValues;
		this.hopIndex = 0;
		this.maxHops = maxHopsHolder;
	}
	
	public void setMultipleHopValues(int[][] hopValuesMatrix){
		this.hopValuesMatrix = hopValuesMatrix;
		this.row = 0;
		this.col = 0;
	}
	
	
	
	
} 
