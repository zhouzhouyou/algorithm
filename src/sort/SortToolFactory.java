package sort;

import java.util.HashMap;
import java.util.LinkedList;

public class SortToolFactory {
    private static HashMap<String, Class>toolMap = new HashMap<>();

    static {
        register(Insertion.class);
        register(Selection.class);
        register(Shell.class);
        register(Merge.class);
        register(MergeBU.class);
        register(Quick.class);
    }
    private static void register(String toolName, Class tool) {
        toolMap.put(toolName, tool);
    }

    private static void register(Class tool) {
        register(tool.getSimpleName(), tool);
    }

    public SortTool getSortTool(String toolName) {
        try {
            return (SortTool) toolMap.get(toolName).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SortTool[] getSortTools() {
        LinkedList<SortTool> tools = new LinkedList<>();
        for (String toolName: toolMap.keySet()) {
            SortTool tool = getSortTool(toolName);
            tools.add(tool);
        }
        SortTool[] sortTools = new SortTool[tools.size()];
        return tools.toArray(sortTools);
    }

}
