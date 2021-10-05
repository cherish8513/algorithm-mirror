#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n; cin >> n;								// ���� ����
	vector<long long> classVector;					// ���� ����

	for (int i = 0; i < n; i++) {
		long long bitmask = 0;
		int k; cin >> k;							// �����ð� ���� 

		// �� �����ð��� ��Ʈ�� ǥ��
		for (int j = 0; j < k; j++) {
			long long t; cin >> t;
			bitmask += ((long long)1 << (t - 1));	// ĳ���� ����
		}
		classVector.push_back(bitmask);
	}

	int m; cin >> m;								// �л� ��
	vector<long long> studentVector;				// �л� ������ ����

	for (int i = 0; i < m; i++) {
		long long bitmask = 0;
		int p; cin >> p;							// ����ִ� �ð� ����	

		for (int j = 0; j < p; j++) {
			int t; cin >> t;						// ����ִ½ð� ����
			bitmask += ((long long)1 << (t - 1));	// ĳ���� ����
		}
		studentVector.push_back(bitmask);
	}
	// eof input


	vector<int> result(studentVector.size(), 0);	// ����� ��� ����

	// 1000 * 10000 = 1õ��
	for (int i = 0; i < classVector.size(); i++) {
		for (int j = 0; j < studentVector.size(); j++) {
			long long classTime = classVector[i];
			long long studentTime = studentVector[j];

			// ������ �켱���� ����
			// �����ð��� �л��� �����ð��� & �����ϸ� �����ð��� �����ð��� ���Եɼ��ִ��� Ȯ�ΰ���
			if ((classTime & studentTime) == classTime)
				result[j]++;
		}
	}

	// output
	for (auto& i : result)
		cout << i << "\n";
}