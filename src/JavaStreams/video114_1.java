package JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class video114_1 {
@Test
	public  static void regular() {
//		Count the names that start with A
		List<String> names  = new ArrayList<String>();
		names.add("Aron");
		names.add("Tron");
		names.add("Daisy");
		names.add("Ghalib");
		names.add("Aibby");
		int count =0;
		
		for (String name : names) {
			char characters[] = name.toCharArray();
			if(characters[0] == 'A') {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test
	public static void streamFilter() {
		List<String> names  = new ArrayList<String>();
		names.add("Aron");
		names.add("Tron");
		names.add("Daisy");
		names.add("Ghalib");
		names.add("Aibby");
		
//		Making the array list into streams. Streams are a collection of strings
//		Filter method would filter based on the condtions provided
		Long c = names.stream().filter(s-> s.startsWith("A")).count();
		System.out.println(c);
		
//		names.stream().filter(s-> s.length()>4).forEach(s-> System.out.println(s));
		names.stream().filter(s-> s.length()>4).limit(1).forEach(s-> System.out.println(s));
	}

	
	@Test
	public static void multipleFilters() {
		long d = Stream.of("Arum", "Sarath", "Rahim", "Asish").filter(s-> 
		{
			return s.startsWith("A");
		}
				).filter(p->
				{
					return p.endsWith("m");
				}
						).count(); 
		
		System.out.println(d);
	}
	@Test
	public static void streamMap(){
//		print names with last letter h
		Stream.of("Azrum", "Sarath", "Rahim", "Asish")
				.filter(s -> s.endsWith( "h"))
				.map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		System.out.println("----------------------");
//		Print names which have first letter as A with uppercase and sorted
		String a[] = {"Azrum", "Sarath", "Rahim", "Asish"};
		List<String> names = Arrays.asList(a);
		names.stream()
				.filter(s -> s.startsWith("A"))
				.sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}
//Merging streams
	@Test
	public static void mergingStreams(){
		String a1[] = {"Azrum", "Sarath", "Rahim", "Asish"};
		String a2[] = {"Anish", "Harish", "Chenu", "Diviya", "Micheal"};
		Stream<String> newStream =  Stream.concat(Arrays.stream(a1), Arrays.stream(a2));
//		newStream.sorted().forEach(s -> System.out.println(s));

		Boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Sarath"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test
	public static void streamCollect(){
		List<String> newList =  Stream.of("Azrum", "Sarath", "Rahim", "Asish")
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
//		Print the first result
		System.out.println(newList.get(0));
	}
	@Test
	public static void uniqueValues(){
	Integer numbers[] = {3,2,2,7,5,1,9,7};
	Stream<Integer> valuesStream = Arrays.stream(numbers);
	valuesStream.distinct().sorted().forEach(s -> System.out.println(s));

	List <Integer> listValues = Arrays.stream(numbers).distinct().sorted().collect(Collectors.toList());
		System.out.println("3rd value: " + listValues.get(2));
	}
	

}
