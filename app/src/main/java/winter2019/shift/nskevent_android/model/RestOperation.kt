package winter2019.shift.nskevent_android.model

import winter2019.shift.nskevent_android.presenter.IErrorHandler
import winter2019.shift.nskevent_android.presenter.IRemoteDataHandler

class RestOperation:IRemoteDataHandler {

    private var errorHandler:IErrorHandler?=null

    override fun setErrorCallback(errorHandler: IErrorHandler) {
        this.errorHandler=errorHandler
    }

    override fun requestEventInfo(n: Int) {
    }

    override fun requestEventInfo(event: Event) {
    }

    override fun signUpForEvent(event: Event, email: String) {
    }

    override fun refuseEvent(event: Event, email: String) {
    }

    override fun createEvent(event: Event) {
    }

    override fun deleteEvent(event: Event, email: String) {
    }
}