import scala.collection.JavaConverters._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
  def solution(a: Array[Int], x: Int): Int = {
    var result:Int = 0
    val groupByB = a.map(_.toLong).groupBy(identity).mapValues(_.length).filter((t) => t._2 > 1).toSeq.sortBy(_._1)
    var index = -1
    for(i <- 1 until groupByB.length) {
        if (index > 0) {
          index = index - (index - 1 to 0 by -1).takeWhile(groupByB(i)._1 * groupByB(_)._1 >= x).length
        } else if (index == -1) {
          val count = (i-1 to 0 by -1).takeWhile(groupByB(i)._1 * groupByB(_)._1 >= x).length
          if(count > 0){
            index = i - count
          }
        }

      if(index != -1) {
        result += (i - index)
        if (result > 1000000000) return -1
      }
    }

    result += groupByB.filter(k => (k._2 > 3 && k._1 * k._1 >= x)).length
    result
  }
}
