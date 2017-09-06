#pragma once

#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class RGBStreet
{
private:
	class RGB
	{
	public:
		int cost[3]; // r,g,b
	};

	int dfs_and_dp(int (&memory)[20][3], const vector<RGB> &inputs, const int index, const int color)
	{
		// found calculated in memory
		if (memory[index][color] != 0) return memory[index][color];

		// reached last house
		if (index == inputs.size() - 1)
		{
			memory[index][color] = inputs[index].cost[color];
		}
		else
		{
			// not the last house, "waiting for" results from the next two possible houses
			// NOTE: the next two houses happen in [index + 1]
			int possible1 = 0, possible2 = 0;
			if (color == 0)
			{
				possible1 = dfs_and_dp(memory, inputs, index + 1, 1);
				possible2 = dfs_and_dp(memory, inputs, index + 1, 2);
			}
			else if (color == 1)
			{
				possible1 = dfs_and_dp(memory, inputs, index + 1, 0);
				possible2 = dfs_and_dp(memory, inputs, index + 1, 2);
			}
			else
			{
				// color == 2
				possible1 = dfs_and_dp(memory, inputs, index + 1, 0);
				possible2 = dfs_and_dp(memory, inputs, index + 1, 1);
			}


			// use the minimum between the two collected results, and add them with current cost
			memory[index][color] = min(possible1, possible2) + inputs[index].cost[color];
		}
		return memory[index][color];
	}

public:
	void main()
	{
		vector<string> test = { "1 100 100", "100 1 100", "100 100 1" };
		cout << estimateCost(test) << endl;

		test = { "1 100 100", "100 100 100", "1 100 100" };
		cout << estimateCost(test) << endl;

		test = { "26 40 83", "49 60 57", "13 89 99" };
		cout << estimateCost(test) << endl;

		test = { "30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91" };
		cout << estimateCost(test) << endl;

		test = { "71 39 44", "32 83 55", "51 37 63", "89 29 100", "83 58 11", "65 13 15", "47 25 29", "60 66 19" };
		cout << estimateCost(test) << endl;
	}

	int estimateCost(vector<string> houses)
	{
		vector<RGB> inputs;
		for (int i = 0; i < houses.size(); i ++)
		{
			RGB rgb;
			istringstream iss(houses[i]);
			iss >> rgb.cost[0] >> rgb.cost[1] >> rgb.cost[2];
			inputs.push_back(rgb);
		}

		// [house index][0:r/1:g/2/b], initilised with 0
		// this means in current index, if I use f/g/b, it is the minimal cost I can get(wait for) from further layers
		int memory[20][3] = {0};

		// the minimum when the first house is r/g/b respectively
		return min(min(dfs_and_dp(memory, inputs, 0, 0), dfs_and_dp(memory, inputs, 0, 1)), dfs_and_dp(memory, inputs, 0, 2));
	}
};
