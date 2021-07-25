#include<iostream>
#include<string>
#include<stack>
using namespace std;
int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	while (1) {
		string input;
		bool flag = true;
		stack<char> stack;
		getline(cin, input);			// cin 쓰면 space로 구분돼서 작살남
		if (input[0] == '.') break;
		for (int i = 0; input.length(); i++) {
			if (input[i] == '.') break;		// . 나오면 문장 종료
			else if (input[i] == '(') {		// ( 은 무조건 stack에 저장
				stack.push('(');
			}
			else if (input[i] == ')') {		// ) 이 나왔을 때 스택의 맨 위가 비어있거나 ( 가 아니면 중단하고 no 출력
				if (stack.empty() || stack.top() != '(') {
					flag = false;
					break;
				}
				else {					//  그 외의 경우 pop 해줌
					stack.pop();
				}
			}
			else if (input[i] == '[') {		// ( 은 무조건 stack에 저장
				stack.push('[');
			}
			else if (input[i] == ']') {		// ] 이 나왔을 때 스택의 맨 위가 비어있거나 [ 가 아니면 중단하고 no 출력
				if (stack.empty() || stack.top() != '[') {
					flag = false;
					break;
				}
				else {					//  그 외의 경우 pop 해줌
					stack.pop();
				}
			}
		}
		if (flag && stack.empty()) cout << "yes\n";		// 스택 비어있고 flag true 이면 yes
		else cout << "no\n";
	}
}