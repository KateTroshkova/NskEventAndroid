package winter2019.shift.nskevent_android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.*
import android.widget.ListView

import kotlinx.android.synthetic.main.toolbar.*
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.presenter.ListFragmentPresenter
import winter2019.shift.nskevent_android.presenter.MVPContract
import winter2019.shift.nskevent_android.view.EventCreateActivity
import winter2019.shift.nskevent_android.view.EventViewActivity
import winter2019.shift.nskevent_android.view.EventsAdapter

class MainActivity : AppCompatActivity(), MVPContract.ListView{

    var presenter:ListFragmentPresenter?=null

    override fun load(events: MutableList<Event>?) {
        val listEvent = findViewById(R.id.list_events) as ListView
        listEvent.adapter = EventsAdapter(this, R.layout._list_item_event_one, events as ArrayList<Event>)
        listEvent.setOnItemClickListener { AdapterView, view, position, id ->
           presenter?.onItemClick(position)
        }
    }

    override fun update(events: MutableList<Event>?) {
    }

    override fun showDetail(event: Event?) {
        val intent = Intent(this, EventViewActivity::class.java)
        intent.putExtra("EventsList", event)
        startActivity(intent)
    }

    override fun onError() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(event_toolbar)

        presenter=ListFragmentPresenter()
        presenter?.attachView(this)
        presenter?.viewIsReady()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
        if (isFinishing()) {
            presenter?.destroy()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_add_event, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.button_item_new_event -> showCreateActivity(this)
        }
        return super.onOptionsItemSelected(item)
    }

    fun showCreateActivity(context: Context) {
        val intent = Intent(context, EventCreateActivity::class.java)
        startActivity(intent)
    }
}