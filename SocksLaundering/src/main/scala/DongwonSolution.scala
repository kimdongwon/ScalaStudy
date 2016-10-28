/**
  * Created by dongwon on 2016-10-28.
  */
object DongwonSolution {
  def main(args : Array[String]) = {
    print(solution1(2, Array(1,2,1,1), Array(1, 4, 3, 2, 4)))
  }

  def solution1(k: Int, c: Array[Int], d: Array[Int]): Int ={
    def isOddNumber(v:(Int,Int)) = (v._2 & 0x1) == 0x1
    def getPairCount(v1:Int, v2:Int) = v1/2 + v2/2
    def getNumberCountTuple(v:Array[Int]) :Map[Int,Int] = v.groupBy(identity).mapValues(_.length)

    var kk = k
    var pairCount = 0
    val cp = getNumberCountTuple(c).partition(isOddNumber)
    if(cp._1.nonEmpty){
      pairCount += cp._1.values.fold(0)(getPairCount)
    }
    if(cp._2.nonEmpty){
      pairCount += cp._2.values.fold(0)(getPairCount)
    }

    val dp = getNumberCountTuple(d).partition(isOddNumber)
    var one = 0
    if(dp._1.nonEmpty){
      one = getNumberCountTuple(Array.empty ++ cp._1.keys ++ dp._1.keys).count(_._2 == 2)
    }
    if(one <= kk){
      pairCount += one
      kk -= one
      kk = kk/2
      var two = 0
      if(dp._2.nonEmpty){
        two = dp._2.values.fold(0)(getPairCount)
      }
      if(two <= kk){
        pairCount += two
      }else{
        pairCount += kk
      }
    }else{
      pairCount += kk
    }
    pairCount
  }

  def solution2(k: Int, c: Array[Int], d: Array[Int]): Int ={
    var kk = k
    var pairs = new Array[Boolean](51)
    var pairCount = 0
    var one = 0
    var two = 0

    c.foreach((v:Int) => {
      pairs(v) = !pairs(v)
      if(!pairs(v)){
        pairCount += 1
      }
    })

    var check = new Array[Boolean](51)
    d.foreach((v:Int) => {
      pairs(v) = !pairs(v)
      if(!pairs(v)){
        if(check(v)){
          two += 1
        }else{
          one += 1
        }
      }
      check(v) = true
    })

    if(one <= kk){
      pairCount += one
      kk -= one
      kk = kk/2
      if(two <= kk){
        pairCount += two
      }else{
        pairCount += kk
      }
    }else{
      pairCount += kk
    }
    pairCount
  }
}
