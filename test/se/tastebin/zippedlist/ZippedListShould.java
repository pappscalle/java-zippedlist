package se.tastebin.zippedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import se.tastebin.zippedlist.Person;
import se.tastebin.zippedlist.ZippedList;

public class ZippedListShould {
    
    @Test
    public void returnAnEmptyListWhenBothInputListAreEmpty() {
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        List<String> actual = new ZippedList<>(list1, list2, (a, b) -> a+b);
        
        assertEquals(actual, new ArrayList<String>());
    }
    
    @Test
    public void returnTheSameSizeAsTheShortestInputList() {
        
        List<String> list1 = Arrays.asList("Twenty", "Thirty", "Fourty");
        List<String> list2 = Arrays.asList("one", "two");
        
        List<String> actual = new ZippedList<>(list1, list2, (a, b) -> a+b);
        
        assertEquals(actual.size(), 2);
    }
    
    @Test
    public void returnAListOfPeople() {
        
        List<String> names = Arrays.asList("John", "Shirley", "Peter");
        List<Integer> ages = Arrays.asList(32, 28, 3);
        
        List<Person> people = new ZippedList<>(names, ages, (a, b) -> new Person(a, b));
        assertEquals(people.size(), 3);
        
    }
    
    
    
}
