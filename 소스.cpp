#include <iostream> 
#include <vector> 
#include <deque>

using namespace std; 

//int main() {
//	int n, k;		// n : ���� �ڸ���, k : ������ִ� �� ����
//	cin >> n >> k;
//
//	string str;
//	cin >> str;
//
//	int len = n - k;	// ������� ����
//	int index = 0;
//	stack<char> s;
//
//	for (int i = 0; i < n; i++) {
//		// ���� ���ڰ� �� �¾� �������� �׸�
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
//		// ����top > ���� ����
//		if (s.empty() || s.top() > cur) {
//			s.push(cur);	// ������ top�� �ΰ� ���� �񱳸����� cur push
//		}
//		// ����top < ���� ����
//		else {
//			s.pop();
//			s.push(cur);	// ������ top�� cur�� ��ü
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
		// K : ���� ���ڰ� �����ִ�
		// !s.empty() : ���ÿ� ���� �����ִ�
		// s.top() < str[i] : ���� �񱳰��� s.top ���� ũ��
		// ���� 3���� �����ϸ� ���ð��� ��ü�Ѵ�.
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