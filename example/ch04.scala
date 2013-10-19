object example4 extends Application {
  
  val in = new java.util.Scanner( new java.io.File( "/Users/famersbs/Downloads/scala-2.10.2/bin/scaladoc.bat") )
  val word_cnt = new scala.collection.mutable.HashMap[String, Int];
  
  while( in.hasNext() ){  
    val words = in.nextLine().split(" ");
    
    for( word <- words ){
    	word_cnt( word ) = word_cnt.getOrElse(word, 0) + 1 ;
    }
    try{
    in.next();
    }catch{
      case ex:java.io.IOException => println( "exception " + ex )
      case ex:java.util.NoSuchElementException => println("exception " + ex )
    }
  }
  
  for( (key, value) <- word_cnt ){
    
    println( key + " " + value );
    
  }
  
  import java.util.{HashMap => _, _ }
  //import java.util._
  import scala.collection.mutable._
  
  val test = new HashMap;
  println( HashMap.getClass() );
  
  class creature {
    val range:Int = 10;
    println( "class : " + this.getClass() + " range " + range)
  }
  
  class Bug( ) extends {
    //println( "class : " + this.getClass() )
    
  } with creature
  {
    override val range:Int = 2;
    println( "class : " + this.getClass() + " range " + range + " "  )
  }
  
  new creature
  new Bug
  
  import scala.io.Source
  val source3 = Source.stdin
  //println( source3.bufferedReader.read() );
 
  trait Logger{
    def log( msg: String )
  }
  
  trait Logger_test extends Logger{
    
  }
  
  trait Logger_console extends Logger {
    abstract override def log( msg: String ){
      
      println( "sss " + msg );
      super.log( msg );
    }
  }
  
  trait Logger_console2 extends Logger {
     abstract override def log( msg: String ){
      println( "sss2 " + msg );
      super.log( msg );
    }
  }
  
  class Logger_real extends Logger{
    
    override def log( msg: String){
      //super.log(msg)
    }
    
    def test(msg:String){
      log(msg);
    }
  }
  
  val log_real = new Logger_real with Logger_console with Logger_test with Logger_console2;
  
  log_real.test("sbs")
  
  
  val log_real2 = new Logger_real with Logger_console with Logger_console2;
  log_real2.test("sbs2")
  
}
