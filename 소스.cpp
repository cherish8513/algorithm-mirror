#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int n; 
	cin >> n;

	vector<int> v(n,0);

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		
		for (int j = 0; j < n; j++) {
			// 자신의 자리가 마련되어있고 키 큰 사람들을 다 지나쳤다면
			if (num == 0 && v[j] == 0) {
				v[j] = i + 1;
				break;
			}
			// 키 큰 사람이 있는 곳을 지나친다
			// 빈자리를 키가큰사람이 들어올거라고 가정한다...?
			else if (v[j] == 0) {
				num--;
			}
		}
		//for (auto& i : v) {
		//	cout << i << " ";
		//}
		//cout << endl;
	}

	for (auto& i : v) {
		cout << i << " ";
	}
}