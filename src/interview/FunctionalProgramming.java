package interview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionalProgramming
{

  public static <G1, T> Consumer<G1> composeFafterG(Consumer<? super T> f, Function<G1, ? extends T> g) {
    return (G1 x) ->
    {
      f.accept(g.apply(x));
    };
  }

  public static <T1,T2,TResult> Function<T1, Function<T2, TResult>> composition(BiFunction<T1, T2, TResult> fn) {
    return (T1 x) ->
    {
      return (T2 y) ->
      {
        return fn.apply(x, y);
      };
    };
  }

  public static <T> Consumer<T> assignElementToIPosition(T[] l, Integer i){
    return (T x) -> {
      l[i] = x;
    };
  }


  public static <T> Stream<?> countValue(Stream<T> e, BiConsumer<T, Integer> fn) {
    AtomicInteger counter = new AtomicInteger(0);
    return e.map((T x) -> {
      fn.accept(x, counter.getAndIncrement());
      return true;
    });
  }


  public static <Z> void foo(Z[] mainArray, BiFunction<Integer, Z, Z> f)  {
    BiFunction<Z[], Integer, Consumer<Z>> aFixedToZ = (Z[] l1, Integer i1) ->
    {
      return assignElementToIPosition(l1, i1);
    };
    BiFunction<Stream<Z>, BiConsumer<Z, Integer>, Stream<?>> gFixedToZ = (Stream<Z> e, BiConsumer<Z, Integer> fn) ->
    {
      return countValue(e, fn);
    };


    Function<Z[], Function<Integer, Consumer<Z>>> composition = composition(aFixedToZ);
    Function<Integer, Consumer<Z>> a_ =   composition.apply(mainArray);
    Function<Stream<Z>, Function<BiConsumer<Z, Integer>, Stream<?>>> composition1 = composition(gFixedToZ);
    Function<BiConsumer<Z, Integer>, ? extends Stream<?>> g_ = composition1.apply(Stream.of(mainArray));

    BiConsumer<Z, Integer> bar = (Z x, Integer i) ->
    {
      composeFafterG(a_.apply(i), composition(f).apply(i)).accept(x);
    };

    g_.apply(bar).forEach(i -> {});
  }

}
