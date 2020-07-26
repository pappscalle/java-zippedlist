package se.tastebin.zippedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<String> firstNames = Arrays.asList("Anders", "Bengt", "Carl");
        List<String> lastNames = Arrays.asList("Andersson", "Bengtsson", "Carlsson");
        
        
        System.out.print("1st List: ");
        System.out.println(firstNames);
        System.out.print("2nd List: ");
        System.out.println(lastNames);
     
        System.out.println("For loop: ");
        System.out.println(zipWithForLoop(firstNames, lastNames));
        
        System.out.println("Iterator: ");
        System.out.println(zipWithIterators(firstNames, lastNames));
        
        System.out.print("INT Stream: ");
        System.out.println(zipWithIntStream(firstNames, lastNames));
        
        System.out.println("Iterable class: ");
        ZippedIterator zip = new ZippedIterator(firstNames, lastNames);
        zip.forEach(System.out::println);
        for (String s : zip) {
           System.out.println(s);
        }
        System.out.println(zip);
        
        System.out.println(zip.asList());
        
        System.out.println("List class: ");
        
        ZippedList zip2 = new ZippedList(firstNames, lastNames, (x, y) -> x + " " + y);
        zip2.forEach(System.out::println);
        for (String s : zip2) {
           System.out.println(s);
        }
        System.out.println(zip2);
        
    }

    private static List<String> zipWithForLoop(List<String> firstNames, List<String> lastNames) {
        List<String> people = new ArrayList<>();
        for (int i=0; i< Math.min(firstNames.size(),lastNames.size()); i++) {
            people.add(firstNames.get(i) + " " + lastNames.get(i));
        }
        return people;
    }

    private static List<String> zipWithIterators(List<String> firstNames, List<String> lastNames) {
        List<String> people = new ArrayList<>();
        
        Iterator f = firstNames.iterator();
        Iterator l = lastNames.iterator();
        
        while (f.hasNext() && l.hasNext() ) {
            people.add(f.next() + " " + l.next() );
        }
        return people;
    }
             
    private static List<String> zipWithIntStream(List<String> firstNames, List<String> lastNames) {
        return IntStream.range(0, Math.min(firstNames.size(), lastNames.size()))
                .mapToObj(i -> firstNames.get(i) + " " + lastNames.get(i))
                .collect(Collectors.toList());
    }
   
}
