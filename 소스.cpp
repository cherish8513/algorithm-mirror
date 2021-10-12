#include <iostream> 
#include <vector> 
#include <deque>

using namespace std; 

//int main() {
//	int n, k;		// n : 숫자 자리수, k : 지울수있는 수 개수
//	cin >> n >> k;
//
//	string str;
//	cin >> str;
//
//	int len = n - k;	// 결과값의 길이
//	int index = 0;
//	stack<char> s;
//
//	for (int i = 0; i < n; i++) {
//		// 남은 숫자가 딱 맞아 떨어지면 그만
//		if (n - i == len - s.size()) {
//			for (int j = i; j < n; j++) {
//				s.push(str[j]);
//			}
//			
//			break;
//		}
//
//
//		char cur = str[i];
//		// 스택top > 현재 숫자
//		if (s.empty() || s.top() > cur) {
//			s.push(cur);	// 기존의 top은 두고 다음 비교를위해 cur push
//		}
//		// 스택top < 현재 숫자
//		else {
//			s.pop();
//			s.push(cur);	// 기존의 top을 cur로 교체
//		}
//	}
//
//	int siz = s.size();
//
//	for (int i = 0; i < siz; i++) {
//		cout << s.top()<<" ";
//		s.pop();
//	}
//}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int N, K; 
	cin >> N >> K; 
	string str; 
	cin >> str;

	deque<char> s;

	for (unsigned int i = 0; i < str.length(); i++) { 
		// K : 넣을 숫자가 남아있다
		// !s.empty() : 스택에 값이 남아있다
		// s.top() < str[i] : 현재 비교값이 s.top 보다 크다
		// 이하 3개를 만족하면 스택값을 교체한다.
		while (K && !s.empty() && s.back() < str[i]) {
			s.pop_back();
			K--;
		}
		
		s.push_back(str[i]);
	}

	for (unsigned int i = 0; i < s.size() - K; i++) { 
		cout << s[i]; 
	} 

}