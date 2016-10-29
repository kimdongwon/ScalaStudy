import scala.collection.mutable.ListBuffer
/**
  * Created by taehyuk on 16-10-29.
  */

object TeahyukSolution {

  def main(args : Array[String]) = {
    print(solution1(2, Array(1,2,1,1), Array(1, 4, 3, 2, 4)))
  }

  def solution(k: Int, c: Array[Int], d: Array[Int]): Int = {
    var clean = 0
    var canRund = k
    val unfair = ListBuffer[Int]()
    for(i <- c)
    {
      if (unfair.contains(i)){
        unfair.-=(i)
        clean += 1
      }
      else {
        unfair += i
      }
    }
    var dirty = d.to[ListBuffer]
    if(canRund>0)
      for(i <- unfair)
      {
        if(dirty.contains(i)) {
          dirty.-=(i)
          clean += 1
          canRund -= 1

          if(canRund.equals(0))
            return clean
        }
      }
    var i = 0
    while(canRund>1 && i<dirty.length)
    {
      if(dirty.-(dirty(i)).contains(dirty(i)))
      {
        val elem = dirty.apply(i)
        dirty.-=(elem)
        dirty.-=(elem)
        clean += 1
        canRund -= 2
      }
      else
        i += 1
    }


    clean
  }

}