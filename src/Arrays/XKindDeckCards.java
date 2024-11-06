package Arrays;

import java.util.HashMap;
import java.util.Map;

public class XKindDeckCards {

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        int val = map.get(deck[0]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{ 1 }));
    }
}
