package algo.randomized;

import java.security.SecureRandom;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

class ReservoirSamplingJava8<T> implements Collector<T, List<T>, List<T>> {
    final Random rand = new SecureRandom();
    final int sz;
    int c = 0;

    public ReservoirSamplingJava8(int size) {
        this.sz = size;
    }

    private void addIt(final List<T> in, T s) {
        if (in.size() < sz) {
            in.add(s);
        }
        else {
            int replaceInIndex = (int) (rand.nextDouble() * (sz + (c++) + 1));
            if (replaceInIndex < sz) {
                in.set(replaceInIndex, s);
            }
        }
    }

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return this::addIt;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (left, right) -> {
            left.addAll(right);
            return left;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH);
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return (i) -> i;
    }

}


class Main {
    public static void main(String[] args) {
        List<Integer> sample = IntStream.range(0, 1000).boxed()
                .collect(new ReservoirSamplingJava8<>(10));
        System.out.println("Streamed Sample :" + sample);
    }
}
