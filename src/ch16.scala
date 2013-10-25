import xml._
import scala.xml.Elem
import scala.xml.parsing.XhtmlParser
import scala.xml.dtd.DocType

object ch16 extends App{
  println("Scala-for-the-Impatient Chapter 16.XML 처리 - 연습문제")
  
  def ex02() {
    val x =
<ul>
  <li>Opening bracket: [</li>
  <li>Closing bracket: ]</li>
  <li>Opening brace: {{</li>
  <li>Closing brace: }}</li>
</ul>
    println(x)
  }
  ex02()
  
  def ex03() {
    <li>Fred</li> match { case <li>{Text(t)}</li> => t }
    <li>{"Fred"}</li> match { case <li>{t: Atom[_]}</li> => t }
  }
  ex03()
  
  def ex04(file: String) {
    val parser = new XhtmlParser(io.Source.fromFile(file))
    var root = parser.initialize.document.docElem
    var imgs = root \\ "img"
    for (img <- imgs if img.attributes.get("alt") == None) {
      println(img)
    }
  }
  //ex04("ch16.xml")
  
  def ex05(file: String) {
    val parser = new XhtmlParser(io.Source.fromFile(file))
    var root = parser.initialize.document.docElem
    var imgs = root \\ "img"
    for (img <- imgs if img.attributes.get("src") != None) {
      println(img.attributes("src"))
    }
  }
  //ex05("ch16.xml")
  
  def ex07(map: Map[String, String]): Elem = {
    val items = for (i <- map)
      yield { <xml:group><dt>{i._1}</dt><dd>{i._2}</dd></xml:group> }
    <dl>{items}</dl>
  }
  val input07 = Map("A" -> "1", "B" -> "2")
  println(ex07(input07))
  
  def ex08(dl: Elem): Map[String, String] = {
    val dts = (dl \ "dt").map { _.child(0).toString }
    val dds = (dl \ "dd").map { _.child(0).toString }
    dts.zip(dds).toMap
  }
  val input08 = <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>
  println(ex08(input08))
}