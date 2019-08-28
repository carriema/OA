import java.util.PriorityQueue;

public class MergeFiles {
	public int mergeFiles(int[] fileSize) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < fileSize.length; i++) {
			pq.offer(fileSize[i]);
		}
		int result = 0;
		while (!pq.isEmpty() && pq.size() > 1) {
			int res1 = pq.poll();
			int res2 = pq.poll();
			int finalRes = res1 + res2;
			result += finalRes;
			pq.offer(finalRes);
		}
		return pq.peek();
	}
}