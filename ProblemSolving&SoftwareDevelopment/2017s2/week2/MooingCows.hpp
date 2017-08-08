#pragma once
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class MooingCows {
public:
	void main() {
		vector<string> test = { "C..", ".C.", ".C." };
		cout << dissatisfaction(test) << endl;

		test = { "CCCC", "CCCC", "CCCC" };
		cout << dissatisfaction(test) << endl;

		test = { "C" };
		cout << dissatisfaction(test) << endl;

		test = { "CCC....", "C......", "....C.C", ".C.CC..", "C......" };
		cout << dissatisfaction(test) << endl;
	}

	int dissatisfaction(vector<string> farmland) {
		int minDiss = INT32_MAX;
		for (int mx = 0; mx < farmland.size(); mx++) {
			const string &mc = farmland[mx];
			for (int my = 0; my < mc.length(); my++) {
				if (mc[my] == 'C') {
					// sum all dissatisfactions
					int sum = 0;
					for (int cx = 0; cx < farmland.size(); cx++) {
						const string &cc = farmland[cx];
						for (int cy = 0; cy < cc.length(); cy++) {
							if (cc[cy] == 'C') {
								int xdiff = cx - mx;
								int ydiff = cy - my;
								sum += xdiff * xdiff + ydiff * ydiff;
							}
						}
					}
					minDiss = min(minDiss, sum);
				}
			}
		}
		return minDiss;
	}
};