#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/*
�з��f��
�������Ϳ� �̺�Ž��?
�������ͷ� 2���� ���� ���� �ϳ��� �̺�Ž�� �ϴ½����� �˰��� ������
�������� = 2n = O(n)
�̺�Ž�� = logn = O(logn)
���ϴ� �̺�Ž�� ���� ã�� = n

==> O(n^2 logn)
n�� �ִ� 5000
�뷫������ 1�ʾȿ� �����Ұ�
*/



int main() {
	int n;
	cin >> n;
	vector<long long> v;
	vector<long long> ansv(3, 0);
	long long answer = 3000000001;

	for (int i = 0; i < n; i++) {
		long long num;
		cin >> num;
		v.push_back(num);
	}

	sort(v.begin(), v.end());

	for (int m = 0; m < n - 2; m++) {
		int s = m + 1, e = n - 1;

		//cout << v[m] << ", " << v[s] << ", " << v[e] << "     /     ";

		while (s < e) {
			long long sum = v[s] + v[m] + v[e];
			if (abs(sum) < answer) {
				answer = abs(sum);
				ansv[0] = v[m];
				ansv[1] = v[s];
				ansv[2] = v[e];

				//cout << ansv[0] << ", " << ansv[1] << ", " << ansv[2] <<" = "<<sum<< endl;
			}
			if (sum < 0)
				s++;
			else
				e--;
		}
	}
	for (auto& i : ansv) {
		cout << i << " ";
	}
}