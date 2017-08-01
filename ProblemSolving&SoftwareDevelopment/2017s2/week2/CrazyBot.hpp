#pragma once
#include <iostream>

using namespace std;

class CrazyBot {
private:
	static const int arraySize = 30;
	bool accessed[arraySize][arraySize];
	double pn, ps, pe, pw; // probabilities

	double calc(int remain, double base, int x, int y)
	{
		if (remain == 0) return base;
		//cout << "x: " << x << "; y: " << y << endl;
		if (accessed[x][y]) return 0;
		accessed[x][y] = true;

		double sum = 0;
		sum += calc(remain - 1, base * pe, x + 1, y);
		sum += calc(remain - 1, base * pw, x - 1, y);
		sum += calc(remain - 1, base * ps, x, y - 1);
		sum += calc(remain - 1, base * pn, x, y + 1);
		accessed[x][y] = false;
		return sum;
	}

public:
	void main() {
		cout << getProbabilty(1, 25, 25, 25, 25) << endl;
		cout << getProbabilty(2, 25, 25, 25, 25) << endl;
		cout << getProbabilty(7, 50, 0, 0, 50) << endl;
		cout << getProbabilty(14, 50, 50, 0, 0) << endl;
		cout << getProbabilty(14, 25, 25, 25, 25) << endl;
	}

	double getProbabilty(int n, int east, int west, int south, int north)
	{
		// init vars
		for (int i = 0; i < arraySize; i ++)
			for (int j = 0; j < arraySize; j ++)
				accessed[i][j] = false;
		pn = north / 100.0;
		ps = south / 100.0;
		pe = east / 100.0;
		pw = west / 100.0;

		return calc(n + 1, 1.0, arraySize >> 1, arraySize >> 1);
	}
};
