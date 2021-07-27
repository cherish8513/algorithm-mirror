#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main()
{
	int N;
	cin >> N;

	vector<int> vec;			// 수를 저장 할 벡터(vector : 가변 배열)
	vector<int> answer(N, -1);	// 정답을 저장할 벡터
	stack<int> sta;				// 로직에 필요한 스택

	// Input
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		vec.push_back(num);
	}

	// Logic , 역순으로 수행(오른쪽 숫자를 비교해야하기 때문)
	for (int i = N - 1; i >= 0; i--) {
		int current = vec[i];

		// 비교할숫자 즉 스택이 텅빌때까지 반복
		while (!sta.empty()) {
			// stack top 이 자기보다 크면 오큰수가 존재
			if (sta.top() > current) {
				answer[i] = sta.top();
				break;
			}
			// stack top 이 자기보다 작으면 필요없음 -> 자기 자신이 앞으로 가장 큰 숫자이기 때문
			else {
				sta.pop();
			}
		}
		
		sta.push(vec[i]);
	}

	for (auto& i : answer) {
		cout << i << " ";
	}
}