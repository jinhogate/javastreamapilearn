package javastreamapilearn;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
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
		
		// Some operations you can use on stream
		list.add(6);
		list.add(7);
		long count = list.stream().distinct().count();
		System.out.println("Count : " + count);
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		Stream<Integer> streamList2 = list2.stream();
		list2.add(6);
		long count2 = streamList2.distinct().count();
		System.out.println("Count2 : " + count2);
		
		// Iterating
		System.out.println("Iterating");
		boolean found  = list2.stream().anyMatch(i -> i<4);
		System.out.println(found);
		
		// Filtering
		System.out.println("Filtering");
		List<String> list3 = Arrays.asList("One","OneAndOnly","Derek","Change","");
		Stream<String> streamList3 = list3.stream().filter(s -> s.length()>4);
		streamList3.forEach(System.out::println);
		
		// Mapping
		System.out.println("Mapping");
		List<String> uris = new ArrayList<>();
		uris.add("C:\\My.txt");
		Stream<Path> streamUris = uris.stream().map(uri -> Paths.get(uri));
		streamUris.forEach(System.out::println);
		list.stream().peek(n -> System.out.print(n)).map(n -> n*n).forEach(System.out::println);
		
		// Matching
		System.out.println("Matching");
		boolean anyMatch = list.stream().anyMatch(n-> n>4);
		boolean allMatch = list.stream().allMatch(n -> n>4);
		boolean noneMatch = list.stream().noneMatch(n -> n>4);
		System.out.println(anyMatch + " " + allMatch + " " + noneMatch);
		System.out.println(Stream.empty().allMatch(Objects::nonNull));
		
		// Reduction
		System.out.println("Reduction");
		list.stream().forEach(System.out::print);
		System.out.println("");
		System.out.println(list.stream().reduce(10, (a,b) -> a+b));
		System.out.println(list.stream().min((a,b) -> a.compareTo(b)).get());
		System.out.println(list.stream().max((a,b) -> a.compareTo(b)).get());
		
		// Collecting
		System.out.println("Collecting");
		List finalList = list.stream().distinct().filter(n -> n>4).collect(Collectors.toList());
		finalList.stream().forEach(System.out::println);
	}
	
	

}
