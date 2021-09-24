#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void dq(vector<vector<int>> cur, int len) {
	if (len == 1) {
		cout << cur[0][0] << endl;
		return;
	}

	// 다음 dq에서 사용할 next 벡터 초기화
	vector<vector<int>> next;
	for (int i = 0; i < len / 2; i++) {
		vector<int> v;
		for (int j = 0; j < len / 2; j++) {
			v.push_back(0);
		}
		next.push_back(v);
	}

	// 왼쪽위를 기준으로 잡는다
	for (int i = 0; i < len; i += 2) {
		for (int j = 0; j < len; j += 2) {
			vector<int> temp;
			// 2x2 중에 2번째로 큰수를 찾는다
			for (int y = 0; y < 2; y++) {
				for (int x = 0; x < 2; x++) {
					temp.push_back(cur[i + y][j + x]);
				}
			}
			sort(temp.begin(), temp.end());
			next[i / 2][j / 2] = temp[temp.size() - 2];
		}
	}

	//for (int i = 0; i < next.size(); i++) {
	//	for (int j = 0; j < next.size(); j++) {
	//		cout << next[i][j] << " ";
	//	}
	//	cout << endl;
	//}

	dq(next, len / 2);
}

int main() {
	int n;
	cin >> n;

	vector<vector<int>> cur;

	for (int i = 0; i < n; i++) {
		vector<int> v;
		for (int j = 0; j < n; j++) {
			int num;
			cin >> num;
			v.push_back(num);
		}
		cur.push_back(v);
	}

	dq(cur, n);
}
