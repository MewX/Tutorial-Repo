
public class RockStar {
	
	public static void main(String[] args) {
		// ff, fs, sf, ss
		// System.out.println(new RockStar().getNumSongs(100, 0, 0, 200));
		// System.out.println(new RockStar().getNumSongs(0, 0, 20, 200));
		// System.out.println(new RockStar().getNumSongs(1, 2, 1, 1));
		// System.out.println(new RockStar().getNumSongs(192, 279, 971, 249));
		// System.out.println(new RockStar().getNumSongs(1, 0, 1, 1));
		// System.out.println(new RockStar().getNumSongs(1000, 1000, 1000, 1000));
		System.out.println(new RockStar().getNumSongs(0, 0, 20, 200));
		System.out.println(new RockStar().getNumSongs(1, 2, 1, 1));
		System.out.println(new RockStar().getNumSongs(1, 0, 1, 1));
	}

	// using graph idea
	private int longest = 0;

	public int getNumSongsDFS(int ff, int fs, int sf, int ss) {
		return dfs(ff, fs, sf, ss, 0, -1); // last id doesn't matter
	}

	/**
	 * ff: ff remaining (1)
	 * fs: fs remaining (2)
	 * sf: sf remaining (3)
	 * ss: ss remaining (4)
	 * sum: current sum
	 */
	private int dfs(int ff, int fs, int sf, int ss, int sum, int lastId) {
		if (sum == 0) {
			if (ff != 0) return dfs(ff - 1, fs, sf, ss, sum + 1, 1);
			else if (fs != 0) return dfs(ff, fs - 1, sf, ss, num + 1, 2);
			else Math.max(dfs(ff, fs, sf - 1, ss, sum + 1, 3), dfs(ff, fs, sf, ss - 1, sum + 1, 4));
		} else {
			switch (lastId) {
			case 1:
				return Math.max(dfs(ff - 1))
				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;
			}
		}

	}

	// greedy
	public int getNumSongs(int ff, int fs, int sf, int ss) {
		// rule 3
		int max = 0;
		if (ff > 0 || fs > 0) {
			// follow the rule 3, start from fast
			max = ff;
			if (fs > 0) {
				// able to link `fs` and `ss`
				final int common = Integer.min(fs, sf);
				max += (common << 1);
				fs -= common;
				sf -= common;
				if (fs == 0) {
					max = max - 1 + ss + 1; // remove one `sf` to make the last one is `fs`; also, it ensures that `sf > 0`, so add one for the last
				} else if (sf == 0) {
					max += 1 + ss; // because `fs > 0`, select one `fs` for linking to `ss`s
				}
			}
		} else {
			// start from slow
			max = ss + (sf > 0 ? 1 : 0);
		}
		return max;
	}
}
