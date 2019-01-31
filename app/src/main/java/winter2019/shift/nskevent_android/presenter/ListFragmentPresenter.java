package winter2019.shift.nskevent_android.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import winter2019.shift.nskevent_android.model.Event;
import winter2019.shift.nskevent_android.model.RemoteDataPrepossess;
import winter2019.shift.nskevent_android.model.Answer;

public class ListFragmentPresenter extends BasePresenter<MVPContract.ListView>{

    private static int PAGE_COUNT=0;
    private static final int MAX_EVENTS_ON_PAGE=10;
    private List<Event> events;
    private List<Event> newEvents;

    private IRemoteDataReadyListener listener=new IRemoteDataReadyListener() {
        @Override
        public void onError() {
            ListFragmentPresenter.this.getView().onError();
        }

        @Override
        public void onGetNEvents(@NotNull List<Event> events) {
            ListFragmentPresenter.this.newEvents=events;
            if (ListFragmentPresenter.this.events==null || ListFragmentPresenter.this.events.isEmpty()) {
                ListFragmentPresenter.this.getView().load(newEvents);
                ListFragmentPresenter.this.events=new ArrayList<>();
            }
            else{
                ListFragmentPresenter.this.getView().update(newEvents);
            }
            ListFragmentPresenter.this.events.addAll(newEvents);
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
        ArrayList<Event> data=new ArrayList<>();
       /* for (int i=0; i<42; i++){
            data.add(new Event(42, "faq", "fuck off", "01.01.1970", "nowhere", 0, "no one"));
        }*/
        getView().load(data);

        RemoteDataPrepossess remoteData=new RemoteDataPrepossess();
        remoteData.setReadyListener(listener);
        PAGE_COUNT++;
        remoteData.requestEventInfo(PAGE_COUNT, MAX_EVENTS_ON_PAGE);
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
