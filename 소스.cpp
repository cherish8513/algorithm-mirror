#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int n;

void print(int depth) {
	for (int i = 0; i < depth; i++) {
		cout << "____";
	}
}

void go(int depth) {
	cout << "\"����Լ��� ������?\"\n";
	if (depth == n) {
		print(depth);
		cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
	}
	else {
		print(depth);
		cout << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n";
		print(depth);
		cout << "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n";
		print(depth);
		cout << "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
		go(depth + 1);
	}
	print(depth);
	cout << "��� �亯�Ͽ���.\n";
}

int main()
{
	cin >> n;
	cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n";
	go(0);
}
