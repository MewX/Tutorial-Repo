#pragma once
#include <iostream>
#include <vector>

using namespace std;

class SumOfPower {
public:
	void main() {
		vector<int> v = { 1, 2 };
		cout << findSum(v) << endl;

		v = { 1, 1, 1 };
		cout << findSum(v) << endl;

		v = { 3, 14, 15, 92, 65 };
		cout << findSum(v) << endl;

		v = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		cout << findSum(v) << endl;
	}

	int findSum(vector<int> array) {
		int sum = 0;
		for (int i = 0; i < array.size(); i++) {
			for (int len = array.size() - i; len > 0; len--) {
				for (int j = 0; j < len; j++) {
					sum += array[i + j];
				}
			}
		}
		return sum;
	}
};