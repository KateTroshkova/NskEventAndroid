import winter2019.shift.nskevent_android.model.Event
import java.util.*

class ValidationChecker private constructor() {

    companion object {
        private var instance: ValidationChecker?=null

        fun getInstance(): ValidationChecker {
            if (instance ==null){
                instance = ValidationChecker()
            }
            return instance!!
        }
    }

    fun isEventValid(event: Event):Boolean=isTitleValid(event.title!!) &&
            isTextValid(event.message!!) && isPlaceValid(event.place!!) &&
            isTimeValid(event.date!!) && isEmailValid(event.author!!)

    private fun isTitleValid(title:String?):Boolean = title!=null && !title.isEmpty()
    private fun isTextValid(text:String?):Boolean = text!=null && !text.isEmpty()
    private fun isPlaceValid(place:String?):Boolean = place!=null && !place.isEmpty()
    private fun isTimeValid(time:String?):Boolean{
        if (time==null || time.isEmpty() || !time.contains(".") || time.length!=10) return false
        val currentTime=System.currentTimeMillis()
        val currentDate= Date(currentTime)
        val eventDate=Date(getTimeInMillis(time))
        if (eventDate.after(currentDate)){
            return true
        }
        return false
    }
    fun isEmailValid(email:String?):Boolean{
        return email!=null && !email.isEmpty() && email.contains("@") &&
                (email.contains("gmail.com") || email.contains("mail.ru")
                        || email.contains("inbox.ru") || email.contains("yandex.ru"))
    }

    private fun getTimeInMillis(time:String):Long{
        val parts=time.split(".")
        if (parts.size<3) return 0
        var day=parts[0]
        if (day[0]=='0'){
            day=day.substring(1)
        }
        var month=parts[1]
        if (month[0]=='0'){
            month=month.substring(1)
        }
        var year=parts[2]
        if (year[0]=='0'){
            year=year.substring(1)
        }
        val calendar= Calendar.getInstance()
        calendar.set(year.toInt(), (month.toInt()-1), day.toInt())
        return calendar.timeInMillis
    }
}