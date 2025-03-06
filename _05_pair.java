// cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
// For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class _05_pair {
    public static void main(String[] args) {
        Pair<Integer, Integer> pair = cons(3, 4);
        System.out.println("car(pair): " + car(pair)); // Output: car(pair): 3
        System.out.println("cdr(pair): " + cdr(pair)); // Output: cdr(pair): 4
    }

    public static <A, B> Pair<A, B> cons(A a, B b) {
        return new Pair<>(a, b);
    }

    public static <A, B> A car(Pair<A, B> pair) {
        return pair.getFirst();
    }

    public static <A, B> B cdr(Pair<A, B> pair) {
        return pair.getSecond();
    }
}
