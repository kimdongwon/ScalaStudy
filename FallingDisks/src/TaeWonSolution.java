public class Solution {
	public int solution(int[] A, int[] B){
		int minSize = A[0];
		for(int i=1 ; i<A.length ; i++){
			minSize = Math.min(minSize, A[i]);
			A[i] = minSize;
		}
		int diskIndex = 0;
		int AIndex = A.length - 1;
		while(AIndex >= 0 && diskIndex < B.length){
			if(A[AIndex] >= B[diskIndex]){
				diskIndex++;
			}
			AIndex--;
		}
		return diskIndex;
	}
}
