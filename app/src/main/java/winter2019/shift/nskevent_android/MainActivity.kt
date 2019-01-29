package winter2019.shift.nskevent_android

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.*

import kotlinx.android.synthetic.main.activity_fragment.*
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.presenter.ListFragmentPresenter
import winter2019.shift.nskevent_android.presenter.MVPContract

class MainActivity : AppCompatActivity(), MVPContract.ListView{
    override fun load(events: MutableList<Event>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(events: MutableList<Event>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDetail(event: Event?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var presenter:ListFragmentPresenter?=null//presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        setSupportActionBar(toolbar)
        presenter= ListFragmentPresenter()
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

