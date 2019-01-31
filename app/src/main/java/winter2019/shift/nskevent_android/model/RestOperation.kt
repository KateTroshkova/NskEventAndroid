package winter2019.shift.nskevent_android.model

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import winter2019.shift.nskevent_android.model.retrofit.IRequest
import winter2019.shift.nskevent_android.presenter.IErrorHandler
import winter2019.shift.nskevent_android.presenter.IRemoteDataHandler
import winter2019.shift.nskevent_android.presenter.IRemoteDataReadyListener

class RestOperation:IRemoteDataHandler {

    private val BASE_URL="https://nskevent.herokuapp.com"
    private var requestInterface: IRequest
    private var readyListener:IRemoteDataReadyListener?=null

    init{
        requestInterface = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(IRequest::class.java)
    }

    fun setRemoteDataReadyListener(listener:IRemoteDataReadyListener){
        readyListener=listener
    }

    override fun requestEventInfo(page: Int, limit:Int) {
        val disposable = requestInterface.getNEvent(page, limit).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ list->readyListener?.onGetNEvents(list.toMutableList()) }, { _ ->readyListener?.onError() })
    }

    override fun requestEventInfo(id:Int) {
        val disposable = requestInterface.getEvent(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ event->readyListener?.onGetEvent(event)}, { _ ->readyListener?.onError()})
    }

    override fun signUpForEvent(event: Event, email: String) {
        val disposable = requestInterface.sendAccept(event.id!!, email).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ message->readyListener?.onSuccessSignUp(message) }, { _ ->readyListener?.onErrorSignUp() })
    }

    override fun refuseEvent(event: Event, email: String) {
        val disposable = requestInterface.sendRefuse(event.id!!, email).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ message ->readyListener?.onSuccessRefuse(message)}, { _ ->readyListener?.onErrorRefuse()})
    }

    override fun createEvent(event: Event) {
        val disposable = requestInterface.createEvent(event).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({
                    message->readyListener?.onSuccessCreate(message)}, { _ ->readyListener?.onErrorCreate() })
    }

    override fun deleteEvent(event: Event, email: String) {
        val disposable = requestInterface.deleteEvent(event.id!!, email).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({
                    message->readyListener?.onSuccessDelete(message)}, { _ ->readyListener?.onErrorDelete() })
    }

    fun release(disposable: Disposable){
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}