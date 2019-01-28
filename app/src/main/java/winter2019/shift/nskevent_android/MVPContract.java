import winter2019.shift.nskevent_android.MVPView;

public interface MVPContract {

    interface View extends MVPView{
        //you can add params
        void showCalendar();
        void changeButtonState();
        void setTitle(String title);
        void setDescription(String title);
        void setDate(String date);
        void setPlace(String place);
        void setEmail(String email);
        String getTitle();
        String getDescription();
        String getDate();
        String getPlace();
        String getEmail();
        void showDialog();
        void close();
        void create();
        void showMessage();
    }

    interface Presenter extends MVPPresenter<View>{

    }
}
