#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <string>
#include <algorithm>
using namespace std;

class AddMultiply
{
private:
	string i1, i2;
	int b;
	void init(string i1, string i2, int base)
	{
		this->i1 = i1;
		this->i2 = i2;
		this->b = base;
	}

	void removeLeadingZero(string &temp)
	{
		// remove leading zeros
		int i = 0;
		while (temp.length() != 0 && temp[i] == '0') temp.erase(0, 1);
		if (temp.length() == 0) temp = "0";
	}

	string basicMultiply(char a, char b)
	{
		//normal way
		const int mul = (a - '0') * (b -'0');
		string ret = string(1, mul / this->b + '0') + string(1, mul % this->b + '0');
		removeLeadingZero(ret);
		cout << a << " * " << b << " = " << ret << " (" << (a - '0') * (b -'0') << ")" << endl;
		return ret;
	}

	void getHigh(const string &source, string &num, int size)
	{
		num = source.substr(0, max((int)source.length() - size, 0));
		if (num.length() == 0) num = "0";
	}

	void getLow(const string &source, string &num, int size)
	{
		num = source.substr(max(0, (int)source.length() - size), source.length());
		if (num.length() == 0) num = "0";
	}

	string karatsuba(string n1, string n2)
	{
		//reference: https://en.wikipedia.org/wiki/Karatsuba_algorithm
		//if (n1.length() == 1 && n1[0] - '0' < b && n2.length() == 1 && n2[0] - '0' < b)
		if (n1.length() == 1 && n2.length() == 1)
			return basicMultiply(n1[0], n2[0]);

		int m = max(n1.length(), n2.length());
		m /= 2;//m = m/2,

		//split the digits
		string high1, low1, high2, low2;
		getHigh(n1, high1, m);
		getLow(n1, low1, m);
		getHigh(n2, high2, m);
		getLow(n2, low2, m);
		cout << "high1: " << high1 << "; low1: " << low1 << " || high2: " << high2 << "; low2: " << low2 << endl;

		//recursive
		string a = karatsuba(low1, low2);
		string b = karatsuba(getSum(low1, high1), getSum(low2, high2));
		string c = karatsuba(high1, high2);

		const string zeros(m, '0');
		string part1 = c + zeros + zeros;
		removeLeadingZero(part1);
		string part2 = getSub(getSub(b, c), a) + zeros;
		removeLeadingZero(part2);
		string part3 = a;
		removeLeadingZero(part3);

		string ret = getSum(part1, getSum(part2, part3));
		cout << "==> " << n1 << " * " << n2 << " = " << ret << endl;
		return ret;
	}

	string getSub(string i1, string i2)
	{
		// a - b
		if (i1[0] == '-' && i2[0] == '-') return getSub(i2.substr(1), i1.substr(1));
		else if (i1[0] == '-' && i2[0] != '-') return string(1, '-') + getSum(i1.substr(1), i2.substr(1));
		else if (i1[0] != '-' && i2[0] == '-') return getSum(i1, i2.substr(1));

		// find the bigger one
		bool finalCarry = false;
		if (!(i1.length() > i2.length() || i1.length() == i2.length() && i1[0] > i2[0]))
		{
			string bigger = i2;
			i2 = i1;
			i1 = bigger;
			finalCarry = true;
		}
		
		// two positive substracts
		// TODO:
		bool carry = false;
		string target = "";
		int idx1 = i1.length() - 1, idx2 = i2.length() - 1;
		//cout << "idx1: " << idx1 << "; idx2: " << idx2 << endl;
		for (; idx1 >= 0 && idx2 >= 0; idx1 --, idx2 --)
		{
			int sub = i1[idx1] - i2[idx2];
			if (carry)
			{
				sub -= 1;
				carry = false;
			}

			if (sub < 0) carry = true;
			target.insert(0, string(1, (sub + b) % b + '0'));
		}

		// first value
		while (idx1 >= 0)
		{
			int sub = i1[idx1] - '0';
			if (carry)
			{
				sub -= 1;
				carry = false;
			}
			if (sub < 0) carry = true;

			target.insert(0, string(1, (sub + b) % b + '0'));
			idx1--;
		}

		//second value (impossible)
		//if (idx2 >= 0) carry = true;
		//while (idx2 >= 0)
		//{
		//	int sub = -(i2[idx2] - '0');
		//	if (carry)
		//	{
		//		sub -= 1;
		//		carry = false;
		//	}
		//	if (sub < 0) carry = true;

		//	target.insert(0, string(1, (sub + b) % b + '0'));
		//}

		removeLeadingZero(target);

		// last one
		if (finalCarry) target.insert(0, string(1, '-'));

		//special case
		if (target.length() == 0) target = "0";
		return target;
	}

public:
	AddMultiply()
	{
		init("0", "0", 10);
	}
	AddMultiply(string line)
	{
		istringstream iss(line);
		string i1, i2;
		int base;
		iss >> i1 >> i2 >> base;
		init(i1, i2, base);
	}
	AddMultiply(string i1, string i2, int base)
	{
		init(i1, i2, base);
	}

	void outputAnswer()
	{
		// TODO: I1 I2 B S P
		cout << "original: " << i1 << "; " << i2 << endl;
		cout << getSum(i1, i2) << " " << getMultiply() << endl;
		//cout << getSum(i1, i2) << " " << getSub(i1, i2) << " " << getSub(i2, i1) << endl;
	}

	string getSum(string i1, string i2)
	{
		// a + b
		if (i1[0] == '-' && i2[0] == '-') return string(1, '-') + getSum(i1.substr(1), i2.substr(1));
		else if (i1[0] == '-' && i2[0] != '-') return getSub(i2, i1.substr(1));
		else if (i1[0] != '-' && i2[0] == '-') return getSub(i1, i2.substr(1));

		bool carry = false;
		string target = "";

		int idx1 = i1.length() - 1, idx2 = i2.length() - 1;
		//cout << "idx1: " << idx1 << "; idx2: " << idx2 << endl;
		for (; idx1 >= 0 && idx2 >= 0; idx1 --, idx2 --)
		{
			//init values
			int sum = i1[idx1] - '0' + i2[idx2] - '0';
			if (carry)
			{
				sum += 1;
				carry = false;
			}

			if (sum >= b)
				carry = true;
			//cout << "cur = " << sum << endl;
			target.insert(0, string(1, sum % b + '0'));
		}

		// the rest in i1
		while (idx1 >= 0)
		{
			int sum = i1[idx1] - '0';
			if (carry)
			{
				sum += 1;
				carry = false;
			}
			if (sum >= b) carry = true;

			target.insert(0, string(1, sum % b + '0'));
			idx1--;
		}

		// the rest in i2 (either in i1 or in i2)
		while (idx2 >= 0)
		{
			int sum = i2[idx2] - '0';
			if (carry)
			{
				sum += 1;
				carry = false;
			}
			if (sum >= b) carry = true;

			target.insert(0, string(1, sum % b + '0'));
			idx2--;
		}

		// last one
		if (carry) target.insert(0, string(1, '1'));

		//special case
		if (target.length() == 0) target = "0";
		return target;
	}

	string getMultiply()
	{
		return karatsuba(i1, i2);
	}

};
