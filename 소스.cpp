#include <iostream>
#include <vector>
#include <algorithm>

#define SIZE 200001
using namespace std;

int m, n, total, result, answer;
int parent[SIZE];
bool flag;
vector<pair<int, pair<int, int>>> edge;

// 초기화
void Init() {
	edge.clear();
	total = result = 0;
	for (int i = 0; i < SIZE; i++) {
		parent[i] = i;
	}
}

// union find 필수
int Find_Parent(int A)
{
	if (A == parent[A]) return A;
	else return parent[A] = Find_Parent(parent[A]);
}

// 같은 부모인지 확인
bool SameParent(int A, int B)
{
	A = Find_Parent(A);
	B = Find_Parent(B);
	if (A == B) return true;
	return false;
}

// union 필수
void Union(int A, int B)
{
	A = Find_Parent(A);
	B = Find_Parent(B);

	parent[B] = A;
}

void Solution()
{
	// 1. 일단 edge 가중치 기준으로 정렬
	sort(edge.begin(), edge.end());
	for (int i = 0; i < edge.size(); i++)
	{
		int Cost = edge[i].first;	// 가중치
		int Node1 = edge[i].second.first;	//노드1
		int Node2 = edge[i].second.second;	// 노드2

		// 2. 둘이 접해있지 않다면 간선을 추가
		if (SameParent(Node1, Node2) == false)
		{
			Union(Node1, Node2);
			result = result + Cost;
		}
	}
	answer = total - result;
}

void Solve()
{
	while (1)
	{
		Init();

		cin >> m >> n;
		if (m == 0 && n == 0)
		{
			flag = true;
			return;
		}
		for (int i = 0; i < n; i++)
		{
			int a, b, c; cin >> a >> b >> c;
			edge.push_back(make_pair(c, make_pair(a, b)));
			total += c;
		}// eof input

		if (flag == true) return;
		Solution();
		cout << answer << endl;
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	Solve();

	return 0;
}