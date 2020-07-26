package se.tastebin.zippedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ZipperIterableShould {
    
        
    @Test
    public void haveAnEmptyIteratorWhenBothInputListAreEmpty() {
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        ZippedIterable zi = new ZippedIterable(list1, list2);
        assertFalse(zi.iterator().hasNext());
    }
    
    @Test
    public void returnAnIteratotWithTheSameSizeAsTheShortestInputList() {
        
        List<String> list1 = Arrays.asList("Twenty", "Thirty", "Fourty");
        List<String> list2 = Arrays.asList("one", "two");
        
        ZippedIterable zipped = new ZippedIterable(list2, list2);
        
        int count = 0;
        Iterator<String> zi = zipped.iterator();
        while (zi.hasNext()) {
            zi.next();
            count++;
        }
        
        assertEquals(count, 2);
    }
    
    @Test
    public void returnAListOfPeople() {
        
        List<String> names = Arrays.asList("John", "Shirley", "Peter");
        List<String> ages = Arrays.asList("32", "28", "3");
        
        ZippedIterable zipped = new ZippedIterable(names, ages);
        
        int count = 0;
        Iterator<String> zi = zipped.iterator();
        while (zi.hasNext()) {
            zi.next();
            count++;
        }
        
        assertEquals(count, 3);
        
    }
    
    @Test
    public void returnAListWithAllPeople() {
        
        List<String> names = Arrays.asList("John", "Shirley", "Peter");
        List<String> ages = Arrays.asList("32", "28", "3");
        
        ZippedIterable zipped = new ZippedIterable(names, ages);
        
        List<String> people = zipped.asList();
        
        assertEquals(people.size(), 3);
        
    }
    

}
