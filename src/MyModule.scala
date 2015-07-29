import java.util.NoSuchElementException

object MyModule {
  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def factorial(n: Int): Int = {
    def go(n: Int, accum: Int): Int = {
      if (n <= 0) accum
      else go(n - 1, n * accum)
    }
    go(n, 1)
  }

  def fibonacci(n: Int): Int = {
    def go(n: Int, a: Int = 1, b: Int = 0): Int = n match {
      case 1 => b
      case _ => go(n - 1, b, b + a)
    }
    go(n)
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  def sum(xs: List[Int]): Int = {
    if (xs.isEmpty) 0
    else
      xs.head + sum(xs.tail)
  }

  def max(xs: List[Int]): Int = {
    if (xs.isEmpty) throw new NoSuchElementException("no list")
    def max(xs: List[Int], first: Int): Int = {
      if (xs.isEmpty) first
      else {
        val maxnum = max(xs.tail, xs.head)
        if (xs.head > maxnum) xs.head else maxnum
      }
    }
    max(xs.tail, xs.head)
  }

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r || r == 0) 1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 5, factorial))
    println(formatResult("fibonacci", 10, fibonacci))
    println(sum(List(1, 2, -1)))
    println(sum(List(5)))
    println(max(List(3, 4, 5)))
    println(pascal(4, 3))


  }
}

