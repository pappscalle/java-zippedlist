package zipped;

import java.util.AbstractList;
import java.util.List;
import java.util.function.BiFunction;

public class ZippedList extends AbstractList<String>{

    private final List<String> first;
    private final List<String> second;
    private final BiFunction<String, String, String> zipper;
    
    public ZippedList(List<String> first, List<String> second, BiFunction<String, String, String> zipper) {
        this.first = first;
        this.second = second;
        this.zipper = zipper;
    }
    
    @Override
    public String get(int i) {
        return zipper.apply( first.get(i), second.get(i));
    }

    @Override
    public int size() {
        return Math.min(first.size(), second.size());
    }
    
}
