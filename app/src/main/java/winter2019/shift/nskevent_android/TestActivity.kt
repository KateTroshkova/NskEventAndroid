package winter2019.shift.nskevent_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.model.RemoteDataPrepossess
import winter2019.shift.nskevent_android.model.Answer
import winter2019.shift.nskevent_android.presenter.IRemoteDataReadyListener

class TestActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

    var events= mutableListOf<Event>()

    private val listener = object : IRemoteDataReadyListener {
        override fun onError() {
            Log.e("NSKEvent", "error")
        }

        override fun onGetNEvents(events: MutableList<Event>) {
            this@TestActivity.events.addAll(events)
            Log.e("NSKEvent", events.toString())
        }

        override fun onGetEvent(event: Event) {
            Log.e("NSKEvent", event.id.toString()+" "+event.title)
        }

        override fun onSuccessSignUp(answer: Answer) {
            Log.e("NSKEvent", answer.toString())
        }

        override fun onSuccessRefuse(answer: Answer) {
            Log.e("NSKEvent", answer.toString())
        }

        override fun onSuccessCreate(answer: Answer) {
            Log.e("NSKEvent", "create"+answer.id.toString())
        }

        override fun onSuccessDelete(answer: Answer) {
            Log.e("NSKEvent", answer.toString())
        }

        override fun onErrorSignUp() {
            Log.e("NSKEvent", "error sign up")
        }

        override fun onErrorRefuse() {
            Log.e("NSKEvent", "error refuse")
        }

        override fun onErrorCreate() {
            Log.e("NSKEvent", "error create")
        }

        override fun onErrorDelete() {
            Log.e("NSKEvent", "error delete")
        }
    }

    fun getAll(view: View){
        val remoteData = RemoteDataPrepossess()
        remoteData.setReadyListener(listener)
        remoteData.requestEventInfo(1, 10)
    }

    fun getOne(vew:View){
        val remoteData = RemoteDataPrepossess()
        remoteData.setReadyListener(listener)
        remoteData.requestEventInfo(42)
    }

    fun accept(view:View){
        val remoteData = RemoteDataPrepossess()
        remoteData.setReadyListener(listener)
        remoteData.signUpForEvent(events[0], "e-troshkova@inbox.ru")
    }

    fun refuse(view:View){
        val remoteData = RemoteDataPrepossess()
        remoteData.setReadyListener(listener)
        remoteData.refuseEvent(events[0], "e-troshkova@inbox.ru")
    }

    fun create(view:View){
        val remoteData = RemoteDataPrepossess()
        remoteData.setReadyListener(listener)
        remoteData.createEvent(events[2])
    }

    fun delete(view:View){
        val remoteData = RemoteDataPrepossess()
        remoteData.setReadyListener(listener)
        remoteData.deleteEvent(events[13], "e-troshkova@inbox.ru")
    }
}
