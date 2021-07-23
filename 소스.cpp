#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	int N;
	cin >> N;		// N <= 500,000

	stack<pair<int, int>> stack;
	vector<int> answer(N, 0);

	for (int i = 0; i < N; i++)
	{
		int height; 
		cin >> height;		
		pair<int, int> tower(height, i + 1);	// 높이, index;

		while (true) {
			// 스택이 비었다면 자기자신이 가장 큰 타워
			if (stack.empty()) {
				stack.push(tower);
				break;
			}
			// 스택탑이 더크면 answer에 저장 -> 다음 입력값으로, 스택 푸시
			else if(stack.top().first > height) {
				answer[i] = stack.top().second;
				stack.push(tower);
				break;
			}
			// 스택탑이 더 작으면 현재 타워가 더 크므로 스택탑은 제거
			else {
				stack.pop();
			}
		}
	}

	for (int i = 0; i < N; i++) {
		cout << answer[i] << " ";
	}
}