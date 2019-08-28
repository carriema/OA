import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
public class TwoSum {
	//2sum這題要求找出最大的package size，一開始我設定if(packageSize > max)時只能通過18個test case，把條件改成>=以後就通過第19個case了
	// corner歌曲数小于2， ride duration 小于1
	public int[] findTwoSum(int[] arrays, int duration) {
		if (arrays.length < 1) {
			return new int[2];
		}
		int minDiff = Integer.MAX_VALUE;
		int[] res = new int[2];
		for (int i = 0; i < arrays.length - 1; i++) {
			for (int j = i + 1; j < arrays.length; j++) {
				if (duration - (arrays[i] + arrays[j]) < minDiff && (arrays[i] + arrays[j]) <= duration) {
					res[0] = i;
					res[1] = j;
					minDiff = Math.min(minDiff, duration - (arrays[i] + arrays[j]));
				} else if (minDiff == (arrays[i] + arrays[j])) {
					if (Math.max(arrays[res[0]], arrays[res[1]]) < Math.max(arrays[i], arrays[j])) {
						res[0] = i;
						res[1] = j;
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arrays = new int[]{12, 40, 25, 25, 10};
		TwoSum ts = new TwoSum();
		int[] res = ts.findTwoSum(arrays, 60);
		System.out.println(res[0] + " " + res[1]);
	}
	
	// with index and max
	public int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i]) && max < Math.max(numbers[i], target-numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
}