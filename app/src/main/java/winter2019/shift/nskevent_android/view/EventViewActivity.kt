package winter2019.shift.nskevent_android.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import winter2019.shift.nskevent_android.R
import winter2019.shift.nskevent_android.model.Event

class EventViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_event_viewing)

        var txtTitile = findViewById<TextView>(R.id.title_event)
        var txtMessage = findViewById<TextView>(R.id.event_message)
        var txtLocation = findViewById<TextView>(R.id.location_event)
        var txtDate = findViewById<TextView>(R.id.event_date)
        var butArgee = findViewById<Button>(R.id.event_agree)
        var butRefuse = findViewById<Button>(R.id.event_refuse)

        val bundle = intent.extras

        var position = bundle.getInt("eventPosition")
        var eventsList = intent.getParcelableArrayListExtra<Event>("EventsList")

        var event: Event = eventsList.get(position) as Event
        txtTitile.text = event.title
        txtMessage.text = event.message
        txtLocation.text = event.place
        txtDate.text = event.date

    }
}