package Chapter03;
// 3.3 스택의 응용 
// 3.3 미로 찾기 게임 
import java.util.Stack;

class Position {
	public int x;
	public int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

public class Maze {

	private static int[][] maze = { 
		{ 0, 1, 1, 1, 1, 1, 0, 0 }, 
		{ 0, 0, 0, 1, 0, 1, 0, 1 }, 
		{ 0, 1, 0, 1, 0, 1, 1, 1 },
		{ 0, 1, 0, 1, 0, 0, 0, 0 }, 
		{ 0, 1, 1, 1, 0, 1, 0, 1 }, 
		{ 0, 1, 0, 0, 0, 1, 0, 1 },
		{ 0, 1, 0, 1, 1, 1, 0, 0 }, 
		{ 0, 0, 0, 0, 1, 1, 0, 0 } 
	};

	private static Stack<Position> stk = new Stack<>();

	private static boolean findPath() {
		int[][] dxy = { 
			{ 0, 1 }, 
			{ 0, -1 }, 
			{ 1, 0 }, 
			{ -1, 0 } 
		};

		int[][] grid = new int[maze.length + 2][maze[0].length + 2];
		for (int k = 0; k < grid.length; k++) {
			grid[k][0] = grid[k][grid[0].length - 1] = 1;		// 왼쪽과 오른쪽 벽 
		}
		for (int k = 0; k < grid[0].length; k++) {
			grid[0][k] = grid[grid.length - 1][k] = 1;			// 위와 아래 벽 
		}

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; ++j) {
				grid[1 + i][1 + j] = maze[i][j];
			}
		}

		int x = 1, y = 1;	// 출발점 
		int destX = grid.length - 2, destY = grid[0].length - 2;	// 목적지 
		int dir = 0;		// 오른쪽부터 찾아봄 

		for (;;) {
			if (x == destX && y == destY) {
				stk.push(new Position(x, y));
				return true;	// 목적지에 도착함 
			}

			grid[x][y] = 2;		// visited 

			int nx = 0, ny = 0;
			for (int i = 0; i < 4; i++) {
				nx = x + dxy[(dir + i) % 4][0];
				ny = y + dxy[(dir + i) % 4][1];
				if (grid[nx][ny] == 0) {
					break;
				}
			}
			if (grid[nx][ny] == 0) {
				stk.push(new Position(x, y));
				x = nx;
				y = ny;
			} else {
				if (stk.empty()) {
					return false;	// 더이상 가볼 곳이 없음 
				}
				Position p = stk.pop();
				x = p.x;
				y = p.y;
				dir = (dir + 1) % 4;	// 찾아보는 방향을 바꿈 
			}
		}
	}

	public static void main(String[] args) {
		boolean res = findPath();
		if (res == true) {
			System.out.println("The Path is as Follow : ");
			System.out.print(stk.pop().toString());
			while (!stk.empty()) {
				System.out.print(" <- " + stk.pop().toString());
			}
		} else {
			System.out.println("Could not find any Path");
		}
	}
}
