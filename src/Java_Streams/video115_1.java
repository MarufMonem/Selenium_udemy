package Java_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.stream.StreamFilter;

import org.testng.annotations.Test;

public class video115_1 {
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
	}

	
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

	public static void main(String args[]) {
//		streamFilter();

	}
	

}
