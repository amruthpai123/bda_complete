object quicksort
{
	def sort(ar:List[Int]):List[Int]=
	{
		if(ar.length<2)
			ar
		else
		{  var pivot = ar(ar.length/2)
		  sort(ar.filter(_<pivot)):::ar.filter(_==pivot):::sort(ar.filter(_>pivot))
		  
		 }
	}
	
	def main(args:Array[String])
	{
		var list= List(1,5,6,3,2,9)
		println(sort(list))
	}
}
