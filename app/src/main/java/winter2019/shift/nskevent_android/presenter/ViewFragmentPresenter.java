package winter2019.shift.nskevent_android.presenter;

import winter2019.shift.nskevent_android.model.Event;

public class ViewFragmentPresenter extends BasePresenter<MVPContract.ItemView> {

    private Event currentEvent;

    public ViewFragmentPresenter(Event event){
        currentEvent=event;
    }

    @Override
    public void viewIsReady() { }

    public void onAccept(){
        getView().showDialog(currentEvent, Action.ACTION_ACCEPT);
    }

    public void onRefuse(){
        getView().showDialog(currentEvent, Action.ACTION_REFUSE);
    }

    public void onDelete(){
        getView().showDialog(currentEvent, Action.ACTION_DELETE);
    }
}
