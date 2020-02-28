
public class ArraySum {

	public ArraySum() {
		
	}
	
	public int sumOfArray(Integer[] arr, int index) {
		
		if (index == 0)
			return arr[index].intValue();
		else
			return sumOfArray(arr, index-1) + arr[index].intValue();
	}
	
	
}
