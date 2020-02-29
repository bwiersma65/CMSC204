/**
 * Class to represent a Container which implements a Stack to store its objects contained within
 * @author benwiersma
 */
public class Container implements ContainerInterface {
	
	private final int DEFAULT_SIZE = 5;
	private int containerSize, containerCount;
	private MyStack<DonationPackage> stack;
	
	/**
	 * Parameterized Container constructor
	 * @param size the capacity of the Container stack
	 */
	public Container (int size) 
	{
		containerSize = size;
		containerCount = 0;
		stack = new MyStack<>(size);
	}
	/**
	 * Default Container constructor
	 */
	public Container() 
	{
		containerSize = DEFAULT_SIZE;
		containerCount = 0;
		stack = new MyStack<>();
	}

	/**
	 * loadContainer method simulates loading the DonationPackage parameter onto the Container stack
	 * @param DonationPackage object to be stacked
	 * @return true if the stacking is successful, false if unsuccessful
	 */
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		try {
			stack.push(dPackage);
		}
		catch (RuntimeException e) {
			throw new ContainerException("The Container is Full");
		}
		
		if (containerSize == containerCount)
			return false;
		else
			containerCount++;
			return true;
	}

	/**
	 * removePackageFromContainer method simulates removing the topmost DonationPackage object from the Container stack
	 * @return DonationPackage that was removed from the stack
	 */
	public DonationPackage removePackageFromContainer() throws ContainerException {
		DonationPackage pkg;
		
		try {
			pkg = stack.pop();
		}
		catch (RuntimeException e) {
			throw new ContainerException("The Container is Empty");
		}
		containerCount--;
		return pkg;
	}

	/**
	 * toArrayPackage method creates an array of the DonationPackage objects from the stack
	 * @return the array of DonationPackages
	 */
	public DonationPackage[] toArrayPackage() {
		int size = stack.size();
		Object[] temp = stack.toArray();
//		int index = 0;
		DonationPackage[] arr = new DonationPackage[size];
		
		for (int i = 0; i < containerCount; i++) {
			arr[i] = new DonationPackage((DonationPackage)temp[i]);
		}
		
		return arr;
		
//		Object[] temp = stack.toArray();
////		int index = 0;
//		DonationPackage[] arr = new DonationPackage[temp.length];
//		
//		for (int i = 0; i < containerCount; i++) {
//			arr[i] = new DonationPackage((DonationPackage)temp[i]);
//		}
//		
//		return arr;
	}
	
	
}
