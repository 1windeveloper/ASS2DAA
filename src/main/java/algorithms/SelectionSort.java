package algorithms;

import metrics.Tracker;

public class SelectionSort {

    public static void sort(int[] arr, Tracker tr) {
        if (arr == null) throw new IllegalArgumentException("arr == null");
        if (tr == null) tr = new Tracker();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                tr.addComp();
                tr.addAccess(2);
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                tr.addAccess(1);
                int tmp = arr[i];

                tr.addAccess(2); //
                arr[i] = arr[minIdx];

                tr.addAccess(1);
                arr[minIdx] = tmp;

                tr.addSwap();
            }
        }
    }
}
