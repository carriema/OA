import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class TwoSumCloset {
	// Try to find if one list is not exists
	public int getCloset(List<List<Integer>> list1, List<List<Integer>> list2, int target) {
		OrderListComparator c = new OrderListComparator();
		Collections.sort(list1, c);
		Collections.sort(list2, c);
		
		int index1 = 0;
		int index2 = list2.size() - 1;
		int cur = -1;
		while (index1 < list1.size() && index2 >= 0) {
			int sum = list1.get(index1).get(1) + list2.get(index2).get(1);
			if (sum > cur && sum <= target) {
				cur = sum;
			}
			if (sum > target) {
				index2--;
			} else {
				index1++;
			}
		}
		return cur;
	}
	
	public static void main(String[] args) {
		test t = new test();
		List<List<Integer>> l1 = new ArrayList<>();
		l1.add(Arrays.asList(0, 4));
		l1.add(Arrays.asList(1, 3));
		List<List<Integer>> l2 = new ArrayList<>();
		l1.add(Arrays.asList(0, 7));
		l1.add(Arrays.asList(1, 1));
		l1.add(Arrays.asList(2, 3));
		System.out.println(t.getCloset(l1, l2, 7));
	}
}

class OrderListComparator implements Comparator<List<Integer>> {
	public int compare(List<Integer> l1, List<Integer> l2) {
		if (l1.get(1) < l2.get(1)) {
			return -1;
		} else {
			return 1;
		}
	}
}
