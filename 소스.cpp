#include <iostream>
#include <set>
#include <cmath>
#include <bitset>
#include <vector>

using namespace std;

// 1: 승객 탑승
// 2: 승객 하차
// 3: 승객들이 모두 한칸씩 뒤로 이동
// 4: 승객들이 모두 한칸씩 앞으로 이동

int main() {
	int n, m;
	cin >> n >> m;

	// n개의 기차
	vector<int> v(n + 1, 0);

	// m개의 명령
	for (int i = 0; i < m; i++) {
		// 명령 번호
		int cmd; cin >> cmd;	
		int train = 0, pos;

		switch (cmd)
		{
		// train번째 기차에 pos위치에 탑승
		case 1:
			cin >> train >> pos;
			// 해당 자리수랑 or 연산
			v[train] = v[train] | (int)pow(2, 20 - pos);
			break;
		// train번째 기차에 pos위치가 하차
		case 2:
			cin >> train >> pos;
			v[train] = v[train] & ~(int)pow(2, 20 - pos);
			break;
		//3,4는 단순 비트연산
		case 3:
			cin >> train;
			v[train] = v[train] >> 1;
			break;
		// 왼쪽 시프트연산을 했을때 21번째 사람이 생기므로 21번째 비트는 제거
		case 4:
			cin >> train;
			v[train] = v[train] << 1;
			// 2^20 - 1 => 1111 1111 1111 1111 1111
			v[train] = v[train] & ((int)pow(2, 20) - 1);
			break;
		}
		/*bitset<20> bs(v[train]);
		cout <<train << " : "<< bs <<endl;*/
	}
	// set에 넣어서 중복제거
	set<int> s;
	for (int i = 1; i <= n; i++) {
		s.insert(v[i]);
	}
	cout << s.size();
}