package sort;

public abstract class MergeTool extends SortTool{
    /**
     * merge two sorted array
     * @param a array to merge with
     * @param low index of the left array
     * @param mid end of the left array
     * @param high end of the right array
     */
    void merge(Comparable[] a, int low, int mid, int high) {
        int i = low; //左数组下一个要进行比较的元素的索引
        int j = mid + 1; //右数组下一个要进行比较的元素的索引
        int N = high + 1; //本次归并的元素数目
        Comparable[] tmpArray = new Comparable[N]; //用于暂时存放比较后的元素
        for (int k = low; k <= high; k++) {
            if (i > mid) {  //左数组元素已全比较完
                tmpArray[k] = a[j++];
            } else if (j > high) { //右数组元素已全比较完
                tmpArray[k] = a[i++];
            } else if (less(a[j], a[i])) { //右数组元素小于左数组
                tmpArray[k] = a[j++];
            } else {  //右数组元素大于等于左数组
                tmpArray[k] = a[i++];
            }
        }
        if (N - low >= 0) System.arraycopy(tmpArray, low, a, low, N - low);
    }
}
