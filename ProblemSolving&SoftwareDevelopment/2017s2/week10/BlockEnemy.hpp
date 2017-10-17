#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class BlockEnemy
{
private:
	class Prop {
	public:
		int target, effort;
		Prop(int t, int e) {
			target = t;
			effort = e;
		}
	};

	int ans;

public:
	void main() {
		vector<string> test1 = { "1 0 1", "1 2 2", "0 3 3", "4 0 4" };
		vector<int> test2 = { 3, 2, 4 };
		cout << minEffort(5, test1, test2) << endl;

		test1 = { "1 0 1", "1 2 2", "0 3 3", "4 0 4" };
		test2 = { 3 };
		cout << minEffort(5, test1, test2) << endl;

		test1 = {"0 1 3", "2 0 5", "1 3 1", "1 4 8", "1 5 4", "2 6 2", "4 7 11", "4 8 10", "6 9 7", "6 10 9", "6 11 6"};
		test2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		cout << minEffort(12, test1, test2) << endl;

		test1 = { "0 1 68" };
		test2 = { 0, 1 };
		cout << minEffort(2, test1, test2) << endl;
	}

	int minEffort(int N, vector <string> roads, vector<int> occupiedTowns) {
		vector<Prop> table[50];
		bool occupied[50] = { false };

		// parsing inputs
		for (int i = 0; i < roads.size(); i ++) {
			int a, b, e;
			sscanf(roads[i].c_str(), "%d %d %d", &a, &b, &e);
			table[a].push_back(Prop(b, e));
			table[b].push_back(Prop(a, e));
		}
		for (int i = 0; i < occupiedTowns.size(); i ++) {
			occupied[occupiedTowns[i]] = true;
		}

		// deep first search from the first town
		ans = 0;
		dfs(0, -1, table, occupied);
		return ans;
	}

	int dfs(int current, int from, const vector<Prop> *table, const bool *occupied) {
		cout << "  current: " << current << "; from: " << from << endl;
		int maxEffort = 0;

		// all nodes connected with current node 
		for (int i = 0; i < table[current].size(); i ++) {
			// prevent fall back
			if (table[current][i].target != from) {
				// find possible minimal effort in this branch from `current` node
				int temp = dfs(table[current][i].target, current, table, occupied);
				cout << "    return temp: " << temp << endl;
				// no occupied town in path
				if (temp > -1) {
					// remove the least effort road
					temp = min(temp, table[current][i].effort);
					// record the max effort from this ancester
					maxEffort = max(maxEffort, temp);

					// add this removed road first
					ans += temp;
					cout << "    current: " << current << "; from: " << from;
					cout << "; temp: " << temp << "; m: " << maxEffort << "; ans: " << ans << endl;
				}
			}
		}

		// enemy in path (from enemy town to another other town takes super great effort)
		if (occupied[current]) return 1000000000; // a very big effort

		// used for detecting more than one enemies in path
		ans -= maxEffort;
		return maxEffort;
	}
};
