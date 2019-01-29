package winter2019.shift.nskevent_android.presenter;

import java.util.ArrayList;
import java.util.List;

import winter2019.shift.nskevent_android.model.Event;

public interface MVPContract {

    interface ListView extends MVPView{
        void load(List<Event> events);
        void update(List<Event> events);
        void showDetail(Event event);
    }

    interface ItemView extends MVPView{
        void showDialog();
        void hideDialog();
        void setTitle(String title);
        void setMessage(String message);
        void setDate(String date);
        void setPlace(String place);
        void setMemberCount(int count);
        void setEmail(String email);
        String getTitle();
        String getMessage();
        String getDate();
        String getPlace();
        int getMemberCount();
        String getEmail();
        void clickOk();
        void clickRefuse();
    }

    interface CreateView extends MVPView{
        void setTitle(String title);
        void setMessage(String message);
        void setDate(String date);
        void setPlace(String place);
        void setMemberCount(int count);
        void setEmail(String email);
        String getTitle();
        String getMessage();
        String getDate();
        String getPlace();
        int getMemberCount();
        String getEmail();
        void create();
        void pickTime();
    }

    //TODO activity interface

    interface DialogView extends MVPView{
        void setEmail(String email);
        String getEmail();
        void click();
        void hide();
        void show();
    }

    interface ItemViewPresenter extends MVPPresenter<ItemView>{
        void onClicklickDate();
        void onClickOk();
        void onClickRefuse();
    }

    interface CreateViewPresenter extends MVPPresenter<CreateView>{
        void onClickTime();
        void onCreate();
    }

    interface DialogViewPresenter extends MVPPresenter<DialogView>{
        void onClick();
    }
}
