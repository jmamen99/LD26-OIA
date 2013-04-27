package nl.jerreav.OIA;

public class Goal {
	int[] minima;
	int[] maxima;
	int minimumBlocks;
	boolean isReached = false;
	
	Goal(int[] _min, int[] _max, int _minB){
		minima = _min;
		maxima = _max;
		minimumBlocks = _minB;
	}
	
	public boolean checkGoal(int[] stats){
		for(int i = 0; i < stats.length; i++){
			if(stats[i] <= maxima[i] && stats[i] >= minima[i]){
				isReached = true;
			}
			else{
				isReached = false;
				break;
			}
		}
		
		return isReached;
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}

}
