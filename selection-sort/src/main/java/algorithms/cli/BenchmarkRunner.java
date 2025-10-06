package algorithms.cli;

import algorithms.SelectionSort;
import java.util.Arrays;
import java.util.Scanner;

public class BenchmarkRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Создание массива случайных чисел
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000); // Random numbers between 0 and 999
        }

        // Вывод массива до сортировки
        System.out.println("Array before sorting: " + Arrays.toString(array));

        // Сортировка массива
        long startTime = System.nanoTime();
        SelectionSort.sort(array);
        long endTime = System.nanoTime();

        // Вывод массива после сортировки
        System.out.println("Array after sorting: " + Arrays.toString(array));

        // Вывод времени выполнения сортировки
        long duration = (endTime - startTime);
        System.out.println("Sorting took " + duration + " nanoseconds.");
    }
}
