import scala.io.Source

object wordcount
{
	def main(args:Array[String])
	{
		val filename= args(0)
		val wordcount= scala.collection.mutable.Map[String,Int]().withDefaultValue(0)
		for(line<-Source.fromFile(filename).getLines)
		{
			for(word<-line.split(" "))
			{
				val str= word.toLowerCase
				wordcount(str)+=1
				
			
						
			}
		
		
		}
	print(wordcount)
	}


}
