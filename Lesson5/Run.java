package Lesson5;

public class Run {
    private static final int SIZE = 1000000;
    private static final int H = SIZE / 2;

    public float[] calc(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    public void thread1() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.3f;
        }
        long a = System.currentTimeMillis();
        calc(arr);
        System.out.println("Время отработки первого варианта: " + (System.currentTimeMillis() - a));
    }

    public void thread2() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);
        System.out.println("Время разбивки: " + (System.currentTimeMillis() - a));
        long b = System.currentTimeMillis();
        new Thread(() -> {
            //public void run() {
            float[] c1 = calc(arr1);
            System.arraycopy(c1, 0, arr1, 0, c1.length);
            //}
        });
        System.out.println("Время подсчета 1: " + (System.currentTimeMillis() - b));
        long d = System.currentTimeMillis();
        new Thread(() -> {
            float[] c2 = calc(arr1);
            System.arraycopy(c2, 0, arr1, 0, c2.length);
        });
        System.out.println("Время подсчета 2: " + (System.currentTimeMillis() - d));
        long f = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);
        System.out.println("Время склейки: " + (System.currentTimeMillis() - f));
    }

    public static void main(String args[]) {
        Run r = new Run();
        r.thread1();
        r.thread2();
    }
}
