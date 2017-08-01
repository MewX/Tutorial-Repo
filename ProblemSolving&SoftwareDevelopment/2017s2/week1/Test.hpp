#pragma once
#include <iostream>

using namespace std;

/**
 * According to the submission requirements, the files should be submitted in "hpp" files.
 */
class Test
{
public:
	void main()
	{
		cout << "This is the test file for PSSD project" << endl;
		cout << (new Test())->testadd(1, 2) << endl;
	}

	int testadd(int a, int b)
	{
		return a + b;
	}
};
