import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer

object minmax
{

	def minmax(arr:ArrayBuffer[Int]):(Int,Int)=
	{
		return(arr.min,arr.max)
		
	}
	
	def main(args:Array[String])
	{
	
		var arr= new ArrayBuffer[Int]()
		printf("enter thr number of employess")
		var n= scala.io.StdIn.readInt()
		
		printf("elements")
		for (i <- 0 until n)
		{
		
			arr+=scala.io.StdIn.readInt()
		}
		
		val res=minmax(arr)
	
		print("min"+res._1+"max"+res._2)
	}


}
