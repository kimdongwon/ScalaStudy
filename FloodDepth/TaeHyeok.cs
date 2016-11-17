using System;
// you can also use other imports, for example:
// using System.Collections.Generic;

// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");


    class Solution
    {
        public int solution(int[] A)
        {
            int left = 0;
            int right = 0;
            int bottom = int.MaxValue;
            int ans = 0;
            for (int i = 0; i < A.Length; i++)
            {
                if (A[i] >= left)
                {
                    if(bottom<left)
                    {
                        int tmp = left - bottom;
                        ans = tmp > ans ? tmp : ans;
                    }
                    left = A[i];
                    bottom = A[i];
                }
                else if(A[i] < left)
                {
                    bottom = bottom < A[i] ? bottom : A[i];
                }
            }
            bottom = int.MaxValue;
            for (int i = A.Length-1; i >= 0; i--)
            {
                if (A[i] >= right)
                {
                    if (bottom < right)
                    {
                        int tmp = right - bottom;
                        ans = tmp > ans ? tmp : ans;
                    }
                    right = A[i];
                    bottom = A[i];
                }
                else if (A[i] < right)
                {
                    bottom = bottom < A[i] ? bottom : A[i];
                }
            }

            return ans;
        }
    }
