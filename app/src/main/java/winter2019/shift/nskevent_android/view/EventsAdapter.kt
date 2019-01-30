package winter2019.shift.nskevent_android.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main._list_item_event_one.view.*
import winter2019.shift.nskevent_android.R
import winter2019.shift.nskevent_android.model.Event

class EventsAdapter(context: Context, resource: Int, events: ArrayList<Event>) : ArrayAdapter<Event>(context, resource, events) {

    private class ViewHolder(row: View?) {
        var txtTitle: TextView
        var txtMessage: TextView
        var txtDate: TextView

        init {
            this.txtTitle = row?.findViewById(R.id.event_title) as TextView
            this.txtMessage = row?.findViewById(R.id.event_message) as TextView
            this.txtDate = row?.findViewById(R.id.event_date) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout._list_item_event_one, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var event: Event = getItem(position) as Event
        viewHolder.txtTitle.text = event.title
        viewHolder.txtMessage.text = event.message
        viewHolder.txtDate.text = event.date

        return view as View

    }

    /*

    override fun getItem(position: Int): Any {
        return events.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return events.count()
    }
*/


}












