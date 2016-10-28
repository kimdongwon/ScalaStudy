import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dongwon on 2016-10-28.
  */
class DongwonSolutionTest extends FlatSpec with Matchers {
  it should "Solution Test" in {
    DongwonSolution.solution(Array(1,2,5,1,1,2,3,5,1), 5) should be (2)
  }
}
