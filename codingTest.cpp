#include<iostream>
#include<cmath>
#define endl "\n"
using namespace std;

bool prime[1000001];	// �ʱⰪ�� false�ϱ� true�� ���ڸ� �����. �� false�� �Ҽ�

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M, N;
	cin >> M >> N;
	prime[1] = true;
	for (int i = 2; i <= N / 2; i++) {	// i�� üũ ���� ���ƾ� �� ������ 4���ʹ� ����� �ɷ����� �� �����
		for (int j = i * 2; j <= N; j += i) {	
			prime[j] = true;	// ����� �ɸ��� �ֵ� true�� �Ҽ����� ��������
		}
	}

	for (int i = M; i <= N; i++) {
		if (prime[i]) continue;
		cout << i << endl;
	}
}