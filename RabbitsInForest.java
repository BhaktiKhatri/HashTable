package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

	public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        System.out.println(Arrays.toString(answers));
        
        for(int i: answers) { 
        	System.out.println("i: "+i+" map: "+map);
        	map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        System.out.println("map: "+map);
        
        for(int i: map.keySet()) {
        	System.out.println("i: "+i+" map.get(i): "+map.get(i)+" res: "+res+" res + (map.get(i) + i): "+(res + map.get(i) + i)+" (i + 1) * (i + 1): "+((i + 1) * (i + 1))+" (res + map.get(i) + i)/ (i + 1) * (i + 1): "+((res + map.get(i) + i)/ (i + 1) * (i + 1)));
        	res = res + (map.get(i) + i) / (i + 1) * (i + 1);
        }
        
        System.out.println("res: "+res);
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] answers = {10, 10, 10, 10, 10};
		System.out.println(numRabbits(answers));
	}

}
