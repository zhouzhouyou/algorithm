import edu.princeton.cs.algs4.StdRandom;
import sort.DataReader;
import sort.SortTool;
import sort.SortToolFactory;

public class SortTest {
    private static Integer[] dataSet = DataReader.getDataSet();
    private static Integer[] temp = new Integer[dataSet.length];
    private static void resetTestSet() {
        System.arraycopy(dataSet, 0, temp, 0, dataSet.length);
    }

    private static void show(SortTool sortTool) {
        sortTool.sortWithStatus(sortTool.getClass(), temp);
        System.out.println();
    }

    public static void main(String[] args) {
        StdRandom.shuffle(dataSet);
        SortToolFactory factory = new SortToolFactory();

        for (SortTool sortTool : factory.getSortTools()) {
            resetTestSet();
            show(sortTool);
        }
    }
}
