
object ch02 extends App {
  println("Scala-for-the-Impatient Chapter 2.제어 구조와 함수 - 연습문제")
  
  // ex01
  def signnum(a: Int) = {
    var result = 0
    if (a > 0) {
      result = 1
    } else if (a < 0) {
      result = -1
    }
    result
  }
  println(signnum(3))
  println(signnum(-2))
  println(signnum(0))
  
  // ex04
  for (i <- 0 to 10) println(10 - i)
  
  // ex05
  def countdown(n: Int) {
    for (i <- (0 to n).reverse) println(i)
  }
  countdown(10)
  
  // ex06, 08
  def product(s: String) {
    var result:Long = 1
    for (ch <- s) {
      result *= ch.toInt
    }
    println(result)
  }
  product("Hello")
  
  // ex07
  def product_alt(s: String) {
    println(s.foldLeft(1L)(_ * _.toInt))
    // println(s.foldRight(1L)(_.toInt * _))
  }
  product_alt("Hello")
  
  // ex09
  def product_rec(s: String): Long = {
    if (s.length == 0) 1L
    else s(0).toInt * product_rec( s.slice(1, s.length) )
  }
  println(product_rec("Hello"))
  
  // ex10
  def square(n: Double, x: Double): Double = {
    if (n == 0) 1L
    else if (n > 0) {
      if (n%2 == 0) {
        val y = square(n/2, x)
        y * y
      } else {
        x * square(n-1, x)
      }
    } else {
      1 / square(n*(-1), x)
    }
  }
  println("2^4 = " + square(4, 2))
  println("2^-1 = " + square(-1, 2))
  
}