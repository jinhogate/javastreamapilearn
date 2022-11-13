package javastreamapilearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
	
	public static void main (String[] args) {
		
		// Stream Creation
		
			// Creation Stream from array
		String[] arr = {"a","b","c"};
		Stream<String> stream = Arrays.stream(arr);
		stream.forEach(System.out::println);
		
			// Creation Stream with key 'of'
		Stream<String> streamOf = Stream.of("Kossi","Koffi","Kodjo");
		streamOf.forEach(System.out::println);
		
			// Creation Stream from a list
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		Stream<Integer> streamList = list.stream();
		list.add(6);
		streamList.forEach(System.out::println);
		
		// Multi-threading with Streams 
		Stream<Integer> streamParallel = list.parallelStream();
		streamParallel.forEach(System.out::println);
		
	}

}
