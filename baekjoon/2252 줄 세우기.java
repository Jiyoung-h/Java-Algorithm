import java.util.*;

public class Main {

	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[] adj = new int[n + 1];
		List<List<Integer>> node = new ArrayList<List<Integer>>();
		for (int i = 0; i < n + 1; i++)
			node.add(new ArrayList<Integer>());
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[b]++;
			node.get(a).add(b);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (adj[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int front = q.peek();
			q.remove();
			System.out.println(front + " ");
			for (int i = 0; i < node.get(front).size(); i++) {
				int next = node.get(front).get(i);
				adj[next]--;
				if (adj[next] == 0)
					q.add(next);
			}
		}
	}
}
