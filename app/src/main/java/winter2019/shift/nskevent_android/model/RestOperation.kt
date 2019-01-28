package winter2019.shift.nskevent_android.model

import winter2019.shift.nskevent_android.presenter.IRemoteDataHandler

class RestOperation:IRemoteDataHandler {

    override fun requestEventInfo(n: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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