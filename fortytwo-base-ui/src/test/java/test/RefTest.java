package test;

import java.util.HashMap;
import java.util.Map;

public class RefTest {


    public static void main(String[] args) {
        //test1();
        //new RefTest().test2();
        new RefTest().test3();
    }

    public static void test1() {
        Map<String, String> arg = new HashMap<>();
        arg.put("1", "2");

        System.out.println("1: " + arg);

        Map<String, String> arg2 = arg;

        System.out.println("2: " + arg);
        System.out.println("2: " + arg2);

        arg = null;

        System.out.println("3: " + arg);
        System.out.println("3: " + arg2);
    }


    public void test2() {
        Map<String, String> arg = new HashMap<>();
        arg.put("1", "2");

        System.out.println("1: " + arg);

        test2innner(arg);

        System.out.println("4: " + arg);

    }

    public void test2innner(Map<String, String> arg) {
        Map<String, String> arg2 = arg;

        System.out.println("2: " + arg);
        System.out.println("2: " + arg2);

        arg.put("1", "MURAT");
        arg = null;

        System.out.println("3: " + arg);
        System.out.println("3: " + arg2);

    }

    public void test3() {
        Map<String, String> arg = new HashMap<>();
        arg.put("1", "2");

        System.out.println("1: " + arg);

        test3innner(arg);

        System.out.println("5: " + arg);

    }

    public void test3innner(Map<String, String> arg) {
        Map<String, String> arg2 = arg;

        System.out.println("2: " + arg);
        System.out.println("2: " + arg2);

        arg = new HashMap<>();
        arg.put("NEW", "NEW");

        System.out.println("3: " + arg);
        System.out.println("3: " + arg2);

        arg = null;

        System.out.println("4: " + arg);
        System.out.println("4: " + arg2);

    }
}
