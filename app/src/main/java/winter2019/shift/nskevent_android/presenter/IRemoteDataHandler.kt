package winter2019.shift.nskevent_android.presenter

import winter2019.shift.nskevent_android.model.Event

interface IRemoteDataHandler {

    fun setErrorCallback(errorHandler: IErrorHandler)
    fun requestEventInfo(n:Int)
    fun requestEventInfo(event: Event)
    fun signUpForEvent(event:Event, email:String)
    fun refuseEvent(event:Event, email:String)
    fun createEvent(event:Event)
    fun deleteEvent(event:Event, email:String)
}