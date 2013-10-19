object example2 extends Application {

	// 1
	
	def signum_( numb:Int ) = {
		
		if( numb > 0 ) 1
		else if ( numb < 0 ) -1
		else 0
	
	};
	
	println( "120 = " + signum_( 120 ) ); 
	
	// 2 
	
	println( "{} : " + {} + " " +  {}.getClass );
	
	
	// 4
	var list = 0 to 10
	
	
	
	for( tmp:Int <- (0 to 10).reverse ) println( tmp );
	
	// 5
	
	def countdown( n: Int ) = {
		for( tmp:Int <- ( 0 to n ).reverse ) print( tmp +  " " );
	}
	
	countdown( 15 );
	
	println("---");
	
	// 6
	
	val hello_str = "Hello";
	var result:Long = 1;
	for( tmp <- hello_str ) result = result * tmp.toInt
	
	println( result );
	
	// 7
	
	var result2 = "Hello".foldLeft( 1L )( _ * _.toInt )
	
	println( result2 )
	
	
	// 8
	
	def product( s: String ) = {
		s.foldLeft( 1L )( _ * _.toInt )
	}
	
	println( product( "Hello" ) )
	
	
	// 9 
	
	def product_recu( s: String ):Long = {
	
		if( s.length == 0 ) 1L
		else s(0).toInt * product_recu( s.slice( 1, s.length ) )
	
    }
    
    println( product_recu( "Hello" ) )
    
    // 10 -- 너무 어려움
    
    def recur_exam10( n:Double, x:Double ):Double = {
    	println("exam10 : " + n + " " + x );
    	if( n == 0 ) 1L
    	else if( n > 0 ) {
    	
	    	if( n % 2 == 0 ){
	    		val y = recur_exam10( n / 2, x )
	    		y * y
	    	}
	    	else{
	    		x * recur_exam10( n - 1, x )
	    	}
    	}else{
    		1 / recur_exam10( n * -1 , x ) 
    	}
    }
    
    println( "10 : " + recur_exam10( 4, 2 ) )
    println( "10 : " + recur_exam10( -1, 2 ) )
    	
}
