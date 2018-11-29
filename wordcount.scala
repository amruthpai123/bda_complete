import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object wordcount
{
	def main(args:Array[String])
	{
		val filename=args(0)
		val conf= new SparkConf()
			 .setAppName("name")
			 .setMaster("local[*]")
			 
		val cs= new SparkContext(conf)
		
		val wordrdd = cs.textFile(filename)
				.flatMap(_.split(" "))
		val lowerrdd= wordrdd.map(x=>x.toLowerCase)
		
		val wordcountrdd= lowerrdd.map((_,1)).reduceByKey(_+_)
		
		val frequentrdd = wordcountrdd.filter(x=>x._2>4)
		
		frequentrdd.saveAsTextFile("wordcount")
	
	
	
	
	}




}

