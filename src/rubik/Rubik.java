package rubik;

import java.util.TreeMap;


public class Rubik implements Comparable<Rubik>{
	
	private Rubik parent = null;
	private int n;
	private char[][][] faces = new char[6][][];
	private char[] colors = new char[6];
	
	public Rubik(String cols, int n) {
		this.n = n;
		for (int f = 0; f < 6; f++) {
			colors[f] = cols.charAt(f % 6);
			faces[f] = new char[n][];
			for (int r = 0; r < n; r++) {
				faces[f][r] = new char[n];
				for (int c = 0; c < n; c++)
					faces[f][r][c] = colors[f];
			} // for
		} // for 
	} // State(String, int)
	
	public Rubik(Rubik old) {
		this.n = old.n;
		this.parent = old;
		for (int f = 0; f < 6; f++) {
			colors = old.colors;
			faces[f] = new char[n][];
			for (int r = 0; r < n; r++) {
				faces[f][r] = new char[n];
				for (int c = 0; c < n; c++)
					faces[f][r][c] = old.faces[f][r][c];
			} // for
		} // for
	} // State(State)
	
	public Rubik(String col, int n, String s) {
		this.n = n;
		int i = 0;
		for (int f = 0; f < 6; f++) {
			colors[f] = col.charAt(f);
			faces[f] = new char[n][];
			for (int r = 0; r < n; r++) {
				faces[f][r] = new char[n];
			} // for
		} // for
		for (int r = 0; r < n; r++) // top face
			for (int c = 0; c < n; c++)
				faces[0][r][c] = s.charAt(i++);
		for (int r = 0; r < n; r++) // lateral faces, 1 to 4
			for (int f = 1; f < 5; f++) 
				for (int c = 0; c < n; c++)
					faces[f][r][c] = s.charAt(i++);
		for (int r = 0; r < n; r++) // bottom face.
			for (int c = 0; c < n; c++)
				faces[5][r][c] = s.charAt(i++);
	} // State(String, int, String)
	
	private static void space(StringBuffer b, int n) {
		b.append("  ");
		for (int i = 0; i < n; i++)
			b.append("  ");
	}
	
	private static void line(StringBuffer b, int n) {
		b.append("+-");
		for (int i = 0; i < n; i++)
			b.append("--");
	}
	
	private void row(StringBuffer b, int f, int r) {
		b.append("| ");
		for (int k = 0; k < n; k++)
			b.append(faces[f][r][k] + " ");
	}
	
	private static void line4(StringBuffer b, int n) {
		line(b, n); line(b, n); line(b, n); line(b, n); b.append("+\n");
	}
	
	@Override
	public int compareTo(Rubik o) {
		int res = 0;
		int f = 0, x = 0, y = 0;
		for (f = 0; f < 6; f++)
			for (x = 0; x < n; x++)
				for (y = 0; y < n; y++)
					if (faces[f][x][y] != o.faces[f][x][y])
						res++;
		return res;
	}
	
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		space(b, n); line(b, n); b.append("+\n");
		for (int j = 0; j < n; j++) {
			space(b, n); row(b, 0, j); b.append("|\n");
		}
		line4(b, n);
		for (int j = 0; j < n; j++) {
			for (int f = 1; f < 5; f++)
				row(b, f, j);
			b.append("|\n");
		}
		line4(b, n);
		for (int j = 0; j < n; j++) {
			space(b, n); space(b, n); row(b, 5, j); b.append(("|\n"));
		}
		space(b, n); space(b, n); line(b, n); b.append("+\n");
		return b.toString();
	} // toString()
	
	public static void main(String[] args) {
		Rubik c = new Rubik("WOGRBY", 5,
				  "OWYYR" +
				  "WWYGG" +
				  "YWWWB" + 
				  "GWBYO" +
				  "GGBRW" +
		"BRRWR" + "WOWBO" + "GBYYB" + "WOGBW" + 
	    "GRGRG" + "OOWGB" + "ROOBW" + "RYOWR" +
		"RGOBW" + "GRGGW" + "OWRGO" + "YYBRW" + 
	    "YOROB" + "OYORY" + "BBYRW" + "OGBBB" + 
		"YROWB" + "OROYY" + "RGGWG" + "YWRRR" +
	                        "BYRGO" +
		                    "OBBWB" +
	                        "BYYOB" +
		                    "GYRGY" +
	                        "YOGYG");
		System.out.print(c);
		System.out.print(new Rubik("WOGRBY", 5));
		System.out.println("c.comparesTo(new Rubik(5)) == " + c.compareTo(new Rubik("WOGRBY", 5)));
		System.out.println("new Rubik(\"WOGRBY\").compareTo(new Rubik(\"WOGRBY\", 5) == " +
				new Rubik("WOGRBY", 5).compareTo(new Rubik("WOGRBY", 5)));
	} // main(String[])

} // publilc class State
