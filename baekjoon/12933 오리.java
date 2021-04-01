import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cry = 0, uncry = 0;
		String quack = "quack";
		List<String> duck = new ArrayList<String>();
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (duck.isEmpty() && str.charAt(i) != 'q') {
				flag = true;
				break;
			} else {
				if (str.charAt(i) == 'q') {
					if (uncry > 0)
						uncry--;
					cry++;
					duck.add("q");
				} else if (str.charAt(i) == 'k') {
					for (int j = 0; j < duck.size(); j++) {
						if (duck.get(j).length() == 4) {
							duck.remove(j);
							cry--;
							uncry++;
							flag = true;
							break;
						}
					}
					flag = !flag;
					if (flag)
						break;
				} else {
					for (int j = 0; j < duck.size(); j++) {
						int index = duck.get(j).length();
						if (quack.charAt(index) == str.charAt(i)) {
							duck.set(j, duck.get(j) + str.charAt(i));
							flag = true;
							break;
						}
					}
					flag = !flag;
					if (flag)
						break;
				}
			}
		}
		if (!duck.isEmpty())
			flag = true;
		if (flag)
			System.out.println(-1);
		else
			System.out.println(cry + uncry);
	}
}
