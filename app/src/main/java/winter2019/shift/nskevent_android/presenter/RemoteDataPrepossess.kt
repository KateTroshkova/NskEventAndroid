package winter2019.shift.nskevent_android.presenter

import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.model.RestOperation

class RemoteDataPrepossess: IRemoteDataHandler {

    private var restOperation: RestOperation?=null

    init{
        restOperation= RestOperation()
    }

    override fun requestEventInfo(n: Int) {
    }

    override fun requestEventInfo(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun signUpForEvent(event: Event, email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refuseEvent(event: Event, email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createEvent(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteEvent(event: Event, email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}