import java.util.Deque;
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
public class Maze {
	//optin 1
	public static Integer BFS_FindObstacle(Character[][] grid){
        if (grid.length == 0 || grid[0].length==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] distance = new int[rows*cols+cols]; //[] size row*cols+cols
        LinkedList<Integer> queue = new LinkedList<>();
        int[] dirX = {1,0,-1,0};
        int[] dirY = {0,1,0,-1};
        queue.offer(0); //put grid[0][0] location to queue
        distance[0]=0; // here we can use 1d array just like we store queue (use x*cols+y) as index
        while(!queue.isEmpty()){
            int current = queue.poll();
            //traverse all neighbor
            for(int i = 0; i< 4; i++){
                int x = current/cols+dirX[i]; //0 +1
                int y = current%cols+dirY[i]; //0
                
                //check if neighbors is traversable (not out of border) and not visited
                if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y] =='0') continue;
                int neighbor = x*cols+y;
                distance[neighbor] = distance[current]+1; //distance [current] +1
                if(grid[x][y]=='9') return distance[neighbor];

                queue.offer(neighbor); // 1*3+0 =3
                grid[x][y] = '0'; //marked as visited
            }

        }
        return -1;
    }
	
	public static int getStep(Character[][] grid) {
		if (grid.length == 0 || grid[0].length==0) return 0;
		int[][] visited = new int[grid.length][grid[0].length];
		Queue<Integer> que = new LinkedList<>();
		int cols = grid[0].length;
		que.offer(covertIndexToNum(0, 0, cols));
		int[] dirX = new int[]{1, 0, -1, 0};
		int[] dirY = new int[] {0, 1, 0, -1};
		while (!que.isEmpty()) {
			
			int cur = que.poll();
			int[] index = covertNumToIndex(cur, cols);
			for (int i = 0; i < dirX.length; i++) {
				int x = index[0] + dirX[i];
				int y = index[1] + dirY[i];
				if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
					continue;
				}
				visited[x][y] = visited[index[0]][index[1]] + 1;
				
				if(grid[x][y]=='9') return visited[x][y];
				int next = covertIndexToNum(x, y, cols);
				que.offer(next);
				grid[x][y] = '0';
				
			}
		}
		return -1;
	}
	
	public static int covertIndexToNum(int i, int j, int len) {
		return i * len + j;
	}
	
	public static int[] covertNumToIndex(int num, int len) {
		int[] res = new int[2];
		res[0] = num / len;
		res[1] = num % len;
		return res;
	}
}