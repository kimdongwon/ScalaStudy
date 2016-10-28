import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dongwon on 2016-10-28.
  */
class DongwonSolutionTest extends FlatSpec with Matchers {

  it should "Solution1 Test" in {
    DongwonSolution.solution1(2, Array(1,2,1,1), Array(1, 4, 3, 2, 4)) should be (3)
  }

  it should "Solution2 Test" in {
    DongwonSolution.solution2(2, Array(1,2,1,1), Array(1, 4, 3, 2, 4)) should be (3)
  }
}
