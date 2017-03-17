/**
  * Created by LuisFontes on 26/02/2017.
  */


import scala.collection.immutable.{Iterable, SortedMap}
import Utils._


object IntegerP {


  trait Integer

  //class One extends Integer

  case class Prime(value: BigInt) extends Integer with Ordered[Prime] {
    def compare(that: Prime): Int = this.value compare that.value
  }

  case class Composite(map: SortedMap[Prime, Integer]) extends Integer


  def fromBigIntToSortedMap(number: BigInt): SortedMap[BigInt, BigInt] = {
    val map = primeFactors(number).toMap
    SortedMap[BigInt, BigInt]() ++ map
  }

  def fromBigIntToSortedMap2(number: BigInt): SortedMap[Prime, BigInt] = {
    val map: Map[BigInt, BigInt] = primeFactors(number).toMap
    val map2: SortedMap[BigInt, BigInt] = SortedMap[BigInt, BigInt]() ++ map
    map2.map(x => (Prime(x._1), x._2))
  }


  def fromBigIntToInteger(x: BigInt): Integer = {
    def loop(a: BigInt): Integer = {
      println("a = " + a)
      println("isPrime(a) = " + isPrime(a))
      if (isPrime(a)) Prime(a) else {
        val b: SortedMap[Prime, BigInt] = fromBigIntToSortedMap2(a)
        println("b = " + b)
        val c = for (i <- b) yield {
          println("i = " + i)
          //if (isPrime(i._2) || i._2 == 1) (i._1, Prime(i._2)) else (i._1, Composite(SortedMap(i._1 -> loop(i._2))))
          if (isPrime(i._2) || i._2 == 1) (i._1, Prime(i._2)) else (i._1, loop(i._2))
        }
        println("c = " + c)
        Composite(c)
      }
    }
    loop(x)
  }

  def numberComposites(x: Composite): Int = {

    4

  }




















}