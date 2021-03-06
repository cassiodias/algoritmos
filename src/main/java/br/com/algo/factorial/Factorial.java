package br.com.algo.factorial;

public class Factorial {

    public int of(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        } else if (number == 0 || number == 1)
            return 1;
        return of(number - 1) * number;
    }

}
