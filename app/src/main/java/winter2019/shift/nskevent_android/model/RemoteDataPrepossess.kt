package winter2019.shift.nskevent_android.model

import winter2019.shift.nskevent_android.GlobalTextVariables
import winter2019.shift.nskevent_android.presenter.IErrorHandler
import winter2019.shift.nskevent_android.presenter.IRemoteDataHandler
import winter2019.shift.nskevent_android.presenter.IRemoteDataReadyListener

class RemoteDataPrepossess: IRemoteDataHandler {

    private var restOperation: RestOperation?=null
    private var validationChecker= ValidationChecker.getInstance()
    private var errorHandler: IErrorHandler?=null

    init{
        restOperation = RestOperation()
    }

    fun setReadyListener(listener:IRemoteDataReadyListener){
        restOperation?.setRemoteDataReadyListener(listener)
    }

    override fun requestEventInfo(page: Int, limit:Int) {
        if (page>0 && restOperation!=null){
            restOperation?.requestEventInfo(page, limit)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }

    override fun requestEventInfo(id:Int) {
        if (id>0){
            restOperation?.requestEventInfo(id)
        }
        else{
            errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        }
    }

    override fun signUpForEvent(event: Event, email: String) {
        //if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.signUpForEvent(event, email)
        //}
        //else{
         //   errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        //}
    }

    override fun refuseEvent(event: Event, email: String) {
        //if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.refuseEvent(event, email)
        //}
        //else{
         //   errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        //}
    }

    override fun createEvent(event: Event) {
        //if (validationChecker.isEventValid(event)){
            restOperation?.createEvent(event)
        //}
        //else{
         //   errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        //}
    }

    override fun deleteEvent(event: Event, email: String) {
       // if (validationChecker.isEventValid(event) && validationChecker.isEmailValid(email)){
            restOperation?.deleteEvent(event, email)
        //}
        //else{
        //    errorHandler?.onError(GlobalTextVariables.ERROR_WRONG_DATA)
        //}
    }
}