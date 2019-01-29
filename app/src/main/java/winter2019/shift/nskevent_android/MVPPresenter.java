package winter2019.shift.nskevent_android;

interface MVPPresenter<T extends MVPView> {

    void attachView(T mvpView);
    //TODO click id!
    void viewIsReady();
    void detachView();
    void destroy();
}
