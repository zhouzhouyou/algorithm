package sort;

public class Shell extends SortTool{
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        while (h < length/3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    exchange(a, j, j-h); //对于一个h数组，从最后一个开始向前插入
                }
            }
            h/=3;
        }
    }
}
