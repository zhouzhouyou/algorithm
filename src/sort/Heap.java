package sort;


public class Heap extends SortTool {
    /**
     * adjust a[k] to a proper location
     * @param a array to sort
     * @param i index to adjust
     * @param N size of the array
     */
    private void adjust(Comparable[] a, int i, int N) {
        Comparable temp = a[i];
        for (int k = 2 * i + 1; k < N; k = 2 * k + 1) {
            /*
            k means the left node of i
            if k >= N, then i doesn't have left node, as well as right node
            stop when reach the end
             */
            if (k + 1 < N && less(a[k], a[k+1]))
                k++;    //point to the bigger one
            if (less(temp, a[k])) {
                a[i] = a[k];
                i = k;
            } else {
                break;
            }
        }
        a[i] = temp;
    }


    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        /*
        step 1: build a heap by adjust items which is not leaf
         */
        for (int i = N/2-1; i >= 0; i--)
            adjust(a, i, N-1);
        for (int j = N-1; j>0; j--) {
            exchange(a, 0, j);
            adjust(a, 0, j);
        }

    }
}
