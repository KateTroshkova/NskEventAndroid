package winter2019.shift.nskevent_android.presenter

import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.model.RestOperation

class RemoteDataPrepossess: IRemoteDataHandler {

    private var restOperation: RestOperation?=null
    private var validationChecker=ValidationChecker.getInstance()

    init{
        restOperation= RestOperation()
    }

    override fun requestEventInfo(n: Int) {
        if (n>0 && restOperation!=null){
            restOperation?.requestEventInfo(n)
        }
        else{
            //TODO handle error
        }
    }

    override fun requestEventInfo(event: Event) {
        if (validationChecker.isEventValid(event)){
            restOperation?.requestEventInfo(event)
        }
        else{
            //TODo error
        }
    }

    override fun signUpForEvent(event: Event, email: String) {
        if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.signUpForEvent(event, email)
        }
        else{
            //TODo error
        }
    }

    override fun refuseEvent(event: Event, email: String) {
        if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.refuseEvent(event, email)
        }
        else{
            //TODo error
        }
    }

    override fun createEvent(event: Event) {
        if (validationChecker.isEventValid(event)){
            restOperation?.createEvent(event)
        }
        else{
            //TODo error
        }
    }

    override fun deleteEvent(event: Event, email: String) {
        if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.deleteEvent(event, email)
        }
        else{
            //TODo error
        }
    }
}