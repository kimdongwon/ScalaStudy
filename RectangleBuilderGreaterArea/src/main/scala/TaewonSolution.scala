import scala.collection.immutable.TreeMap

object TaewonSolution {
	def solution(a: Array[Int], x: Int): Int = {
		val sortedInputMap = TreeMap(a.groupBy(identity).map(t => t._1 -> t._2.length).toArray: _*)
		var totalCount: Long = sortedInputMap.count(item => (item._2 >= 4) && ((x.toDouble / item._1.toDouble) <= item._1.toDouble))
		val notAloneNumberArr = sortedInputMap.filter(item => item._2 > 1).keySet.toArray
		var beginIndex: Int = 0
		var backIndex: Int = notAloneNumberArr.length - 1
		while (beginIndex < backIndex) {
			if ((x.toDouble / notAloneNumberArr(beginIndex).toDouble) <= notAloneNumberArr(backIndex).toDouble) {
				backIndex = backIndex - 1
			} else {
				totalCount = totalCount + (notAloneNumberArr.length - (backIndex + 1))
				beginIndex = beginIndex + 1
			}
		}
		val leftSize = notAloneNumberArr.length - (backIndex + 1)
		totalCount = totalCount + ((leftSize.toLong * (leftSize.toLong + 1)) / 2)
		if (totalCount > 1000000000) -1 else totalCount.toInt
	}
}
