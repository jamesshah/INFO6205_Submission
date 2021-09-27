package edu.neu.coe.info6205;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class InsertionSortBenchmark {

    private static Config config; // Configuration container
//    public static int N = 1000; // Size of array

    public static Helper<Integer> getHelper(String description, int sizeOfArray, Config config) {
        return new BaseHelper<Integer>(description, sizeOfArray, config);
    }

    public static Supplier<Integer[]> getSupplier(String typeOfArray, int sizeOfArray){
        switch (typeOfArray){
            case "ORDERED":
                Integer[] orderedArray = new Integer[sizeOfArray];
                for (int i = 0; i < sizeOfArray; i++){
                    orderedArray[i] = i + 1;
                }
                return () -> orderedArray;

            case "REVERSE_ORDERED":
                Integer[] reverseOrderedArray = new Integer[sizeOfArray];
                for (int i = 0; i < sizeOfArray; i++){
                    reverseOrderedArray[i] = sizeOfArray - i + 1;
                }
                return () -> reverseOrderedArray;

            case "PARTIALLY_ORDERED":
                Integer[] partiallyOrderedArray = new Integer[sizeOfArray];
                for (int i = 0; i < sizeOfArray; i++){
                    if(i <= 300)
                        partiallyOrderedArray[i] = i + 1;
                    else
                        partiallyOrderedArray[i] = sizeOfArray - i + 1;
                }
                return () -> partiallyOrderedArray;

            case "RANDOM":
                Helper<Integer> helper = getHelper("Insertion Sort (Random Array)", sizeOfArray, config);
                return () -> helper.random(Integer.class, Random::nextInt);

            default:
                System.out.println("Please enter a valid type of Array");
                return () -> null;
        }
    }

    private static void runBenchmarks(String typeOfArray) {
        int N;
        switch (typeOfArray){
            case "ORDERED":
                N = 1000;
                System.out.print("Benchmarking InsertionSort for sorted array elements:\n");
                for (int i = 0; i < 5; i++) {
                    Helper<Integer> helper = getHelper("Insertion Sort(Ordered Array)", N, config);
                    Supplier<Integer[]> supplier = getSupplier(typeOfArray,N);
                    final GenericSort<Integer> sort = new InsertionSort<>(helper);
                    final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                            "Insertion sort for " + N + " Integers",
                            (xs) -> Arrays.copyOf(xs, xs.length),
                            sort::sort,
                            null
                    );
                    System.out.println((benchmark.runFromSupplier(supplier, 100)) + "ms");
                    N *= 2;
                }
                break;

            case "REVERSE_ORDERED":
                N = 1000;
                System.out.print("Benchmarking InsertionSort for reverse sorted array elements:\n");
                for (int i = 0; i < 5; i++) {
                    Helper<Integer> helper = getHelper("Insertion Sort(Reverse Ordered Array)", N, config);
                    Supplier<Integer[]> supplier = getSupplier(typeOfArray,N);
                    final GenericSort<Integer> sort = new InsertionSort<>(helper);
                    final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                            "Insertion sort for " + N + " Integers",
                            (xs) -> Arrays.copyOf(xs, xs.length),
                            sort::sort,
                            null
                    );
                    System.out.println((benchmark.runFromSupplier(supplier, 100)) + "ms");
                    N *= 2;
                }
                break;

            case "PARTIALLY_ORDERED":
                N = 1000;
                System.out.print("Benchmarking InsertionSort for partially sorted array elements:\n");
                for (int i = 0; i < 5; i++) {
                    Helper<Integer> helper = getHelper("Insertion Sort(Partially Ordered Array)", N, config);
                    Supplier<Integer[]> supplier = getSupplier(typeOfArray,N);
                    final GenericSort<Integer> sort = new InsertionSort<>(helper);
                    final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                            "Insertion sort for " + N + " Integers",
                            (xs) -> Arrays.copyOf(xs, xs.length),
                            sort::sort,
                            null
                    );
                    System.out.println((benchmark.runFromSupplier(supplier, 100)) + "ms");
                    N *= 2;
                }
                break;

            case "RANDOM":
                N = 1000;
                System.out.print("Benchmarking InsertionSort for random array elements:\n");
                for (int i = 0; i < 5; i++) {
                    Helper<Integer> helper = getHelper("Insertion Sort(Random Array)", N, config);
                    Supplier<Integer[]> supplier = getSupplier(typeOfArray,N);
                    final GenericSort<Integer> sort = new InsertionSort<>(helper);
                    final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                            "Insertion sort for " + N + " Integers",
                            (xs) -> Arrays.copyOf(xs, xs.length),
                            sort::sort,
                            null
                    );
                    System.out.println((benchmark.runFromSupplier(supplier, 100)) + "ms");
                    N *= 2;
                }
                break;

            default:
                System.out.println("Please enter a valid type of array");
                break;
        }


    }

    public static void main(String[] args) {
        String[] typeOfArray = {"RANDOM", "ORDERED", "REVERSE_ORDERED", "PARTIALLY_ORDERED"};

        for (String type: typeOfArray) {
            runBenchmarks(type);
        }
    }}

