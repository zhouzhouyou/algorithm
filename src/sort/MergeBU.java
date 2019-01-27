package sort;

public class MergeBU extends MergeTool {
    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        aux = new Comparable[length];
        for (int size = 1; size < length; size+=size) {
            for (int low = 0; low < length - size; low += size + size) {
                merge(a, low, low + size - 1, Math.min(low + size + size - 1, length - 1));
            }
        }
    }
}
