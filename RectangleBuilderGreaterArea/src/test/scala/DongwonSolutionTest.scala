import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by dongwon on 2016-10-28.
  */
class DongwonSolutionTest extends FlatSpec with Matchers {
  it should "Solution Test" in {
    DongwonSolution.solution(Array(1,2,5,1,1,2,3,5,1), 5) should be (2)
    DongwonSolution.solution(Array(6, 6, 6, 6, 6, 6), 10) should be (1)
    DongwonSolution.solution(Array(2, 3, 2, 3, 2, 3, 2, 3), 9) should be (1)

  }
}
