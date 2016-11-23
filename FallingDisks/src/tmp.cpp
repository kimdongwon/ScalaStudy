#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int solution(vector<int>& A, vector<int>& B)
{
	map<int, int>m;
	for (int i = 0; i < A.size(); i++)
	{
		if (m.find(A[i]) == m.end()) m.insert(pair<int, int>(A[i], i));
	}

	map<int, int>::iterator it = m.begin();

	int size = A.size() - 1;
	int disks = 0;
	int bSize = B.size();
	while (1)
	{
		while (disks < bSize && (*it).first >= B[disks] && size >= 0)
		{
			disks++;
			size--;
		}
		if (size < 0 || disks == bSize) return disks;
		size = min(size, (*it).second - 1);

		int param = (*it).second;
		while (it != m.end() && (*it).second >= param) ++it;
		if (it == m.end()) break;
		if ((*it).first < B[disks])
		{
			while (it != m.end() && (*it).first < B[disks])
			{
				size = min(size, (*it).second - 1);
				++it;
			}
		}
		if (it == m.end()) break;

	}
	return disks;
}
