/**
  * Created by teahyuk-dev on 2016-10-19.
  */

object test {
  def main(argv: Array[String]): Unit = {
    Solution.solution(Array(1,1,1,1,2,2,3,3,5,5,8,8,13,13,21,21,34,34,55,55),5)
  }
}

object Solution {
  def solution(a: Array[Int], x: Int): Int = {
    val groupedMap = a.map(_.toLong).groupBy(identity).mapValues(_.length).filter(p => p._2 > 1)
    val stickList = groupedMap.keySet.toList
    val size = stickList.length
    val sortedArr = stickList.sortWith(_ < _)
    var count = groupedMap.count { case (stick, cnt) => cnt > 3 && stick * stick >= x }
    var bottom = 0
    var top = size-1
    while(bottom<top){
      if((sortedArr(bottom)*sortedArr(top))>=x) {
        count += top - bottom
        if (count > 1000000000) return -1
        top -= 1
      }
      else
        bottom += 1
    }

    count
  }
}