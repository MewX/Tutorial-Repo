#pragma once
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class ChangingString {
public:
	void main() {
		cout << distance("ab", "ba", 2) << endl;
		cout << distance("aa", "aa", 2) << endl;
		cout << distance("aaa", "baz", 1) << endl;
		cout << distance("fdfdfdfdfdsfabasd", "jhlakfjdklsakdjfk", 8) << endl;
		cout << distance("aa", "bb", 2) << endl;
	}

	int distance(string A, string B, int K) {
		vector<int> differences;
		for (int i = 0; i < A.length(); i++) {
			int diff = abs(A[i] - B[i]);
			if (diff != 0) differences.push_back(diff);
		}
		sort(differences.begin(), differences.end(), [ ](int a, int b)->bool {return a > b; });

		int sum = K > differences.size() ? K - differences.size() : 0;
		for (int i = K; i < differences.size(); i++) sum += differences[i];
		return sum;
	}
};