package winter2019.shift.nskevent_android.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import winter2019.shift.nskevent_android.model.Event;
import winter2019.shift.nskevent_android.model.EventFactory;
import winter2019.shift.nskevent_android.model.RemoteDataPrepossess;

public class CreateFragmentPresenter extends BasePresenter<MVPContract.CreateView>{

    private IRemoteDataReadyListener listener=new IRemoteDataReadyListener() {
        @Override
        public void onError() {

        }

        @Override
        public void onGetNEvents(@NotNull List<Event> events) {

        }

        @Override
        public void onGetEvent(@NotNull Event event) {

        }

        @Override
        public void onSuccessSignUp() {

        }

        @Override
        public void onSuccessRefuse() {

        }

        @Override
        public void onSuccessCreate() {
            CreateFragmentPresenter.this.getView().onSuccess();
        }

        @Override
        public void onSuccessDelete() {

        }

        @Override
        public void onErrorSignUp() {

        }

        @Override
        public void onErrorRefuse() {

        }

        @Override
        public void onErrorCreate() {
            CreateFragmentPresenter.this.getView().onError();
        }

        @Override
        public void onErrorDelete() {

        }
    };

    @Override
    public void viewIsReady() {

    }

    public void createClick(){
        Event newEvent=new EventFactory().createEvent(
                getView().getTitle(),
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
