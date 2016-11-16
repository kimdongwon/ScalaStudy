public class FloodDepth {

	public static void main(String[] args) {
		int[] a = {100000000, 1, 100000000};
		System.out.println(solution(a));
	}
	
	public static int solution(int[] A){
		int result = 0;
		
		int[] resultArr = new int[A.length];
		
		int height = A[0];
		for(int i=1; i<A.length-1; i++){
			if(height - A[i] > 0){
				resultArr[i] = height - A[i];
			}else if (height - A[i] == 0){
				resultArr[i] = 0;
			}else{
				height = A[i];
				resultArr[i] = 0;
			}
		}
		
		height = A[A.length - 1];
		for(int i=A.length-2; i>0; i--){
			if(height - A[i] > 0){
				if(resultArr[i] > height - A[i]){
					resultArr[i] = height - A[i];
				}
				if(result < resultArr[i]){
					result = resultArr[i];
				}
			}else if(height - A[i] == 0){
				resultArr[i] = 0;
			}else{
				height = A[i];
				resultArr[i] = 0;
			}
		}
		
		return result;
	}

}
