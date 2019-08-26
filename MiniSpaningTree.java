import java.util.List;

//MST在判斷是不是只剩下一個孤島的時候，也要記得加上等號，numOfIslands <= totalV-1，就可以通過‍‌‌‌‍‍‌‌‍‍‌‌‌‌‍‌‍‍最後一個test case
// Path compression is logV, total time complex is ElogV + ElogE, since E is at most V^2, so time complex is ElogV
public class MiniSpaningTree {
	public int calCost(List<Integer> cities, List<List<Integer>> roads, List<List<Integer>> costs) {
		UnionFind uf = new UnionFind(cities.size());
		int processed = 0;
		int cost = 0;
		for (List<Integer> road: roads) {
			if (uf.find(road.get(0)) != uf.find(road.get(1)) {
				uf.union(road.get(0), road.get(1));
				processed++;
			}
		}
		Arrays.sort(costs, new Comparator<List<Integer>>() {
			public int compare(List<Integer> a, List<Integer> b) {
				if (a.get(2) < b.get(2)) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		for (int i = 0; i < costs.size() && processed < cities.size() - 1; i++) {
			if (uf.find(costs.get(0)) != uf.find(costs.get(1))) {
				uf.union(costs.get(0), costs.get(1));
				processed++;
				cost += costs.get(2);
			}
		}
		return cost;
	}
	
	public static void main(String[] args) {
		List<Integer> cities = new Arrays.asList(1,2,3,4,5);
		List<List<Integer>> roads = new ArrayList<>();
		roads.add(new Arrays.asList(1, 2));
		List<List<Integer>> costs = new ArrayList<>();
		costs.add(new Arrays.asList(1, 3, 6));
		costs.add(new Arrays.asList(1, 4, 5));
		costs.add(new Arrays.asList(4, 3, 4));
		costs.add(new Arrays.asList(2, 4, 15));
		System.out.println(calCost(cities, roads, costs));
	}
	
	class UnionFind {
		int[] uf;
		public UnionFind(int n) {
			uf = new int[n];
		}
		public int find(int i) {
			int parent = i;
			if (uf[i] != i) {
				parent = find(uf[i]);
			}
			uf[i] = parent;
			return parent;
		}
		
		public union(int a, int b) {
			int pa = find(a);
			int pb = find(b);
			uf[pa] = pb;
		}
	}
}