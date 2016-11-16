
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PrefixSuffixSet {

	public static void main(String[] args) {
		int[] a = { 1, 9, 4, 1, 5, 9 };
//		int[] a = new int[100000];
//		for(int i=0; i<100000; i++){
//			a[i] = 1;
//		}
		System.out.println(solution2(a));
	}
	
	public static int solution2(int[] A) {
		int result = 0;
//		Set<Integer> groupByA = Arrays.stream(a).boxed().collect(Collectors.toSet());
		Set<Integer> ascA = new HashSet<>();
		Set<Integer> descA = new HashSet<>();
		
		int i = 0, j = A.length - 1;
		boolean flag = true;
		ascA.add(A[i]);
		descA.add(A[j]);
		while(i < A.length && j > -1) {
			flag = true;
			while(A[i] != A[j]){
				i++;
				ascA.add(A[i]);
			}
			while(ascA.size() > descA.size()){
				j--;
				descA.add(A[j]);
				if(ascA.contains(A[j]) == false){
					flag = false;
					break;
				}
			}
			
			if(ascA.size() == descA.size() && flag){
				int ascCount = 1, descCount = 1;
				while (i + ascCount < A.length) {
					if (ascA.contains(A[i + ascCount]) == false) {
						break;
					}
					ascCount++;
				}

				while (j - descCount > -1) {
					if (descA.contains(A[j - descCount]) == false) {
						break;
					}
					descCount++;
				}

				result += ascCount * descCount;
				if(result >= 1000000000){
					return 1000000000;
				}
				
				i += ascCount;
				j -= descCount;
				if(i < A.length){
					ascA.add(A[i]);
					descA.add(A[j]);
				}
			}
		}
		
		return result;
	}

	public static int solution(int[] a) {
		int result = 0;
		Set<Integer> groupByA = Arrays.stream(a).boxed().collect(Collectors.toSet());
		Set<Integer> ascA = new HashSet<>();
		Set<Integer> descA = new HashSet<>();
		Set<Integer> accureSet = new HashSet<>();

		int i = 0, j = a.length - 1;
		ascA.add(a[i]);
		descA.add(a[j]);
		
		while (i < a.length && j > -1) {
			if (ascA.size() == descA.size() && ascA.containsAll(descA)) {
				int ascCount = 1, descCount = 1;
				while (i + ascCount < a.length) {
//					if (ascA.contains(a[i + ascCount]) == false && accureSet.contains(a[i + ascCount]) == false) {
//						break;
//					}
					if (ascA.contains(a[i + ascCount]) == false) {
						break;
					}
					ascCount++;
				}

				while (j - descCount > -1) {
//					if (descA.contains(a[j - descCount]) == false && accureSet.contains(a[j - descCount]) == false) {
//						break;
//					}
					if (descA.contains(a[j - descCount]) == false) {
						break;
					}
					descCount++;
				}

				result += ascCount * descCount;
				i += ascCount;
				j -= descCount;
//				accureSet.addAll(ascA);
//				ascA.clear();
//				descA.clear();
				
				if(i < a.length){
					ascA.add(a[i]);
					descA.add(a[j]);
				}
			} else {
				if(ascA.size() > descA.size() && j > 0 && descA.size() < groupByA.size()){
					j--;
					descA.add(a[j]);
				}else if (i < a.length && ascA.size() < groupByA.size()) {
					i++;
					ascA.add(a[i]);
				}
			}
			if(result >= 1000000000){
				return 1000000000;
			}
		}

		return result;
	}
}
