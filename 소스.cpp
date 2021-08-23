#include <iostream>
#include <algorithm>
using namespace std;

int n;

int maxArr[3];
int minArr[3];

int main() {
	cin >> n;

	int n1, n2, n3;
	cin >> n1 >> n2 >> n3;
	maxArr[0] = n1;		minArr[0] = n1;
	maxArr[1] = n2;		minArr[1] = n2;
	maxArr[2] = n3;		minArr[2] = n3;

	for (int i = 1; i < n; i++) {
		cin >> n1 >> n2 >> n3;

		int max0 = maxArr[0], max1 = maxArr[1], max2 = maxArr[2];
		int min0 = minArr[0], min1 = minArr[1], min2 = minArr[2];

		maxArr[0] = n1 + max(max0, max1);
		maxArr[1] = n2 + max(max0, max(max1, max2));
		maxArr[2] = n3 + max(max1, max2);

		minArr[0] = n1 + min(min0, min1);
		minArr[1] = n2 + min(min0, min(min1, min2));
		minArr[2] = n3 + min(min1, min2);
	}

	int max = 0, min = 999999;
	for (int i = 0; i < 3; i++) {
		if (max < maxArr[i])
			max = maxArr[i];
		if (min > minArr[i])
			min = minArr[i];
	}
	cout << max << " " << min;
}