abstract class Notification

case class Email(sender:String, subject:String, body:String) extends Notification
case class SMS(number:String, sms:String) extends Notification

object notification
{
	def notification(ar:Notification):String=
	{
		ar match
		{
		
			case Email(sender,subject,_)=>
				s"$sender and $subject"
			case SMS(number,sms)=>
				s"$number and $sms"
		}
	
	
	}

	def main(args:Array[String])
	{
		var email = Email("amruth","hi","hi")
		var sms= SMS("8867208998","welcome")
		
		println(notification(email)+"\n"+notification(sms))
		
	}
}




