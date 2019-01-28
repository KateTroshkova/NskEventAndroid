package winter2019.shift.nskevent_android;

interface MVPPresenter<T extends MVPView> {

    void attachView(T mvpView);
    void viewIsReady();
    void detachView();
    void destroy();
}
