/**
  * Created by LuisFontes on 26/02/2017.
  */


import scala.collection.immutable.SortedMap
import Utils._




object IntegerP extends App {


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

      if (isPrime(a)) Prime(a) else {

        val b: SortedMap[Prime, BigInt] = fromBigIntToSortedMap2(a)

        val c = for (i <- b) yield {

          if (isPrime(i._2) || i._2 == 1) (i._1, Prime(i._2)) else (i._1, Composite(SortedMap(i._1 -> fromBigIntToInteger(i._2))))
        }

        Composite(c)
      }


    }


    loop(x)


  }





  val s4: Integer = Prime(7)

  val map1 = SortedMap(Prime(2) -> Prime(3), Prime(3) -> Composite(SortedMap(Prime(2) -> Prime(3))))
  val s5: Integer = Composite(map1)

  println(s5)

  val z = BigInt("8752874")
  println(primeFactors(z))
  println(fromBigIntToSortedMap(z))
  println
  println
  println("Lo difícil")
  println

  println(fromBigIntToInteger(z))













}