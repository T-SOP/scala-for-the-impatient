object ch14 extends App {
  println("Scala-for-the-Impatient Chapter 14.패턴 매칭과 케이스 클래스 - 연습문제")
  
  def ex02(pair: (Int, Int)) = pair match {
    case (x, y) => (y, x)
  }
  println("2-swap: "+ex02((2,3)))
  
  def ex03(arr: Array[Int]) = arr match {
    case Array(a, b) => Array(b, a)
    case _ => arr
  }
  println("3-swapArray: "+ex03(Array(1,3)).deep)
  
  def ex05(list: List[Any]): Int = {
    if (list.isEmpty) 0
    else {
      val output = list.head match {
        case i: Int => i
        case n: List[Any] => ex05(n)
        case _ => 0
      }
      output + ex05(list.tail)
    }
  }
  val input05 = List(List(3, 8), 2, List(5))
  println("5-leafSum: "+ex05(input05))
  
  sealed abstract class Tree
  case class Leaf(value: Int) extends Tree
  case class bNode(left: Tree, right: Tree) extends Tree
  def ex06(tree: Tree): Int = tree match {
    case leaf: Leaf => leaf.value
    case node: bNode => ex06(node.left) + ex06(node.right)
    case _ => 0
  }
  val input06 = bNode(bNode(Leaf(3), Leaf(8)), bNode(Leaf(5), Leaf(1)))
  println("6-leafSum2: "+ex06(input06))
  
  case class pNode(children: Tree*) extends Tree
  def ex07(tree: Tree): Int = tree match {
    case leaf: Leaf => leaf.value
    case node: bNode => 0
    case node: pNode => node.children.foldLeft(0)(_ + ex07(_))
  }
  val input07 = pNode(pNode(Leaf(3), Leaf(8)), Leaf(2), pNode(Leaf(5)))
  println("7-leafSum3: "+ex07(input07))
  
  sealed abstract class OpTree
  case class Num(value: Double) extends OpTree
  case class Plus(children: OpTree*) extends OpTree
  case class Minus(child: OpTree) extends OpTree
  case class Mul(children: OpTree*) extends OpTree
  case class Div(left: OpTree, right: OpTree) extends OpTree
  def ex08(tree: OpTree): Double = tree match {
    case v: Num => v.value
    case t: Plus => t.children.foldLeft(0.0)(_ + ex08(_))
    case x: Minus => -ex08(x.child)
    case f: Mul => f.children.foldLeft(1.0)(_ * ex08(_))
    case d: Div => ex08(d.left) / ex08(d.right)
  }
  val input08 = Plus(Mul(Num(3), Num(8)), Num(2), Minus(Num(5)))
  println("8-OpTree: "+ex08(input08))
  
  def ex09(list: List[Option[Int]]) = list.foldLeft(0)(_ + _.getOrElse(0))
  val input09 = List[Option[Int]](Option(5), None, Option(3))
  println("9-listSum: "+ex09(input09))
  
}