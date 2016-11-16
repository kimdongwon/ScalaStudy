import scala.collection.JavaConverters._
import scala.collection.mutable

object Solution {
  def solution(a: Array[Int]): Int = {
    val incSet = new mutable.HashSet[Int]
    val decSet = new mutable.HashSet[Int]
    var unPairedSet = new mutable.HashSet[Int]
    var upper = a.length-1
    var lower = 0
    var answer = 0
    while(lower<a.length && upper > -1){
      if(incSet.size>decSet.size){
        val tempUnpairedSet = new mutable.HashSet[Int]
        while(unPairedSet.nonEmpty && upper != -1){
          decSet.add(a(upper))
          if(unPairedSet.contains(a(upper)))
            unPairedSet.remove(a(upper))
          else if(!incSet.contains(a(upper)))
            tempUnpairedSet.add(a(upper))
          upper-=1
        }
        upper+=1
        unPairedSet = tempUnpairedSet
      }
      else if(incSet.size<decSet.size){
        val tempUnpairedSet = new mutable.HashSet[Int]
        while(unPairedSet.nonEmpty && lower != a.length){
          incSet.add(a(lower))
          if(unPairedSet.contains(a(lower)))
            unPairedSet.remove(a(lower))
          else if(!decSet.contains(a(lower)))
            tempUnpairedSet.add(a(lower))
          lower+=1
        }
        lower-=1
        unPairedSet = tempUnpairedSet
      }
      else if(unPairedSet.isEmpty){
        var tmpl = lower
        var tmpu = upper

        while(tmpl<a.length &&incSet.contains(a(tmpl)))
          tmpl+=1

        while(tmpu > -1 && decSet.contains(a(tmpu)))
          tmpu-=1

        answer += (tmpl-lower) * (upper - tmpu)
        if(answer>1000000000)
          return 1000000000
        lower = tmpl
        upper = tmpu


        if(lower<a.length) {
          incSet.add(a(lower))
          unPairedSet.add(a(lower))
        }
        else
          return answer
      }
      else
        return 0
    }
    answer
  }

}
