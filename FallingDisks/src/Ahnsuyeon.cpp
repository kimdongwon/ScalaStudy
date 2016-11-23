int solution(vector<int> &A, vector<int> &B) {
   int max = 0;
   for (unsigned int i = 0; i < A.size(); i++)
   {
      if (max < A.at(i))
         max = A.at(i);
   }

   vector<int> arr(max, -1);

   int lastIndex = max;
   int maxValue = -1;

   for (unsigned int i = 0; i < A.size(); i++)
   {
      if (i == 0)
      {
         maxValue = A.at(i);
         lastIndex = maxValue;         
         continue;
      }   

      if (A.at(i) >= maxValue)
      {
         continue;
      }
      
      maxValue = A.at(i);

      for (unsigned int j = maxValue; j < lastIndex; j++)
      {
         arr[j] = i - 1;
      }      

      lastIndex = maxValue;
   }


   for (unsigned int i = 0; i < lastIndex; i++)
   {
      arr[i] = A.size() - 1;
   }

   lastIndex = max;
   int count = 0;

   for (unsigned int i = 0; i < B.size(); i++)
   {
      int value = B.at(i);

      if (lastIndex < 0 || value > max)
      {
         break;
      }

      if (arr[value - 1] <= lastIndex && arr[value-1] >= 0)
      {
         count++;
         arr[value - 1]--;
         lastIndex = arr[value - 1];
      }
      else if (arr[value - 1] < 0)
      {
         break;
      }
      else if(arr[value-1] > lastIndex)
      {
         count++;
         arr[value - 1] = lastIndex - 1;
         lastIndex = arr[value - 1];
      }
   }

   return count;
}
