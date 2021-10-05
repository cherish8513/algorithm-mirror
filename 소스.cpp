#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n; cin >> n;								// 수업 개수
	vector<long long> classVector;					// 수업 벡터

	for (int i = 0; i < n; i++) {
		long long bitmask = 0;
		int k; cin >> k;							// 수업시간 개수 

		// 각 수업시간을 비트로 표현
		for (int j = 0; j < k; j++) {
			long long t; cin >> t;
			bitmask += ((long long)1 << (t - 1));	// 캐스팅 주의
		}
		classVector.push_back(bitmask);
	}

	int m; cin >> m;								// 학생 수
	vector<long long> studentVector;				// 학생 스케쥴 벡터

	for (int i = 0; i < m; i++) {
		long long bitmask = 0;
		int p; cin >> p;							// 비어있는 시간 개수	

		for (int j = 0; j < p; j++) {
			int t; cin >> t;						// 비어있는시간 저장
			bitmask += ((long long)1 << (t - 1));	// 캐스팅 주의
		}
		studentVector.push_back(bitmask);
	}
	// eof input


	vector<int> result(studentVector.size(), 0);	// 결과값 담길 벡터

	// 1000 * 10000 = 1천만
	for (int i = 0; i < classVector.size(); i++) {
		for (int j = 0; j < studentVector.size(); j++) {
			long long classTime = classVector[i];
			long long studentTime = studentVector[j];

			// 연산자 우선순위 주의
			// 수업시간과 학생의 여유시간을 & 연산하면 여유시간에 수업시간이 포함될수있는지 확인가능
			if ((classTime & studentTime) == classTime)
				result[j]++;
		}
	}

	// output
	for (auto& i : result)
		cout << i << "\n";
}