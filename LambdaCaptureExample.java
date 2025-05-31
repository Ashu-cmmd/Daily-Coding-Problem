// What does the below code snippet print out? How can we fix the anonymous functions to behave as we'd expect?

// functions = []
// for i in range(10):
//     functions.append(lambda : i)

// for f in functions:
//     print(f())

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LambdaCaptureExample {
    public static void main(String[] args) {
        List<Supplier<Integer>> functions = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int copy = i; // capture variable
            functions.add(() -> copy);
        }

        for (Supplier<Integer> f : functions) {
            System.out.println(f.get());
        }
    }
}
