	//Example 06
	object Hi extends App { 
	
		// 01
	  object Conversions {
    
	    def inchesToCentimeters( inc: Int ):Double = {
    		inc * 2.54;      
	    }
    
	    def gallonsToLiters( src:Int ) = {
    		src * 3.78541178
	    }
    
    	def milesToKilometers( src:Int ) = {
    	  src * 1.609344
   		}
    
  		};

  		println("exampel 01 : " +  Conversions.inchesToCentimeters(10) );
  		println("exampel 01 : " +  Conversions.gallonsToLiters(10) );
  		println("exampel 01 : " +  Conversions.milesToKilometers(10) );
  		
  		
  		// 02
  		abstract class UnitConversion {
  			def conversion( src: Int ): Double;
  		}
  		object InchesToCentimeters extends UnitConversion() {
  			override def conversion( src: Int ): Double = {
  				src * 2.54
  			}
  		}
  		object gallonsToLiters extends UnitConversion() {
  			override def conversion( src: Int ): Double = {
  				src * 3.78541178
  			}
  		}
  		object milesToKilometers extends UnitConversion() {
  			override def conversion( src: Int ): Double = {
  				src *  1.609344
  			}
  		}
  		println( "example 02 : " + InchesToCentimeters.conversion(10) );
  		println( "example 02 : " + gallonsToLiters.conversion(10) );
  		println( "example 02 : " + milesToKilometers.conversion(10) );
	
		//03
		import java.awt.Point;
		
		object Origin extends Point {
		}
		
		println( "example 03 : " + Origin.toString() );
		
		//04
		object Point {
			def apply( x:Int, y:Int ): Point = {
				val ret = new Point( x, y );
				ret
			}
		}
		
		println("example 04 : " + Point(10,10).toString );
		
		// 05
		
		val argc = "scala Reverse Hello World";
		val argc_split = argc.split(" ");
		val argc_add_splice = for( t <- argc_split ) yield t + " ";
		print( "example 05 : " );
		argc_add_splice.reverse.map( print _ );
		println("");
	
		// 06
		
		object CardSet extends Enumeration {
			type CardSet = Value
			val Clover = Value("C");
			val Dia = Value("D");
			val Heart = Value("H");
			val Spade = Value("S");
		
		}
		
		for( c <- CardSet.values ) println( "Example 06 : " + c.id + " " + c )
		
		// 07
		def CardisRed( card: CardSet.CardSet ): Boolean = {
			card match {
				case CardSet.Clover => false
				case CardSet.Spade	=> false
				case _ => true
			}
		}
		
		println("Example 07 : Spade(" + CardisRed( CardSet.Spade ) + ")" );
		println("Example 07 : Heart(" + CardisRed( CardSet.Heart ) + ")" );
	
		// 08 
			// 문제를 이해 하지 못하였음....
	}
