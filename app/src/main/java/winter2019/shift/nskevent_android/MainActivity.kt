package winter2019.shift.nskevent_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.*
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main.*
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.presenter.ListFragmentPresenter
import winter2019.shift.nskevent_android.presenter.MVPContract
import winter2019.shift.nskevent_android.view.EventAdapter

class MainActivity : AppCompatActivity(), MVPContract.ListView{
    override fun click() {

    }

    override fun load(events: ArrayList<Event>?) {
        var list=findViewById<ListView>(R.id.list_events)
        var adapter= EventAdapter(this, events)
        list.adapter=adapter
    }

    override fun update(event: Event?) {
    }//view

    var presenter:ListFragmentPresenter?=null//presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        setSupportActionBar(toolbar)
        presenter=ListFragmentPresenter()
        presenter!!.attachView(this)
        presenter?.viewIsReady()
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

