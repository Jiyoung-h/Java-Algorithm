import java.util.*;
public class Main {
	static int[][] c;
	static int n;

	static int solution(int index, ArrayList<Integer> start, ArrayList<Integer> link) {
		if (index == n) {
			if (start.size() != n / 2 || link.size() != n / 2)
				return -1;
			int sPower = 0;
			int lPower = 0;
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < n / 2; j++) {
					if (i == j)
						continue;
					sPower += c[start.get(i)][start.get(j)];
					lPower += c[link.get(i)][link.get(j)];
				}
			}
			int diff = Math.abs(sPower - lPower);
			return diff;
		}
		if (start.size() > n / 2 || link.size() > n / 2)
			return -1;
		int result = -1;
		start.add(index);
		int ans1 = solution(index + 1, start, link);
		start.remove(start.size() - 1);
		if (result == -1 || (ans1 != -1 && result > ans1)) {
			result = ans1;
		}

		link.add(index);
		int ans2 = solution(index + 1, start, link);
		link.remove(link.size() - 1);
		if (result == -1 || (ans2 != -1 && result > ans2)) {
			result = ans2;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		c = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = sc.nextInt();
			}
		}
		ArrayList<Integer> start = new ArrayList<>();
		ArrayList<Integer> link = new ArrayList<>();
		int answer = solution(0, start, link);
		
		System.out.println(answer);
	}
}
