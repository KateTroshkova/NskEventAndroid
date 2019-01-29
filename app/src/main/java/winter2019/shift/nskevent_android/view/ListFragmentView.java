package winter2019.shift.nskevent_android.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import winter2019.shift.nskevent_android.presenter.ListFragmentPresenter;
import winter2019.shift.nskevent_android.presenter.MVPContract;
import winter2019.shift.nskevent_android.R;
import winter2019.shift.nskevent_android.model.Event;


public class ListFragmentView extends Fragment implements MVPContract {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_events);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private class EventsHolder extends RecyclerView.ViewHolder implements View.OnClickListener, MVPContract.ListView{
        private TextView eventTitle;
        private TextView eventMessage;
        private TextView eventDate;
        private Event eventNsk;                 //список всех событий
        private ListFragmentPresenter preseinter;

        public EventsHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            eventTitle = (TextView) itemView.findViewById(R.id.event_title);
            eventMessage = (TextView) itemView.findViewById(R.id.event_message);
            eventDate = (TextView) itemView.findViewById(R.id.event_date);
            preseinter=new ListFragmentPresenter();
            preseinter.attachView(this);
        }

        @Override
        public void onClick(View view) {
            /*
            Здесь нужно получить активити по id, был класс PagerActivity, который возвращал объект класса Event
            и вызывла фрагментМанаджер для этой записи
            Intent intent =
               */
        }

        //заполнение данных о событии по полученному объекту
        public void bindEvent(Event event) {
            eventNsk = event;
            preseinter.viewIsReady();

            /*
            методы по заполнению маленького фрагментика:
            eventTitle.setText(eventNsk.
            eventMessage.setText(eventNsk.
            eventDate.setText(eventNsk.
             */
        }

        @Override
        public void click() {

        }

        @Override
        public void load(List events) {
            Toast.makeText(getContext(), ""+events.size(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void update(Event event) {

        }
    }

    private class EventsAdapter extends RecyclerView.Adapter<EventsHolder> {
        private List<Event> eventsNsk;

        public EventsAdapter(List<Event> events) {
            this.eventsNsk = events;
        }

        @NonNull
        @Override
        public EventsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout._list_item_event_one, viewGroup, false);
            return new EventsHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EventsHolder eventsHolder, int i) {
            Event event = null;                                             //получить событие!!!!
            //= eventsNsk.get(i);
            eventsHolder.bindEvent(event);

        }

        @Override
        public int getItemCount() {
            return eventsNsk.size();
        }
    }


}
