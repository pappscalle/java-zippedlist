package zipped;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ZippedList implements Iterable<String> {

    private final List<String> first;
    private final List<String> second;

    public ZippedList(List<String> first, List<String> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator(first.iterator(), second.iterator());
    }
    
    public List<String> asList() {
        return StreamSupport.stream(spliterator(), false).collect(Collectors.toList());
    }
    
    private class MyIterator implements Iterator<String> {

        Iterator<String> first;
        Iterator<String> second;

        private MyIterator(Iterator<String> first, Iterator<String> second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean hasNext() {
            return first.hasNext() && second.hasNext();
        }

        @Override
        public String next() {
            return first.next() + " " + second.next();
        }

    }
}
