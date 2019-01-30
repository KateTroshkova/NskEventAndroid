package winter2019.shift.nskevent_android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import winter2019.shift.nskevent_android.R;
import winter2019.shift.nskevent_android.model.Event;

public class EventAdapter extends BaseAdapter {

    private ArrayList<Event> eventsNsk;
    private LayoutInflater inflater;

    public EventAdapter(Context context, ArrayList<Event> events){
            this.eventsNsk = events;
            inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return eventsNsk.size();
    }

    @Override
    public Object getItem(int position) {
        return eventsNsk.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout._list_item_event_one, null);

        TextView eventsTitle = view.findViewById(R.id.event_title);
        TextView eventMessage = view.findViewById(R.id.event_message);
        TextView eventsDate = view.findViewById(R.id.event_date);

        eventsTitle.setText(eventsNsk.get(position).getTitle());
        eventMessage.setText(eventsNsk.get(position).getMessage());
        eventsDate.setText(eventsNsk.get(position).getDate());

        return view;
    }
}
