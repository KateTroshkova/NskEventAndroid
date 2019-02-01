package winter2019.shift.nskevent_android.presenter;

import java.util.ArrayList;
import java.util.List;

import winter2019.shift.nskevent_android.model.Event;

public interface MVPContract {

    interface ListView extends MVPView{
        void load(List<Event> events);
        void update(List<Event> events);
        void showDetail(Event event);
        void onError();
    }

    interface ItemView extends MVPView{
        void showDialog(Event event, Action action);
    }

    interface CreateView extends MVPView{
        String getTitleEvent();
        String getMessage();
        String getDate();
        String getPlace();
        int getMemberCount();
        String getEmail();
        void showProgressBar();
        void hideProgressBar();
        void onSuccess();
        void onError();
        void showAll();
    }

    interface DialogView extends MVPView{
        String getEmail();
        void showProgressBar();
        void hideProgressBar();
        void hideDialog();
        void onSuccess();
        void onError();
    }
}
