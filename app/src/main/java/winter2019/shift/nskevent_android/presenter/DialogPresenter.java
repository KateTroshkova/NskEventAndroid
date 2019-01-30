package winter2019.shift.nskevent_android.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import winter2019.shift.nskevent_android.model.Event;
import winter2019.shift.nskevent_android.model.RemoteDataPrepossess;

public class DialogPresenter extends BasePresenter<MVPContract.DialogView> {

    private IRemoteDataReadyListener listener=new IRemoteDataReadyListener() {
        @Override
        public void onError() {
            DialogPresenter.this.getView().onError();
        }

        @Override
        public void onGetNEvents(@NotNull List<Event> events) { }

        @Override
        public void onGetEvent(@NotNull Event event) { }

        @Override
        public void onSuccessSignUp() {
            DialogPresenter.this.getView().onSuccess();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onSuccessRefuse() {
            DialogPresenter.this.getView().onSuccess();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onSuccessCreate() {
        }

        @Override
        public void onSuccessDelete() {
            DialogPresenter.this.getView().onSuccess();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onErrorSignUp() {
            DialogPresenter.this.getView().onError();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onErrorRefuse() {
            DialogPresenter.this.getView().onError();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onErrorCreate() {
        }

        @Override
        public void onErrorDelete() {
            DialogPresenter.this.getView().onError();
            DialogPresenter.this.getView().hideDialog();
        }
    };

    @Override
    public void viewIsReady() {}

    public void okClick(Event event, Action action){
        RemoteDataPrepossess remoteData=new RemoteDataPrepossess();
        remoteData.setReadyListener(listener);
        String email=getView().getEmail();
        switch(action){
            case ACTION_ACCEPT:{
                remoteData.signUpForEvent(event, email);
                break;
            }
            case ACTION_REFUSE:{
                remoteData.refuseEvent(event, email);
                break;
            }
            case ACTION_DELETE:{
                remoteData.deleteEvent(event, email);
                break;
            }
            default:{
                listener.onError();
            }
        }
        getView().showProgressBar();
    }
}
