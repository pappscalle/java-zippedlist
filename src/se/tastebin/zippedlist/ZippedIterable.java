package se.tastebin.zippedlist;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ZippedIterable implements Iterable<String> {

    private final List<String> first;
    private final List<String> second;

    public ZippedIterable(List<String> first, List<String> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Iterator<String> iterator() {
        return new Zipper(first.iterator(), second.iterator());
    }
    
    public List<String> asList() {
        return StreamSupport.stream(spliterator(), false).collect(Collectors.toList());
    }
    
    private class Zipper implements Iterator<String> {

        Iterator<String> first;
        Iterator<String> second;

        private Zipper(Iterator<String> first, Iterator<String> second) {
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
