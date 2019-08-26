public class TwoSum {
	//2sum這題要求找出最大的package size，一開始我設定if(packageSize > max)時只能通過18個test case，把條件改成>=以後就通過第19個case了
	public int[] findTwoSum(int[] arrays, int duration) {
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
}