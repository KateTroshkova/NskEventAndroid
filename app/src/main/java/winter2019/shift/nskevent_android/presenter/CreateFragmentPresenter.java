package winter2019.shift.nskevent_android.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import winter2019.shift.nskevent_android.model.Event;
import winter2019.shift.nskevent_android.model.EventFactory;
import winter2019.shift.nskevent_android.model.RemoteDataPrepossess;
import winter2019.shift.nskevent_android.model.Answer;

public class CreateFragmentPresenter extends BasePresenter<MVPContract.CreateView>{

    private Event newEvent;

    private IRemoteDataReadyListener listener=new IRemoteDataReadyListener() {
        @Override
        public void onError() {
            CreateFragmentPresenter.this.getView().hideProgressBar();
            CreateFragmentPresenter.this.getView().onError();
        }

        @Override
        public void onGetNEvents(@NotNull List<Event> events) {

        }

        @Override
        public void onGetEvent(@NotNull Event event) {

        }

        @Override
        public void onSuccessSignUp(Answer answer) {

        }

        @Override
        public void onSuccessRefuse(Answer answer) {

        }

        @Override
        public void onSuccessCreate(Answer answer) {
            newEvent.setId(answer.getId());
            CreateFragmentPresenter.this.getView().hideProgressBar();
            CreateFragmentPresenter.this.getView().onSuccess(newEvent);
            CreateFragmentPresenter.this.getView().showAll();
        }

        @Override
        public void onSuccessDelete(Answer answer) {

        }

        @Override
        public void onErrorSignUp() {

        }

        @Override
        public void onErrorRefuse() {

        }

        @Override
        public void onErrorCreate() {
            CreateFragmentPresenter.this.getView().hideProgressBar();
            CreateFragmentPresenter.this.getView().onError();
        }

        @Override
        public void onErrorDelete() {

        }
    };

    @Override
    public void viewIsReady() {

    }

    public void onClick(){
        Event newEvent=new EventFactory().createEvent(
                getView().getTitleEvent(),
                getView().getMessage(),
                getView().getDate(),
                getView().getPlace(),
                getView().getMemberCount(),
                getView().getEmail()
        );
        RemoteDataPrepossess remoteData=new RemoteDataPrepossess();
        remoteData.setReadyListener(listener);
        remoteData.createEvent(newEvent);
        getView().showProgressBar();
    }
}
