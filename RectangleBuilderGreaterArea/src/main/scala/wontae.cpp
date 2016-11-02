#include <iostream>
#include <vector>
#include <map>
using namespace std;

int solution(vector<int>& A, int X)
{
	int ret = 0;
	int key, value;
	map<int, int> m;

	if (A.size() == 0) return 0;

	//
	for (vector<int>::iterator iter = A.begin(); iter != A.end(); iter++)
	{
		key = *iter;
		if (m.find(key) == m.end()) m.insert(pair<int, int>(key, 0));
		value = m[key];
		m[key] = value + 1;
	}

	vector<int>two;
	
	int cnt = 0;
	int param = 0;
	int fir = 0;
	for (map<int, int>::iterator iter = m.begin(); iter != m.end(); ++iter)
	{
		if ((*iter).second >= 2)
		{
			two.push_back((*iter).first);
			//cout << (*iter).first << endl;
			if ((long long)(*iter).first * (*iter).first >= X && param == 0)
			{
				param++;
				fir = cnt;
			}
			cnt++;
		}
		if ((*iter).second >= 4 && param) ret++;
	}
	if (param == 0) return 0;
//	cout << fir << endl;
	param = 0;
	int tmpJ = two.size() - 1;
	for (int i = 0; i < fir; i++)
	{
		while ((long long)two[i] * two[tmpJ] >= X)
		{
			param++;
			tmpJ--;
		}

		ret += param;
		if (ret > 1000000000 || ret < 0) return -1;
	}

	ret += ((two.size() - fir) * (two.size() - fir - 1) / 2);
	if (ret > 1000000000 || ret < 0) return -1;

	return ret;

}
