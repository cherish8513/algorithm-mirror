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
			// �ڽ��� �ڸ��� ���õǾ��ְ� Ű ū ������� �� �����ƴٸ�
			if (num == 0 && v[j] == 0) {
				v[j] = i + 1;
				break;
			}
			// Ű ū ����� �ִ� ���� ����ģ��
			// ���ڸ��� Ű��ū����� ���ðŶ�� �����Ѵ�...?
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