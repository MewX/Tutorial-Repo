#pragma once
#include <iostream>
#include <string>

using namespace std;

class HenrysKey {
public:
	void main() {
		cout << howManys("A") << endl;
		cout << howManys("ABA") << endl;
		cout << howManys("AABACCCCABAA") << endl;
		cout << howManys("AGAAGAHHHHFTQLLAPUURQQRRUFJJSBSZVJZZZ") << endl;
		cout << howManys("ZZZZZZZZZZZZZ") << endl;
	}

	int howManys(string s) {
		int count = 1; // the first is counted
		for (int i = 1; i < s.length(); i++) {
			if (s[i] != s[i - 1])
				count++;
		}
		return count;
	}
};