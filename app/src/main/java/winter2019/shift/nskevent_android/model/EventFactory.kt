package winter2019.shift.nskevent_android.model

//Создает объект Event

class EventFactory {

    fun createEvent(title:String, message:String, date:String, place:String, memberCount:Int, autor:String):Event{
        return Event(null, title, message, date, place, memberCount, autor)
    }
}