/*
 * Copyright (c) 2018. Phasmid Software
 */

package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.Sort;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import java.util.Random;

import java.util.function.Function;

public class Benchmark_Main<T> {
    public static Integer[] random = new Integer[10000];
    public static Integer[] sorted = new Integer[10000];
    public static Integer[] partially = new Integer[10000];
    public static Integer[] reverse = new Integer[10000];

    public Benchmark_Main(Function<T, Void> f) {
        this.f = f;
    }

    public double runArray(T t, int n) {
        long initial_time = System.nanoTime();

        for (int i = 0; i < n; i++) {
            random = random();
            sorted = ordered();
            partially = partiallyOrdered();
            reverse = reverseOrdered();
            T a = t;
            f.apply(a);
        }
        long final_time = System.nanoTime() - initial_time;
        double avg = final_time / 1000;
        avg = avg / n;
        return avg;

    }

    public static Integer[] random() {
        Random rand = new Random();
        for (int i = 0; i < random.length; i++) {
            random[i] = rand.nextInt(i + 1);
        }
        return random;
    }

    public static Integer[] ordered() {
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }
        return sorted;
    }

    public static Integer[] partiallyOrdered() {
        Random rand = new Random();

        for (int i = 0; i <= partially.length / 2; i++) {
            partially[i] = i;
        }

        for (int i = partially.length / 2 + 1; i < partially.length; i++) {
            partially[i] = rand.nextInt(partially.length - i);
        }
        return partially;
    }

    public static Integer[] reverseOrdered() {
        int j = 0;
        for (int i = reverse.length - 1; i >= 0; i--) {
            reverse[j] = i;
            j++;
        }
        return reverse;
    }

    private final Function<T, Void> f;

    public static void main(String[] args) {
        int m = 100;
        Integer[] array = new Integer[10000];
        int n = 200;
        for (int i = n; i <= 10000; i = i * 2) { // run for 5 different values of n
            n = i;
            random = random();
            sorted = ordered();
            partially = partiallyOrdered();
            reverse = reverseOrdered();

            System.out.println("For sorted array");
            benchmarkSort(sorted, n, "InsertionSort", new InsertionSort<>(), m);
            System.out.println("For reverse array");
            benchmarkSort(reverse, n, "InsertionSort", new InsertionSort<>(), m);
            System.out.println("For partially sorted array");
            benchmarkSort(partially, n, "InsertionSort", new InsertionSort<>(), m);
            System.out.println("For random array");
            benchmarkSort(random, n, "InsertionSort", new InsertionSort<>(), m);

        }
    }

    private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer, Void> sortFunction = (x) -> {
            sorter.sort(xs, 0, x);
            return null;
        };
        Benchmark_Main<Integer> bm = new Benchmark_Main<>(sortFunction);
        double x = bm.runArray(n, m);
        System.out.println(name + ": " + x + " millisecs for n=" + n);
    }
}