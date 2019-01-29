package winter2019.shift.nskevent_android.presenter;

import java.util.ArrayList;

import winter2019.shift.nskevent_android.model.Event;

public class ListFragmentPresenter extends BasePresenter<MVPContract.ListView> implements MVPContract.ListViewPresenter {

    @Override
    public void viewIsReady() {
        ArrayList<Event> data=new ArrayList<>();
        for (int i=0; i<42; i++){
            data.add(new Event(42, "faq", "fuck off", "01.01.1970", "nowhere", 0, "no one"));
        }
        getView().load(data);
    }

    @Override
    public void onClick() {

    }


}
