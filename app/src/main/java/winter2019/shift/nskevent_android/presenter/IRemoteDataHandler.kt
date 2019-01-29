package winter2019.shift.nskevent_android.presenter

import winter2019.shift.nskevent_android.model.Event

//Интерфейс для запросов к сети. Определить RemoteDataPreprossess

interface IRemoteDataHandler {

    fun requestEventInfo(page:Int, limit:Int)
    fun requestEventInfo(event: Event)
    fun signUpForEvent(event:Event, email:String)
    fun refuseEvent(event:Event, email:String)
    fun createEvent(event:Event)
    fun deleteEvent(event:Event, email:String)
}