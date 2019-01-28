package winter2019.shift.nskevent_android.presenter

import winter2019.shift.nskevent_android.model.Event

//Обратная связь с сервером. Обрабатывает результаты, пришедшие с сервера

interface IRemoteDataReadyListener {

    fun onGetNEvents(events:MutableList<Event>)
    fun onGetEvent(event:Event)
    fun onSuccessSignUp()
    fun onSuccessRefuse()
    fun onSuccessCreate()
    fun onSuccessDelete()
    fun onErrorSignUp()
    fun onErrorRefuse()
    fun onErrorCreate()
    fun onErrorDelete()
}