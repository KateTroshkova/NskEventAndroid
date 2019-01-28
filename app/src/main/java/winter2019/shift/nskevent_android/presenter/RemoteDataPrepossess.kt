package winter2019.shift.nskevent_android.presenter

import winter2019.shift.nskevent_android.GlobalTextVariables
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.model.RestOperation

class RemoteDataPrepossess: IRemoteDataHandler {

    private var restOperation: RestOperation?=null
    private var validationChecker=ValidationChecker.getInstance()
    private var errorHandler:IErrorHandler?=null

    init{
        restOperation= RestOperation()
    }

    override fun setErrorCallback(errorHandler: IErrorHandler){
        this.errorHandler=errorHandler
    }

    override fun requestEventInfo(n: Int) {
        if (n>0 && restOperation!=null){
            restOperation?.requestEventInfo(n)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }

    override fun requestEventInfo(event: Event) {
        if (validationChecker.isEventValid(event)){
            restOperation?.requestEventInfo(event)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }

    override fun signUpForEvent(event: Event, email: String) {
        if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.signUpForEvent(event, email)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }

    override fun refuseEvent(event: Event, email: String) {
        if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.refuseEvent(event, email)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }

    override fun createEvent(event: Event) {
        if (validationChecker.isEventValid(event)){
            restOperation?.createEvent(event)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }

    override fun deleteEvent(event: Event, email: String) {
        if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.deleteEvent(event, email)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }
}