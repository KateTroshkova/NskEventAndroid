package winter2019.shift.nskevent_android.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import winter2019.shift.nskevent_android.model.Event;
import winter2019.shift.nskevent_android.model.RemoteDataPrepossess;
import winter2019.shift.nskevent_android.model.Answer;

public class DialogPresenter extends BasePresenter<MVPContract.DialogView> {

    private Event currentEvent;
    private Action currentAction;

    public DialogPresenter(Event event, Action action){
        currentEvent=event;
        currentAction=action;
    }

    private IRemoteDataReadyListener listener=new IRemoteDataReadyListener() {
        @Override
        public void onError() {
            DialogPresenter.this.getView().hideProgressBar();
            DialogPresenter.this.getView().onError();
        }

        @Override
        public void onGetNEvents(@NotNull List<Event> events) { }

        @Override
        public void onGetEvent(@NotNull Event event) { }

        @Override
        public void onSuccessSignUp(Answer answer) {
            DialogPresenter.this.getView().hideProgressBar();
            DialogPresenter.this.getView().onSuccess();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onSuccessRefuse(Answer answer) {
            DialogPresenter.this.getView().hideProgressBar();
            DialogPresenter.this.getView().onSuccess();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onSuccessCreate(Answer answer) {
        }

        @Override
        public void onSuccessDelete(Answer answer) {
            DialogPresenter.this.getView().hideProgressBar();
            DialogPresenter.this.getView().onSuccess();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onErrorSignUp() {
            DialogPresenter.this.getView().hideProgressBar();
            DialogPresenter.this.getView().onError();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onErrorRefuse() {
            DialogPresenter.this.getView().hideProgressBar();
            DialogPresenter.this.getView().onError();
            DialogPresenter.this.getView().hideDialog();
        }

        @Override
        public void onErrorCreate() {
        }

        @Override
        public void onErrorDelete() {
            DialogPresenter.this.getView().hideProgressBar();
            DialogPresenter.this.getView().onError();
            DialogPresenter.this.getView().hideDialog();
        }
    };

    @Override
    public void viewIsReady() {}

    public void onClick(){
        RemoteDataPrepossess remoteData=new RemoteDataPrepossess();
        remoteData.setReadyListener(listener);
        String email=getView().getEmail();
        switch(currentAction){
            case ACTION_ACCEPT:{
                remoteData.signUpForEvent(currentEvent, email);
                break;
            }
            case ACTION_REFUSE:{
                remoteData.refuseEvent(currentEvent, email);
                break;
            }
            case ACTION_DELETE:{
                remoteData.deleteEvent(currentEvent, email);
                break;
            }
            default:{
                listener.onError();
            }
        }
        getView().showProgressBar();
    }
}
