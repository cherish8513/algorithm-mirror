#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
	int T;
	cin >> T;

	for (int tc = 1; tc <= T; tc++)
	{
		vector<bool> S(14), D(14), H(14), C(14);
		string s;
		bool check = false;
		int sC = 13, dC = 13, hC = 13, cC = 13;

		cin >> s;	// input

		for (int i = 0; i < s.size(); i += 3)
		{
			string card = s.substr(i, 3);		// 3개씩 자르기
			int num = stoi(s.substr(i + 1, 2));	// 숫자만 자르기
			if (card[0] == 'S')
			{
				if (S[num])		// 이미 있는카드면 error 출력
				{
					check = true;
					break;
				}
				S[num] = true;	// 해당카드 있는지 체크
				sC--;			// 카드 개수 카운팅
			}
			else if (card[0] == 'D')
			{
				if (D[num])
				{
					check = true;
					break;
				}
				D[num] = true;
				dC--;
			}
			else if (card[0] == 'H')
			{
				if (H[num])
				{
					check = true;
					break;
				}
				H[num] = true;
				hC--;
			}
			else
			{
				if (C[num])
				{
					check = true;
					break;
				}
				C[num] = true;
				cC--;
			}
		}
		cout << "#" << tc << " ";
		if (check)
			cout << "ERROR";
		else
			cout << sC << " " << dC << " " << hC << " " << cC;
		cout << "\n";
	}
}