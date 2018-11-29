import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import com.google.gson._
import org.apache.spark.rdd._

object twitterjson
{
	def main(args:Array[String])
	{
		val filename=args(0)
		val conf =new SparkConf()
				val cs= new SparkContext(conf)
		val twitterrdd= cs.textFile(filename).mapPartitions(TwitterUtil.fromJsonfile(_))
		val twitteruserrdd= twitterrdd.groupBy(tweet=>tweet.user)
		val twittercountrdd= twitteruserrdd.map(x=>(x._1,x._2.size))
		val twittersortrdd= twittercountrdd.sortBy(_._2,false)
		twittersortrdd.take(10).foreach(println)
		
	
	
	}



}
object TwitterUtil
{
	case class Tweet
	(id:String,
	 user:String,
	 text:String,
	 place:String,
	 country:String
	 )
	 def fromJsonfile (lines:Iterator[String]):Iterator[Tweet]=
	 {
	 	val gson = new Gson
	 	lines.map(line=>gson.fromJson(line,classOf[Tweet]))
	 }


}
