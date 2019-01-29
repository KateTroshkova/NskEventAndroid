package winter2019.shift.nskevent_android.model

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import winter2019.shift.nskevent_android.model.retrofit.IRequest
import winter2019.shift.nskevent_android.presenter.IErrorHandler
import winter2019.shift.nskevent_android.presenter.IRemoteDataHandler
import winter2019.shift.nskevent_android.presenter.IRemoteDataReadyListener

class RestOperation:IRemoteDataHandler {

    private val BASE_URL="TODO_LATER/"
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
                subscribe ({ list->readyListener?.onGetNEvents(list.toMutableList())}, { _ ->readyListener?.onError()})
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    override fun requestEventInfo(id:Int) {
        val disposable = requestInterface.getEvent(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ event->readyListener?.onGetEvent(event)}, { _ ->readyListener?.onError()})
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    override fun signUpForEvent(event: Event, email: String) {
        val disposable = requestInterface.sendAccept(event.id!!, email).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ message->readyListener?.onSuccessSignUp()}, { _ ->readyListener?.onErrorSignUp()})
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    override fun refuseEvent(event: Event, email: String) {
        val disposable = requestInterface.sendRefuse(event.id!!, email).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ _ ->readyListener?.onSuccessRefuse()}, { _ ->readyListener?.onErrorRefuse()})
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    override fun createEvent(event: Event) {
        val disposable = requestInterface.createEvent(event).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ message->readyListener?.onSuccessCreate()}, { _ ->readyListener?.onErrorCreate()})
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    override fun deleteEvent(event: Event, email: String) {
        val disposable = requestInterface.deleteEvent(event.id!!, email).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe ({ message->readyListener?.onSuccessDelete()}, { _ ->readyListener?.onErrorDelete()})
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}