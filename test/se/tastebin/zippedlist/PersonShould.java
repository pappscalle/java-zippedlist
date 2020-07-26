package se.tastebin.zippedlist;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class PersonShould {
    
    @Test
    public void printItsNameAndAge() {
        Person p = new Person("John", 32);
        assertEquals(p.toString(), "John is 32 years old");
    }
    
}
