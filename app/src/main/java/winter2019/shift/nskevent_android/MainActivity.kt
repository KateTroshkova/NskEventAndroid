package winter2019.shift.nskevent_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.*
import android.widget.ListView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.presenter.ListFragmentPresenter
import winter2019.shift.nskevent_android.presenter.MVPContract
import winter2019.shift.nskevent_android.view.EventAdapter

class MainActivity : AppCompatActivity(), MVPContract.ListView{
    override fun load(events: MutableList<Event>?) {
        Toast.makeText(this, "here", Toast.LENGTH_SHORT).show()
        var listEvent = findViewById(R.id.list_events) as ListView

        var listTest: ArrayList<Event> = ArrayList()
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))

        listEvent.adapter = EventAdapter(this, listTest)
    }

    override fun update(events: MutableList<Event>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDetail(event: Event?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    var presenter:ListFragmentPresenter?=null//presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        setSupportActionBar(toolbar)
        presenter=ListFragmentPresenter()
        presenter!!.attachView(this)
       // presenter?.viewIsReady()


        var listEvent = findViewById(R.id.list_events) as ListView

        var listTest: ArrayList<Event> = ArrayList()
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))
        listTest.add(Event(0, "Titttttttt", "dddddddddddd", "00011212", "lololol", 0, "ddd"))

        listEvent.adapter = EventAdapter(this, listTest)
    }

    fun update(view:View){

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
        if (isFinishing()) {
            presenter?.destroy()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}