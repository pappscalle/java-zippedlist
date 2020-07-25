package zipped;

import java.util.AbstractList;
import java.util.List;

public class ZippedList2 extends AbstractList<String>{

    private final List<String> first;
    private final List<String> second;

    public ZippedList2(List<String> first, List<String> second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String get(int i) {
        return first.get(i)+ " " + second.get(i);
    }

    @Override
    public int size() {
        return Math.min(first.size(), second.size());
    }
    
}
