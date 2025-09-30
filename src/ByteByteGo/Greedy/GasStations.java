package ByteByteGo.Greedy;

import java.util.Arrays;

public class GasStations {

    public static int gasStation(int[] gas, int[] costs) {
        if (Arrays.stream(gas).sum() < Arrays.stream(costs).sum()) {
            return -1;
        }
        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
           tank += gas[i] - costs[i];

           if (tank < 0) {
               start = i + 1;
               tank = 0;
           }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(gasStation(new int[] { 2, 5, 1, 3 }, new int[] { 3, 2, 1, 4 }));
        System.out.println(gasStation(new int[] { 3, 2, 1, 3, 3, 2, 3, 4 }, new int[] { 2, 1, 4, 1, 2, 6, 0, 3 }));
    }
}
