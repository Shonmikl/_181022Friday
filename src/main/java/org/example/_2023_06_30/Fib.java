package org.example._2023_06_30;

import java.util.Optional;
import java.util.stream.Stream;

public class Fib {
    public static long fibLoops(final int fibIndex) {
        if(fibIndex < 0) {
            throw new IllegalArgumentException();
        }

        var fib1 = -1L;
        var fib2 = 1L;
        for (int i = 0; i <= fibIndex ; i++) {
            var fibCurrent = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibCurrent;
        }
        return fib2;
    }

    public static long fibRec(final int fibIndex) {
        if(fibIndex < 0) {
            throw new IllegalArgumentException();
        }

        if(fibIndex == 0) {
            return 0;
        }

        return fibIndex == 1 || fibIndex == 2 ?
                1L : fibRec(fibIndex - 2) + fibRec(fibIndex - 1);
    }

    public static long fibStream(final int fibIndex) {
        Optional<Long> result = Stream
                .iterate(new long[]{0, 1}, arr -> new long[]{arr[1], arr[0]+ arr[1]})
                .limit(fibIndex + 1)
                .map(y -> y[0])
                .max(Long::compareTo);
        return result.orElseThrow(IllegalArgumentException::new);
    }

    public static void main(String[] args) {
        long n = 49;
        long loopTime = System.currentTimeMillis();
        System.out.println("FIB: " + fibLoops((int) n));
        System.out.println("fibLoops time: " + (System.currentTimeMillis() - loopTime));

        long recTime = System.currentTimeMillis();
        System.out.println("FIB: " + fibRec((int) n));
        System.out.println("fibRec time: " + (System.currentTimeMillis() - recTime));

        long streamTime = System.currentTimeMillis();
        System.out.println("FIB: " + fibStream((int) n));
        System.out.println("fibStream time: " + (System.currentTimeMillis() - streamTime));
    }
}
