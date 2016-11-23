class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int result = 0;
		for(int i=0; i<A.length-1; i++){
			if(A[i+1] > A[i]){
				A[i+1] = A[i];
			}
		}
		
		for(int i=A.length - 1, j=0; i>-1; i--){
			if(A[i] >= B[j]){
				result++;
				j++;
			}
			if(j >= B.length-1){
				break;
			}
		}
		
		return result;
    }
}
