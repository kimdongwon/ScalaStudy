import java.util.*;

public class Solution {
	public int solution(int[] A) {
		List<Integer> upNumberCountList = new ArrayList<>();
		List<Integer> downNumberCountList = new ArrayList<>();

		int upNumberCount = 1;
		Set<Integer> upSet = new LinkedHashSet<>();
		for (int i = 0; i < A.length; i++) {
			if (upSet.isEmpty()) {
				upSet.add(A[i]);
				upNumberCount = 1;
				continue;
			}
			if (upSet.contains(A[i]) == false) {
				upNumberCountList.add(upNumberCount);
				upSet.add(A[i]);
				upNumberCount = 1;
			} else {
				upNumberCount++;
			}
		}
		upNumberCountList.add(upNumberCount);

		int downNumberCount = 1;
		Set<Integer> downSet = new LinkedHashSet<>();
		for (int i = A.length - 1; i >= 0; i--) {
			if (downSet.isEmpty()) {
				downSet.add(A[i]);
				downNumberCount = 1;
				continue;
			}
			if (downSet.contains(A[i]) == false) {
				downNumberCountList.add(downNumberCount);
				downSet.add(A[i]);
				downNumberCount = 1;
			} else {
				downNumberCount++;
			}
		}
		downNumberCountList.add(downNumberCount);

		int count = 0;
		int lastTrueIndex = -1;
		Integer[] upBaseArr = upSet.toArray(new Integer[upSet.size()]);
		Integer[] downBaseArr = downSet.toArray(new Integer[downSet.size()]);
		Set<Integer> upCompareSet = new TreeSet<>();
		for (int upIndex = 0; upIndex < upBaseArr.length; upIndex++) {
			upCompareSet.add(upBaseArr[upIndex]);
			boolean isSame = true;
			for (int downIndex = (lastTrueIndex + 1); downIndex <= upIndex; downIndex++) {
				if (upCompareSet.contains(downBaseArr[downIndex]) == false) {
					isSame = false;
					break;
				}
			}
			if (isSame) {
				count += (upNumberCountList.get(upIndex) * downNumberCountList.get(upIndex));
				lastTrueIndex = upIndex;
			}
			if (count > 1000000000) {
				return 1000000000;
			}
		}
		return count;
	}
}