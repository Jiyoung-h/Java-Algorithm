import java.util.*;

class Pair {
	String x;
	int y;

	public Pair(String x, int y) {
		this.y = y;
		this.x = x;
	}
}

public class Main {

	public static int dx[] = { 0, 1, 0, -1 };
	public static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		List<Pair> oper = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int a = sc.nextInt();
			oper.add(new Pair(str, a));
		}

		int x = 0;
		int y = 0;
		int d = 0;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			if (oper.get(i).x.equals("MOVE")) {
				int nx = x + dx[d] * oper.get(i).y;
				int ny = y + dy[d] * oper.get(i).y;
				if (nx <= m && ny <= m && nx >= 0 && ny >= 0) {
					x = nx;
					y = ny;
				} else {
					flag = true;
					break;
				}
			} else {
				if (oper.get(i).y == 0) {
					d++;
					if (d > 3)
						d -= 4;
				} else {
					d--;
					if (d < 0)
						d += 4;
				}
			}
		}
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(y + " " + x);
		}
	}

}
