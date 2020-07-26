package se.tastebin.zippedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<String> firstNames = Arrays.asList("Arnold", "Sylvester", "Jean-Claude");
        List<String> lastNames = Arrays.asList("Schwarzenegger", "Stallone", "Van Damme");

        System.out.print("First names: ");
        System.out.println(firstNames);
        System.out.println();

        System.out.print("Family names: ");
        System.out.println(lastNames);
        System.out.println();

        System.out.print("Complete names with FOR LOOP: ");
        System.out.println(zipWithForLoop(firstNames, lastNames));
        System.out.println();

        System.out.print("... with ITERATOR: ");
        System.out.println(zipWithIterators(firstNames, lastNames));
        System.out.println();

        System.out.print("... with INTSTREAM: ");
        System.out.println(zipWithIntStream(firstNames, lastNames));
        System.out.println();

        System.out.println("... with ITERABLE class ");
        ZippedIterable zip = new ZippedIterable(firstNames, lastNames);

        System.out.print("1) .foreach: ");
        zip.forEach(System.out::print);
        System.out.println();

        System.out.print("2) Extended for-loop: ");
        for (String s : zip) {
            System.out.print(s);
            System.out.print(", ");
        }
        System.out.println();

        System.out.print("3) in println() (not working): ");
        System.out.println(zip);

        System.out.print("4) in println (after conversion to List): ");
        System.out.println(zip.asList());

        System.out.println();
        System.out.println("List class: ");

        ZippedList<String, String, String> zip2 = new ZippedList<>(firstNames, lastNames, (t, u) -> t + " " + u);

        System.out.print("1) .foreach: ");
        zip2.forEach(System.out::print);
        System.out.println();

        System.out.print("2) Extended for-loop: ");
        for (String s : zip2) {
            System.out.print(s);
        }
        System.out.println();

        System.out.print("3) in println(): ");
        System.out.println(zip2);

    }

    private static List<String> zipWithForLoop(List<String> firstNames, List<String> lastNames) {
        List<String> people = new ArrayList<>();
        for (int i = 0; i < Math.min(firstNames.size(), lastNames.size()); i++) {
            people.add(firstNames.get(i) + " " + lastNames.get(i));
        }
        return people;
    }

    private static List<String> zipWithIterators(List<String> firstNames, List<String> lastNames) {
        List<String> people = new ArrayList<>();

        Iterator f = firstNames.iterator();
        Iterator l = lastNames.iterator();

        while (f.hasNext() && l.hasNext()) {
            people.add(f.next() + " " + l.next());
        }
        return people;
    }

    private static List<String> zipWithIntStream(List<String> firstNames, List<String> lastNames) {
        return IntStream.range(0, Math.min(firstNames.size(), lastNames.size()))
                .mapToObj(i -> firstNames.get(i) + " " + lastNames.get(i))
                .collect(Collectors.toList());
    }

}
