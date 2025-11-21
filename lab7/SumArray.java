import java.util.Arrays;
import java.util.concurrent.*;

public class SumArray {

    static class ArrayTask implements Callable<Integer> {
        private final int[] arr;
        private final int start;
        private final int end;

        public ArrayTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {

        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int chunkSize = array.length / numThreads;
        Future<Integer>[] results = new Future[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? array.length : start + chunkSize;

            results[i] = executor.submit(new ArrayTask(array, start, end));
        }

        executor.shutdown();

        int total = 0;
        try {
            for (Future<Integer> f : results) {
                total += f.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Total sum = " + total);
    }
}
