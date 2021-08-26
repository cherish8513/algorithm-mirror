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
			string card = s.substr(i, 3);		// 3���� �ڸ���
			int num = stoi(s.substr(i + 1, 2));	// ���ڸ� �ڸ���
			if (card[0] == 'S')
			{
				if (S[num])		// �̹� �ִ�ī��� error ���
				{
					check = true;
					break;
				}
				S[num] = true;	// �ش�ī�� �ִ��� üũ
				sC--;			// ī�� ���� ī����
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