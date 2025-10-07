package cli;

import algorithms.SelectionSort;
import metrics.Tracker;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Bench {
    public static void main(String[] args) throws Exception {
        int n = 1000;
        int runs = 10;
        String distribution = "random";
        String out = "docs/perf.csv";
        int warmups = 5;
        long seed = 12345L;

        for (String s : args) {
            if (s.startsWith("n=")) n = Integer.parseInt(s.substring(2));
            else if (s.startsWith("runs=")) runs = Integer.parseInt(s.substring(5));
            else if (s.startsWith("distribution=")) distribution = s.substring(13);
            else if (s.startsWith("out=")) out = s.substring(4);
            else if (s.startsWith("warmups=")) warmups = Integer.parseInt(s.substring(8));
            else if (s.startsWith("seed=")) seed = Long.parseLong(s.substring(5));
        }

        File f = new File(out);
        if (f.getParentFile() != null) f.getParentFile().mkdirs();
        boolean writeHeader = !f.exists() || f.length() == 0;

        try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))) {
            if (writeHeader) {
                pw.println("algorithm,n,distribution,run,wall_ns,comparisons,swaps,array_accesses,timestamp,seed");
            }

            Random rnd = new Random(seed);
            for (int run = 1; run <= runs; run++) {
                int[] orig = gen(n, distribution, rnd);

                for (int w = 0; w < warmups; w++) {
                    int[] tmp = Arrays.copyOf(orig, orig.length);
                    SelectionSort.sort(tmp, new Tracker());
                }

                int[] a = Arrays.copyOf(orig, orig.length);
                Tracker t = new Tracker();

                long start = System.nanoTime();
                SelectionSort.sort(a, t);
                long end = System.nanoTime();

                long wall = end - start;
                String row = String.format("SelectionSort,%d,%s,%d,%d,%d,%d,%d,%s,%d",
                        n, distribution, run, wall, t.getComp(), t.getSwap(), t.getAcc(), Instant.now().toString(), seed);
                pw.println(row);
                pw.flush();
                System.out.println("run " + run + " done, time(ns)=" + wall);
            }
        }

        System.out.println("All done. CSV -> " + out);
    }

    private static int[] gen(int n, String distribution, Random rnd) {
        int[] a = new int[n];
        switch (distribution.toLowerCase()) {
            case "sorted":
                for (int i = 0; i < n; i++) a[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < n; i++) a[i] = n - i;
                break;
            case "nearly-sorted":
                for (int i = 0; i < n; i++) a[i] = i;
                int swaps = Math.max(1, n / 20);
                for (int s = 0; s < swaps; s++) {
                    int i = rnd.nextInt(n);
                    int j = rnd.nextInt(n);
                    int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
                }
                break;
            default:
                for (int i = 0; i < n; i++) a[i] = rnd.nextInt(n * 10 + 1);
                break;
        }
        return a;
    }
}