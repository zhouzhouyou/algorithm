package sort;

public class Merge extends MergeTool{
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        sort(a, 0, length-1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int mid = (low + high) / 2;
        sort(a, low, mid);
        sort(a, mid+1, high);
        merge(a, low, mid, high);
    }


}
