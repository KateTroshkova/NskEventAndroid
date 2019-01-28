package winter2019.shift.nskevent_android.model

class EventFactory {

    fun createEvent(title:String, message:String, date:String, place:String, member_count:Int, autor:String):Event{
        return Event(null, title, message, date, place, member_count, autor)
    }
}