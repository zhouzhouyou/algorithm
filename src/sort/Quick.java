package sort;

public class Quick extends SortTool {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }
}
