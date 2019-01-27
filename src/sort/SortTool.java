package sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class SortTool{
    /**
     * @param v v
     * @param w w
     * @return true if v is less than w; otherwise, false.
     */
    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (Comparable temp: a) {
            System.out.print(temp+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public abstract void sort(Comparable[] a);

    private String getName(Class t) {
        return t.getSimpleName() + " Sort";
    }

    @SuppressWarnings("unchecked")
    public void sortWithStatus(Class tool, Comparable[] a) {
        String name = getName(tool);
        try {
            Method method = tool.getDeclaredMethod("sort", Comparable[].class);
            System.out.println("======" + name + " start======");
            long startTime = System.currentTimeMillis();
            method.invoke(tool.newInstance(), (Object) a);
            long finishTime = System.currentTimeMillis();
            show(a);
            System.out.println(name + " runtime: " + (finishTime-startTime) + "ms");
            System.out.println("sorted: " + isSorted(a));
            System.out.println("======" + name + " end======");
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
