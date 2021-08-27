#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
	int T; cin >> T;

	for (int tc = 1; tc <= T; tc++) {
		int answer = 0;
		char flag = '0';
		string str; 
		cin >> str;
		// eof input

		for (int i = 0; i < str.length(); i++) {
			if (str[i] != flag) {
				flag = str[i];
				answer++;
			}
		}
		cout << "#" << tc << " " << answer << '\n';
	}
}