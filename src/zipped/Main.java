package zipped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<String> firstNames = Arrays.asList("Anders", "Bengt", "Carl");
        List<String> lastNames = Arrays.asList("Andersson", "Bengtsson", "Carlsson");
        
        System.out.println(firstNames);
        System.out.println(lastNames);
     
        System.out.println(zipWithForLoop(firstNames, lastNames));
        
        System.out.println(zipWithIterators(firstNames, lastNames));
        
        System.out.println(zipWithIntStream(firstNames, lastNames));
        
        
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
