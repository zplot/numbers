/**
  * Created by LuisFontes on 26/02/2017.
  */


import scala.collection.immutable.SortedMap
import Utils._




object IntegerP extends App {




  trait Integer

  case class Prime(value: BigInt) extends Integer with Ordered[Prime] {
    def compare(that: Prime): Int = this.value compare that.value
  }

  case class Composite(map: SortedMap[Prime, Integer]) extends Integer


  def fromIntToInteger(x: BigInt): Integer = {
    val fact: List[(BigInt, BigInt)] = primeFactors(x)
    val map1: Map[BigInt, BigInt] = fact.toMap




  }







  val s4: Integer = Prime(7)

  val map1 = SortedMap(Prime(2) -> Prime(3), Prime(3) -> Composite(SortedMap(Prime(2) -> Prime(3))))
  val s5: Integer = Composite(map1)

  println(s5)

  val z = BigInt("88898276234588")
  println(primeFactors(z))











}