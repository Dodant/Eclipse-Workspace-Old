package Chapter02;
// 2.9 트로미노 문제 
import java.util.Scanner;

public class Tromino {
	static int[][] grid;
	static int currentNum;
	
	static void tromino(int size, int x, int y) {
		grid = new int[size][size];
		grid[x][y] = -1;
		currentNum = 1;
		
		tileRec(size, 0, 0);
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	static void tileRec(int size, int topX, int topY) {
		if(size == 2) {
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					if(grid[topX+i][topY+j] != 0) {
						continue;
					}
					grid[topX+i][topY+j] = currentNum;
				}
			}
			currentNum++;
			return;
		}
		int holeX = topX;
		int holeY = topY;
		
		OUTER:
		for(; holeX < topX + size; holeX++) {
			holeY = topY;
			for(; holeY < topY + size; holeY++) {
				if(grid[holeX][holeY] != 0) {
					break OUTER;
				}
			}
		}
		int hsize = size / 2;
		
		if(!(holeX < topX + hsize && holeY < topY + hsize)) 	grid[topX+hsize-1][topY+hsize-1] = currentNum;
		if(!(holeX >= topX + hsize && holeY < topY + hsize)) 	grid[topX+hsize][topY+hsize-1] = currentNum;
		if(!(holeX < topX + hsize && holeY > topY + hsize)) 	grid[topX+hsize-1][topY+hsize] = currentNum;
		if(!(holeX >= topX + hsize && holeY >= topY + hsize)) 	grid[topX+hsize][topY+hsize] = currentNum;
		currentNum++;
		
		tileRec(hsize, topX, topY);
		tileRec(hsize, topX+hsize, topY);
		tileRec(hsize, topX, topY+hsize);
		tileRec(hsize, topX+hsize, topY+hsize);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Size : ");
		int size = sc.nextInt();
		
		System.out.print("Enter x and y coordinata of hole : ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		tromino(size, x, y);
	}
}
