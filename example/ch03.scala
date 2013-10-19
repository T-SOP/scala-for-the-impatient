object example3 extends Application {
  
  
	// 1
	val n = 10
	val a = {
	  import java.util.Random
	  val rand = new Random(System.currentTimeMillis());
	  for( t <- 0 to n - 1 ) yield rand.nextInt( n )
	}
	
	val a2 = {
	  import scala.util.Random
	  Random.shuffle( 0 to n - 1 )
	  
	}
	
	println( a );
	println( a2 );
	
	
	// 2 
	
	var t2 = Array( 1, 2, 3, 4, 5 )
	for( tmp <- 1 to t2.length - 1 if tmp % 2 != 0 ){
	  val odd = t2( tmp )
	  t2( tmp ) = t2( tmp - 1 )
	  t2( tmp -1 ) = odd
	}
	
	for( tmp <- t2 ) print( tmp + " " );
	println(" " );

	
	// 3
	var t3 = Array( 1,2,3,4,5 )
	
	val t3_result = 
	  for( tmp <- 0 to t3.length - 1 ) yield { 
		  
			// 인덱스가 짝수 일때
		  if( tmp % 2 == 0 ){
		    
			  if( t3.length -1 == tmp ) t3( tmp )		// 짝수 번째 인대 끝났다면 현재 값으로 셋팅
			  else 					 t3(tmp + 1 )	// 다음 값
		  }else{
			  t3( tmp - 1 )	// 홀수 번째 인덱스는 무조건 앞의 값
		  } 
		  
		}
	println( t3_result.mkString(",") );
	
	// 4 
	val t4 = Array( 1, 4, 2, -1,2,-5,-6,7,0 );
	
	val t4_result = (for( tmp <- t4 if tmp > 0 ) yield tmp ) ++
					(for( tmp <- t4 if tmp == 0 ) yield tmp) ++
					(for( tmp <- t4 if tmp < 0 ) yield tmp );
	
	val t4_result2 = t4.filter( _ > 0 ) ++ t4.filter( _ == 0 ) ++ t4.filter( _ < 0 )
	
	println( t4.mkString( "," ) )
	println( t4_result.mkString(",") )
	println( t4_result2.mkString(",") )
	  
	
	// 5 
	
	val t5 = Array[Double]( 0.1, 9.2, 10.1 );
	println( "avg : " + t5.sum / t5.length );
	
	// 6
	import scala.collection.mutable.ArrayBuffer;
	
	val t6 = Array[Int](4,2,3,1,2,4,8);
	val t6_buff = ArrayBuffer[Int](4,2,3,1,2,4,8);
	val t6_rev_sorted = t6.sortWith(_ > _);
	val t6_buff_rev_sorted = t6_buff.sortWith( _ > _ );
	
	println( " " + t6_rev_sorted.mkString(",") )
	println( " " + t6_buff_rev_sorted.mkString(",") )
	
	
	// 7
	val t7 = Array[Int](4,2,3,1,2,4,8);
	println( t7.distinct.mkString(",") );
	
	// 8
	

}
