import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, l, answer;

	public static void way(int[][] board) {
		boolean[][] check = new boolean[n][n];
		for (int row = 0; row < n; row++) {
			boolean flag = true;
			for (int i = 0; i < n - 1; i++) {
				if (board[row][i] != board[row][i + 1]) {
					// 내려가는 경사로
					if (board[row][i] - board[row][i + 1] == 1) {
						int k = i + 1;
						int floor = board[row][k];
						while (k < n && board[row][k] == floor && k - (i + 1) < l && !check[row][k]) {
							check[row][k] = true;
							k++;
						}
						if (k - (i + 1) < l) {
							flag = false;
							break;
						}
					}
					// 올라가는 경사로
					else if (board[row][i] - board[row][i + 1] == -1) {
						int k = i;
						int floor = board[row][k];
						while (k >= 0 && board[row][k] == floor && i - k < l && !check[row][k]) {
							check[row][k] = true;
							k--;
						}
						if (i - k < l) {
							flag = false;
							break;
						}
					} else {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				answer++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
		int[][] board1 = new int[n][n];
		int[][] board2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board1[i][j] = Integer.parseInt(st.nextToken());
				board2[j][i] = board1[i][j];
			}
		}
		way(board1);
		way(board2);
		System.out.println(answer);
	}
}
