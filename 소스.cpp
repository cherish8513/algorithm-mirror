#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int N, M, answer = 0;
vector<vector<int>> party_v;	// 파티 벡터
vector<int> know_v;		// 진실을 아는자

int main() {
	// 첫번째줄 : N, M
	cin >> N >> M;
	// 두번째줄 : 진실을 아는 사람들
	int tr; cin >> tr;

	if (tr == 0) { cout << M; return 0; } // 진실을 아는 사람이 아무도 없을 경우

	for (int i = 0; i < tr; i++) {
		int num;
		cin >> num;
		know_v.push_back(num);
	}
	// 세번째 ~ N번째 : 파티 참석 멤버
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

	// 1. 진실을 아는사람들과 함께 파티에 참석한 사람은
	//    진실을 아는사람이 된다.
	// 시간복잡도가 매우큼 개선 필요할듯?
	for (int i = 0; i < party_v.size(); i++) {
		bool know_people = false;
		int size = know_v.size();

		for (int j = 0; j < size; j++) {
			vector<int> party = party_v[i];	// i번째 파티
			int know = know_v[j];			// 진실을 아는사람

			// i 번째 파티에 진실을 아는사람이 있다면
			if (find(party.begin(), party.end(), know) != party.end()) {
				// 현재 파티에 있는 사람들은 전부다 진실을 아는 사람이 된다.
				for (int k = 0; k < party.size(); k++) {
					know_v.push_back(party[k]);
				}
			}
		}

		// 진실을 아는 사람 중복 제거
		sort(know_v.begin(), know_v.end());
		know_v.erase(unique(know_v.begin(), know_v.end()), know_v.end());
	}

	// 2. 파티에 진실을 아는 사람이 없다면 마음껏 구라쳐도됨
	for (int i = 0; i < party_v.size(); i++) {
		vector<int> party = party_v[i];
		bool gura = true;

		// 현재 참석한 사람중에 진실을 아는 사람이 있는지 확인
		for (int j = 0; j < know_v.size(); j++) {
			// 진실을 아는 사람이 있다면 구라 못침 ㅠㅠ
			if (find(party.begin(), party.end(), know_v[j]) != party.end()) {
				gura = false;
				break;
			}
		}
		// 없으면 구라 한번 치기
		if (gura)
			answer++;
	}

	cout << answer;
}