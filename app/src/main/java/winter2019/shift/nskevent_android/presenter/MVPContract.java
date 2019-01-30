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
        void onError();
    }

    interface CreateView extends MVPView{
        String getTitle();
        String getMessage();
        String getDate();
        String getPlace();
        int getMemberCount();
        String getEmail();
        void showProgressBar();
        void onSuccess();
        void onError();
    }

    interface DialogView extends MVPView{
        String getEmail();
        void showProgressBar();
        void hideDialog();
        void onSuccess();
        void onError();
    }
}
