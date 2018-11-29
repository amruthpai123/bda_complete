

import org.apache.spark.sql.SparkSession
import spark.implicits._

object iple
{
	def main(args:Array[String])
	{
		val path= args(0)
		
		val spark = Sparksession.Builder().AppName("ipl").getOrCreate()
		val df = spark.read.format("csv")
			.option("sep"," ")
			.option("inferschema","true")
			.option("header","true")
			.load(path+"/match.csv")
			
		df.createOrReplaceTempView("ipldata")
		
		val N= spark.sql("select COUNT(*) from ipldata")
			.first()(0)
			.asInstanceof[long]
			
		



}
