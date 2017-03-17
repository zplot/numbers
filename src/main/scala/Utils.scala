/**
  * Created by LuisFontes on 15/03/2017.
  */





object Utils {

  def primeFactors(number: BigInt): List[(BigInt, BigInt)] = {

    // all prime factors with repetition
    def factorize(x: BigInt): List[BigInt] = {
      val zero = BigInt(0)
      def loop(x: BigInt, a: BigInt): List[BigInt] = if (a * a > x) List(x) else x % a match {
        case `zero` => a :: loop(x / a, a)
        case _ => loop(x, a + 1)
      }
      loop(x, 2)
    }

    val fact = factorize(number)

    val uniq: List[BigInt] = fact.toSet.toList
    val emptyList: List[(BigInt, BigInt)] = List[(BigInt, BigInt)]()
    val unflattened = for (i <- uniq) yield (i, BigInt(fact.count(_ == i))) :: emptyList
    unflattened.flatten
  }

  /** Return the divisors of n. */
  def divisors(n: BigInt): List[BigInt] = {
    val tmp1 = primeFactors(n)
    val tmp2 = for (i <- tmp1) yield i._1
    tmp2

  }
    //for (i <- List.range(BigInt(1), n+1) if n % i == 0) yield i

  /** Is 'n' a prime number? */
  def isPrime(n: BigInt) :Boolean = divisors(n).length == 2

}
