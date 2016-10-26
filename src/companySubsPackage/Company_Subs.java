package companySubsPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Company_Subs {
	public static void main(String[] args) {
		String[] str = new String[] {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
		ArrayList<String> subs = new ArrayList<String>(Arrays.asList(str));

		System.out.println("Исходный массив:");
		for(String i:subs){
			System.out.println(i);
		}
		
		Set<String> result = new TreeSet<String>();
		
		for(String i:subs) {
			ArrayList<String> sub = new ArrayList<String>(Arrays.asList(i.trim().split("\\\\")));
  
			for(int j = 1; j <= sub.size(); j++) {
				List<String> s = sub.subList(0, j);
				result.add(String.join("\\",s));
			}
		}
		
		System.out.println("\nСортировка по возрастанию:");
		for(String i:result) {
			System.out.println(i);
		}

		
		Set<String> sorted = new TreeSet<String>(new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		
		System.out.println("\nСортировка по убыванию:");
		sorted.addAll(result);
		for(String i:sorted) {
			System.out.println(i);
		}
	}
}
