package winter2019.shift.nskevent_android.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import winter2019.shift.nskevent_android.model.Event;
import winter2019.shift.nskevent_android.model.RemoteDataPrepossess;
import winter2019.shift.nskevent_android.model.Answer;

public class ListFragmentPresenter extends BasePresenter<MVPContract.ListView>{

    private List<Event> events;

    private IRemoteDataReadyListener listener=new IRemoteDataReadyListener() {
        @Override
        public void onError() {
            ListFragmentPresenter.this.getView().onError();
        }

        @Override
        public void onGetNEvents(@NotNull List<Event> events) {
            Collections.sort(events, new Comparator<Event>() {
                @Override
                public int compare(final Event object1, final Event object2) {
                    if (object1.getId()>object2.getId()) return -1;
                    if (object1.getId()<object2.getId()) return 1;
                    return 0;
                }
            });
            ListFragmentPresenter.this.events=events;
            ListFragmentPresenter.this.getView().load(events);
        }

        @Override
        public void onGetEvent(@NotNull Event event) {
            ListFragmentPresenter.this.getView().showDetail(event);
        }

        @Override
        public void onSuccessSignUp(Answer answer) { }

        @Override
        public void onSuccessRefuse(Answer answer) { }

        @Override
        public void onSuccessCreate(Answer answer) { }

        @Override
        public void onSuccessDelete(Answer answer) { }

        @Override
        public void onErrorSignUp() { }

        @Override
        public void onErrorRefuse() { }

        @Override
        public void onErrorCreate() { }

        @Override
        public void onErrorDelete() { }
    };

    @Override
    public void viewIsReady() {
        RemoteDataPrepossess remoteData=new RemoteDataPrepossess();
        remoteData.setReadyListener(listener);
        remoteData.requestEventInfo(1, 10);
    }

    public void onItemClick(int position) {
        if (events!=null && events.size()>position){
            listener.onGetEvent(events.get(position));
        }
        else{
            listener.onError();
        }
    }

    public void onClick(){
        getView().showCreationActivity();
    }
}
