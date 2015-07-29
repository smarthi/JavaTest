object Rational {

  val x = new Rational(1,3)
  val y = new Rational(5,7)
  val z = new Rational(3,2)

  def main(args: Array[String]) : Unit = {
    println(x.sub(y).sub(z))
  }

}

class Rational(x: Int, y:Int) {
  require(y != 0, "denominator must be non-zero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a%b)
  private val g = gcd(x,y)
  def numer = x
  def denom = y

  def + (that: Rational) = {
    new Rational(
      numer * that.denom + that.numer * denom, that.denom * denom
    )
  }

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def unary_- = new Rational(-numer, denom)

  def max(that: Rational) = if (this < that) that else this

  def - (that: Rational) = this + -that

  override def toString = numer /g + "/" + denom /g

}