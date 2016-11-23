using System;
using System.Collections.Generic;
// you can also use other imports, for example:
// using System.Collections.Generic;

// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");

class Solution {
   
        public int solution(int[] A, int[] B) {
            int answer = 0;
            Stack<int> well = new Stack<int>();
            well.Push(A[0]);
            for (int i = 1; i < A.Length; i++)
                if (well.Peek() >= A[i]) well.Push(A[i]);
                else well.Push(well.Peek());

            int disk = 0;
            while(well.Count != 0 && disk<B.Length){
                int wellIdx = well.Pop();
                if(B[disk]<=wellIdx){
                    disk++;
                    answer++;
                }
            }
            return answer;
        }
    
}
