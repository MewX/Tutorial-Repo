#pragma once
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class ChristmassTree {
private:
	enum color { RED, FORGIVE, BLUE };

	int calcLength(int n) {
		int sum = n;
		while (n > 0) sum += -- n;
		return sum;
	}

	bool validate(const vector<color> &seq, const int &level) {
		int idxStart = 0, idxEnd = 0;
		for (int s = 1; s <= level && idxStart < seq.size(); s ++)
		{
			// if the last row is incomplete, keep it
			idxEnd = idxStart + s; // end exclusive
			if (idxEnd > static_cast<int>(seq.size())) break;

			int red = 0, forgive = 0, blue = 0;
			for (int i = idxStart; i < idxEnd; i++) {
				if (seq[i] == RED) red++;
				if (seq[i] == FORGIVE) forgive++;
				if (seq[i] == BLUE) blue++;
			}

			if (red == 0) {
				if (forgive != 0 && blue != 0 && forgive != blue)
					return false;
			} else if (blue == 0) {
				if (red != 0 && forgive != 0 && red != forgive)
					return false;
			} else if (forgive == 0) {
				if (red != 0 && blue != 0 && red != blue)
					return false;
			} else if (red != blue || blue != forgive) {
				return false;
			}

			idxStart = idxEnd;
		}
		return true;
	}

	int buildAll(vector<color> &seq, int red, int forgive, int blue, const int &level, const int length)
	{
		if (!validate(seq, level)) return 0;
		else if (seq.size() == length) return 1;

		// trying other cases
		int sum = 0;
		if (red != 0) {
			seq.push_back(RED);
			sum += buildAll(seq, red - 1, forgive, blue, level, length);
			seq.pop_back();
		}
		if (forgive != 0) {
			seq.push_back(FORGIVE);
			sum += buildAll(seq, red, forgive - 1, blue, level, length);
			seq.pop_back();
		}
		if (blue != 0) {
			seq.push_back(BLUE);
			sum += buildAll(seq, red, forgive, blue - 1, level, length);
			seq.pop_back();
		}
		return sum;
	}

public:
	void main() {
		cout << decorationWays(2, 1, 1, 1) << endl;
		cout << decorationWays(2, 2, 1, 0) << endl;
		cout << decorationWays(3, 2, 2, 1) << endl;
		cout << decorationWays(3, 2, 2, 2) << endl;
		cout << decorationWays(8, 1, 15, 20) << endl;
	}

	long decorationWays(int N, int red, int forgive, int blue) {
		if (N == 1 && (red > 0 || forgive > 0 || blue > 0)) return 1;

		const int len = calcLength(N);
		if (len > red + forgive + blue) return 0; // impossbile
		vector<color> sequence;
		int count = buildAll(sequence, red, forgive, blue, N, len);
		return count;
	}
};
