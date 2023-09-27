package ch.zhaw.ads.solutions;

import ch.zhaw.ads.CommandExecutor;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class KgvServer implements CommandExecutor {

    @Override
    public String execute(String s) {
        String[] numbers = s.split("[ ,]+");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        return Integer.toString(kgv(a, b));
    }

    public int kgv(int a, int b) {
        if (a == 0 || b == 0) return 0;
        if (a % b == 0) return a;
        if (b % a == 0) return b;
        int first = a;
        int second = b;

        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        return first * second / a;
    }



}
