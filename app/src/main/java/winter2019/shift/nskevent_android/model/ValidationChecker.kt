package winter2019.shift.nskevent_android.model

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
            isTimeValid(event.date!!) && isEmailValid(event.autor!!)

    fun isTitleValid(title:String):Boolean=true
    fun isTextValid(text:String):Boolean=true
    fun isPlaceValid(place:String):Boolean=true
    fun isTimeValid(time:String):Boolean=true
    fun isEmailValid(email:String):Boolean=true
}