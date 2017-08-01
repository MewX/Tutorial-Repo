#pragma once
#include <iostream>
#include <vector>
#include <map>

using namespace std;

class BootsExchange {
public:
	void main() {
		vector<int> left = { 1, 3, 1 }; // C++11 feature
		vector<int> right = { 2, 1, 3 };
		cout << leastAmount(left, right) << endl;

		left = { 1, 3 };
		right = { 2, 2 };
		cout << leastAmount(left, right) << endl;

		left = { 1, 2, 3, 4, 5, 6, 7 };
		right = { 2, 4, 6, 1, 3, 7, 5 };
		cout << leastAmount(left, right) << endl;
	}

	int leastAmount(vector<int> left, vector<int> right) {
		map<int, int> table; // <size, num>
		for (auto e : left) {
			if (table.count(e))
				table[e] += 1;
			else
				table[e] = 1;
		}

		for (auto e : right) {
			if (table.count(e))
				table[e] -= 1;
			else
				table[e] = -1;
		}

		int ret = 0;
		for (auto kv : table) {
			if (kv.second != 0) ret += abs(kv.second);
		}
		return ret >> 1;
	}
};
