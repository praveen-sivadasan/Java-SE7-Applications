package actors;

public class Test {

	public static void main(String[] args) {
		String line = "   d     d";
		/*Integer count = 0;
		int i = 1;
		for (i = 1; i < line.length(); i++) {
			if (line.charAt(i) == ' ' && line.charAt(i - 1) != ' ') {
				count++;
			}
		}
		if (count > 0 && (line.length() != 0 && line.charAt(line.length() - 1) != ' '))
			++count;*/
		
		String[] list = line.split(" ");
		System.out.println(list.length);
		
		//System.out.println(count);
		
	}

}
