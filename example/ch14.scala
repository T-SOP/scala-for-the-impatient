object example14 extends Application {

  abstract class Item
  case class Article(description:String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item
  
  val t = Bundle( "Father's day special", 20.0, 
		      Article("Scala for the Impatient", 39.95), 
			      Bundle( "Anchor Distillery Sampler", 10.0 , 
			      Article( "Old Potrero Straight Rye Whiskey", 79.95), 
			      Article( "Junipero Gin", 32.95 ) ) )
  
  println( t );
  
  // P2.
  val temp2 = ( 1, 2 )
  
  def swap( value: (Int, Int ) ) = value match {
    case ( x, y ) => (y, x )
    case _ => (0, 0)
  }
  
  println( swap( temp2 ) );
  
  
  // P3.
  def swap_arry( value: Array[Int] ) = value match {
    case Array( x, y ) => Array[Int]( y, x )
    case _ => value
  }
  
  println( swap_arry(  Array( 1, 2 ) ).deep )
  
  // P4.
  	// 간단해서 뛰어넘기
  
  // P5.
  
  val temp5 = List[Any]( List(3, 8), 2, List(5) );
  
  /*
  def leafSum( v: List[Any] ):Int = v match{
    case Nil => 0
  	case x :: tail => leafSum( x ) + leafSum( tail )
//    
//    case List( x: Int )	=> x
//    case List( x: List[Any], t* ) => x + leafSum( t )
//  	case List( x: Int, y:List[Any] ) => x + leafSum( y )
  	
//  	case List( x:List[Any] ) => leafSum( x )
  	case x => { println( "is not matched : " + x ); 0 }
  }
  * */
 

  def leafSum( list: List[Any] ): Int = {
    
    if( list.isEmpty ) 0
    else
    {
	    val hr = list.head match {
	      case Nil => 0
	      case i: Int => i
	      case n: List[Any] => leafSum( n )
	      case _ => 0
	    }
	    
	    hr + leafSum( list.tail )
    }
  }

  println( "Sum " + leafSum( temp5 ) )
  
  
  // P6.
  
  	// 바이너리 트리로 구현
  
  // P7.
  
  abstract class Tree
  case class tNode( n: Tree* ) extends Tree;
  case class tLeaf( n: Int ) extends Tree;
  
  val tree_sample = tNode( 
      tNode( tLeaf(3), tLeaf(8) ), 
      tLeaf(2),
      tNode( tLeaf(5)));
  
  def leafSum_case( t: Tree ): Int = t match {
    case tLeaf( n ) => n
    case tNode( n @ _* ) => n.map( leafSum_case _ ).sum
    case _ => 0
  }
  println( leafSum_case( tree_sample ) );
  
  
  // P8.
  abstract class calcTree
  case class ctNode( o:Char, n: calcTree* ) extends calcTree;
  case class ctLeaf( n: Int ) extends calcTree;
  
  val tree_sample8 = ctNode( '+', 
      ctNode( '*', ctLeaf(3), ctLeaf(8) ), 
      ctLeaf(2),
      ctNode( '-', ctLeaf(5)));
  
  def p8Eval( t: calcTree): Int = t match {
    case ctLeaf( n ) => n
    case ctNode( o, n @ _* ) if o == '+'  => n.map( p8Eval( _ ) ).sum
    case ctNode( o, n @ _* ) if o == '-'  => n.map( p8Eval( _ ) * -1 ).sum
    case ctNode( o, n @ _* ) if o == '*'  => n.map( p8Eval( _ ) ).reduce( _ * _ )
    case ctNode( o, n @ _* ) if o == '.'  => n.map( p8Eval( _ ) ).reduceLeft( _ / _ )
    case _ => 0
  }
  
  println( "p8 : " + p8Eval( tree_sample8 ) )
  
  
  // P9.
  val temp9 = List[Option[Int]]( Option(10), None, Option(20) );
  def sum_opt( l: List[Option[Int]] ):Int ={
	  var temp9_vv:Int = 0
	  for( t9 <- l )
	    temp9_vv = temp9_vv + t9.getOrElse(0);
	  temp9_vv;
  }
  println( sum_opt( temp9 ) );
  
  // P10.
  
  def compose( f: Double => Option[Double],
		  	   g: Double => Option[Double]) = ( x:Double ) =>  {
    
	if( f( x ) == None || g( x ) == None ) None
    else f( x ) 
    
  }
  
  def f( x: Double ) = if ( x >= 0 ) Some( Math.sqrt(x) ) else None
  def g( x: Double ) = if( x != 1 ) Some( 1/(x-1) ) else None
  val h = compose(f,g)
  
  println( h(1) );
  
  
}
