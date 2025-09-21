package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class DesignSpreadSheet3484 {

    Map<String, Integer> cellValueMap;

    public DesignSpreadSheet3484(int rows) {
        cellValueMap = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        cellValueMap.put(cell, value);
    }

    public void resetCell(String cell) {
        cellValueMap.put(cell, 0);
    }

    public int getValue(String formula) {
        String[] arr = formula.substring(1).split("\\+");
        return getCell(arr[0]) + getCell(arr[1]);
    }

    private int getCell(String cell) {
        return (cell.charAt(0) >= '0' && cell.charAt(0) <= '9') ?
                Integer.parseInt(cell) :
                cellValueMap.getOrDefault(cell, 0);
    }

    public static void main(String[] args) {
        DesignSpreadSheet3484 spreadSheet = new DesignSpreadSheet3484(3);
        System.out.println(spreadSheet.getValue("=5+7"));
        spreadSheet.setCell("A1", 10);
        System.out.println(spreadSheet.getValue("=A1+6"));
        spreadSheet.setCell("B2", 15);
        System.out.println(spreadSheet.getValue("=A1+B2"));
        spreadSheet.resetCell("A1");
        System.out.println(spreadSheet.getValue("=A1+B2"));
    }
}
