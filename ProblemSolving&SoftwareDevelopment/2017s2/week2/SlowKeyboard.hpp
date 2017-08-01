#pragma once
#include <iostream>
#include <vector>

using namespace std;

class SlowKeyboard {
public:
	void main() {
		cout << enterTime("59:56") << endl;
		cout << enterTime("59:59") << endl;
		cout << enterTime("33:12") << endl;
		cout << enterTime("16:35") << endl;
	}

	int enterTime(string time) {
		vector<int> t = { time[0] - '0', time[1] - '0', time[3] - '0', time[4] - '0' };
		for (int i = 1; i < 1000; i++) {
			t = addOne(t);
			if (i == checkCost(t) || i - 1 == checkCost(t)) return i;
		}
		return 0;
	}

private:
	vector<int> addOne(const vector<int> &t) {
		vector<int> time = t;
		time[3] += 1;
		if (time[3] >= 10) {
			time[2] += 1;
			time[3] = 0;
		}
		if (time[2] >= 6) {
			time[1] += 1;
			time[2] = 0;
		}
		if (time[1] >= 10) {
			time[0] += 1;
			time[1] = 0;
		}
		if (time[0] >= 6)
			time[0] = 0;
		return time;
	}

	int checkCost(const vector<int> &time) {
		int count = 4;
		for (int i = 1; i < time.size(); i++) {
			if (time[i] != time[i - 1]) {
				count += 2;
			}
		}
		return count;
	}
};
