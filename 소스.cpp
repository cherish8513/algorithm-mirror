#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int N, M, answer = 0;
vector<vector<int>> party_v;	// ��Ƽ ����
vector<int> know_v;		// ������ �ƴ���

int main() {
	// ù��°�� : N, M
	cin >> N >> M;
	// �ι�°�� : ������ �ƴ� �����
	int tr; cin >> tr;

	if (tr == 0) { cout << M; return 0; } // ������ �ƴ� ����� �ƹ��� ���� ���

	for (int i = 0; i < tr; i++) {
		int num;
		cin >> num;
		know_v.push_back(num);
	}
	// ����° ~ N��° : ��Ƽ ���� ���
	for (int i = 0; i < M; i++) {
		int num; cin >> num;
		vector<int> temp;
		for (int j = 0; j < num; j++) {
			int people;	cin >> people;
			temp.push_back(people);
		}
		party_v.push_back(temp);
	}
	// eof input

	// 1. ������ �ƴ»����� �Բ� ��Ƽ�� ������ �����
	//    ������ �ƴ»���� �ȴ�.
	// �ð����⵵�� �ſ�ŭ ���� �ʿ��ҵ�?
	for (int i = 0; i < party_v.size(); i++) {
		bool know_people = false;
		int size = know_v.size();

		for (int j = 0; j < size; j++) {
			vector<int> party = party_v[i];	// i��° ��Ƽ
			int know = know_v[j];			// ������ �ƴ»��

			// i ��° ��Ƽ�� ������ �ƴ»���� �ִٸ�
			if (find(party.begin(), party.end(), know) != party.end()) {
				// ���� ��Ƽ�� �ִ� ������� ���δ� ������ �ƴ� ����� �ȴ�.
				for (int k = 0; k < party.size(); k++) {
					know_v.push_back(party[k]);
				}
			}
		}

		// ������ �ƴ� ��� �ߺ� ����
		sort(know_v.begin(), know_v.end());
		know_v.erase(unique(know_v.begin(), know_v.end()), know_v.end());
	}

	// 2. ��Ƽ�� ������ �ƴ� ����� ���ٸ� ������ �����ĵ���
	for (int i = 0; i < party_v.size(); i++) {
		vector<int> party = party_v[i];
		bool gura = true;

		// ���� ������ ����߿� ������ �ƴ� ����� �ִ��� Ȯ��
		for (int j = 0; j < know_v.size(); j++) {
			// ������ �ƴ� ����� �ִٸ� ���� ��ħ �Ф�
			if (find(party.begin(), party.end(), know_v[j]) != party.end()) {
				gura = false;
				break;
			}
		}
		// ������ ���� �ѹ� ġ��
		if (gura)
			answer++;
	}

	cout << answer;
}