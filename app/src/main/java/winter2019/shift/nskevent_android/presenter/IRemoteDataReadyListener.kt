package winter2019.shift.nskevent_android.presenter

import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.model.Answer

//Обратная связь с сервером. Обрабатывает результаты, пришедшие с сервера

interface IRemoteDataReadyListener {

    fun onError()
    fun onGetNEvents(events:MutableList<Event>)
    fun onGetEvent(event:Event)
    fun onSuccessSignUp(answer: Answer)
    fun onSuccessRefuse(answer: Answer)
    fun onSuccessCreate(answer: Answer)
    fun onSuccessDelete(answer: Answer)
    fun onErrorSignUp()
    fun onErrorRefuse()
    fun onErrorCreate()
    fun onErrorDelete()
}