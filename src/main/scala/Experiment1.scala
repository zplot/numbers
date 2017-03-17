import IntegerP._
import Utils._
import scala.collection.immutable.SortedMap



object Experiment1 extends App {

  val s4: Integer = Prime(7)

  val map1 = SortedMap(Prime(2) -> Prime(3), Prime(3) -> Composite(SortedMap(Prime(2) -> Prime(3))))
  val s5: Integer = Composite(map1)

  println(s5)

  val z = BigInt(7*7*7*7)
  println(primeFactors(z))
  println(fromBigIntToSortedMap(z))
  println

  println("Lo difícil")
  println
  println("z = " + z)
  println("primeFactors(z) = " + primeFactors(z))
  println(fromBigIntToInteger(z))

}


