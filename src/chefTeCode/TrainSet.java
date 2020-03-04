package chefTeCode;

import java.util.HashMap;

class Train {
	int value;
	int count;
	
	Train(int value, int count){
		this.value = value;
		this.count = count;
	}
	
	public int getValue() {
		return value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
public class TrainSet {

	
	public static void main(String[] args) {
		HashMap<String,Train> hash = new HashMap<>();
		hash.put("abc", new Train(1,1));
		String newString = "abc";
		
		if(hash.containsKey(newString)) {
			Train train = hash.get(newString);
			if(1 == train.getValue()) {
				train.setCount(train.getCount()+1);
			}
			hash.put(newString, train);
		}
		System.out.println(hash.get(newString).getCount() + " "+ hash.get(newString).getValue());
	}

}
