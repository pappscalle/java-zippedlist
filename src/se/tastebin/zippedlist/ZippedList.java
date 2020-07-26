package se.tastebin.zippedlist;

import java.util.AbstractList;
import java.util.List;
import java.util.function.BiFunction;

public class ZippedList<A, B, T> extends AbstractList<T> {

    private final List<A> first;
    private final List<B> second;
    private final BiFunction<A, B, T> zipper;

    public ZippedList(List<A> first, List<B> second, BiFunction<A, B, T> zipper) {
        this.first = first;
        this.second = second;
        this.zipper = zipper;
    }

    @Override
    public T get(int i) {
        return zipper.apply(first.get(i), second.get(i));
    }

    @Override
    public int size() {
        return Math.min(first.size(), second.size());
    }

}
