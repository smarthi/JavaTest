import math.abs

object sqrt {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrt(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1)

  def main(args: Array[String]): Unit = {
    println(sqrt(2))
  }
}

object rationals {
  val x  = new Rational(1,2)
  x.numer
  x.denom
  x.add(new Rational(1,2))
}

class Rational(x: Int, y:Int) {
  def numer = x
  def denom = y

  def add(that: Rational) = {
    new Rational(
      numer * that.denom + that.numer * denom, that.denom * denom
    )

  }
}