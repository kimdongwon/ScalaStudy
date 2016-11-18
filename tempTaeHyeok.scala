import scala.collection.JavaConverters._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
  def solution(a: Array[Int]): Int = {
    val branches = new Array[Long](a.length+1)
    val branchBefore = new Array[Long](a.length+1)
    val max = 1000000000L
    // 3개 복붙한 배열 생성.
    val tripleArray = new Array[Array[Long]](a.length)
    for(i <- a.indices)
      tripleArray(i) =  Array[Long](a(i).asInstanceOf[Long],2*max - a(i).asInstanceOf[Long], 2*max + a(i).asInstanceOf[Long])

    var low = 0
    var high = 0
    var len = 0

    for(i <- tripleArray.indices){
      tripleArray(i).reverse.foreach(flag=>{

        high = len
        low = 1
        var mid = 0
        while(low<=high){
          mid = Math.ceil((low+high)/2).asInstanceOf[Int]
          if(flag<=branches(mid))
            high = mid-1
          else
            low = mid+1
        }
        if(low>len){
          branchBefore(low) = branches(low-1)
          branches(low) = flag
          len += 1
        }
        else if(flag<branches(low))
          branches(low) = flag
      })
    }
    len
  }
}
