/**
  * Created by dongwon on 2016-10-28.
  * https://codility.com/programmers/lessons/91-tasks_from_indeed_prime_2016_challenge/rectangle_builder_greater_area/
  */
object DongwonSolution {
  def solution(a: Array[Int], x: Int): Int = {
    def getNumberCountTuple(v:Array[Int]) :Map[Long,Int] = v.map(_.toLong).groupBy(identity).mapValues(_.length)

    val numberCountMap = getNumberCountTuple(a)
    val useNumbers  = (Array() ++ numberCountMap.filter(_._2 >= 2).keySet).sorted

    var possibleValue = useNumbers.filter(numberCountMap(_) >= 4).reverse.takeWhile(v => v*v >= x).length
    var possibleIndex = -1
    for (i <- 1 until useNumbers.length){
      var startIndex = 0
      if(possibleIndex == -1){
        startIndex = i
      }else{
        startIndex = possibleIndex
      }

      val count = (startIndex-1 to 0 by -1).takeWhile(useNumbers(_) * useNumbers(i) >= x).length
      if(count > 0){
        possibleIndex = startIndex - count
      }
      if(possibleIndex != -1){
        possibleValue = possibleValue + i - possibleIndex
        if(possibleValue >= 1000000000){
          -1
        }
      }
    }
    possibleValue
  }
}
