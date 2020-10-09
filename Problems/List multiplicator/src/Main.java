import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
    Class to modify
*/
class ListMultiplicator {

    /**
        Multiplies original list provided number of times   
        @param list list to multiply
        @param n times to multiply, should be zero or greater
    */
	public static void multiply(List<?> list, int n) {
		//System.out.println(list.size()+", "+n);
		if(n>0)
		helpMultiply(list,n);
		else
			list.clear();
		//System.out.println(list.size());
	}

	private static <T> void helpMultiply(List<T> list, int n) {
		List<T> newList = new ArrayList<>(list);
		for(int i = 0; i < n-1; i++) {
			newList.addAll(list);
		}
		list.clear();
		list.addAll(newList);
	}

	/*public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(16);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.size());
		multiply(list,4);
System.out.println("New list size"+list.size());
		list.forEach(System.out::println);

		System.out.println("Well done!");
	}*/
}