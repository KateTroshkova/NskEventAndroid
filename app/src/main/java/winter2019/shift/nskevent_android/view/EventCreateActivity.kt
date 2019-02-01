package winter2019.shift.nskevent_android.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*
import winter2019.shift.nskevent_android.MainActivity
import winter2019.shift.nskevent_android.R
import winter2019.shift.nskevent_android.presenter.CreateFragmentPresenter
import winter2019.shift.nskevent_android.presenter.MVPContract

class EventCreateActivity : AppCompatActivity(), MVPContract.CreateView {

    private var titleEditText: EditText? = null
    private var messageEditText: EditText? = null
    private var dateEditText: EditText? = null
    private var placeEditText: EditText? = null
    private var memberCount: Int = 0
    private var emailEditText: EditText? = null

    override fun getTitleEvent(): String {
        return titleEditText?.text.toString()
    }

    override fun getMessage(): String {
        return messageEditText?.text.toString()
    }

    override fun getDate(): String {
        return dateEditText?.text.toString()
    }

    override fun getPlace(): String {
        return placeEditText?.text.toString()
    }

    override fun getMemberCount(): Int {
        return memberCount
    }

    override fun getEmail(): String {
        return emailEditText?.text.toString()
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess() {
        Toast.makeText(applicationContext, "Событие создано!", Toast.LENGTH_SHORT).show()
    }

    override fun onError() {
        Toast.makeText(applicationContext, "Событие не создано. Попробуйте позже", Toast.LENGTH_SHORT).show()
    }

    override fun showAll() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_event_creating)
        setSupportActionBar(event_toolbar)

        val edTitile = findViewById<EditText>(R.id.title_event)
        val edMessage = findViewById<EditText>(R.id.event_message)
        val edLocation = findViewById<EditText>(R.id.location_event)
        val edDate = findViewById<EditText>(R.id.event_date)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_event_create, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         when (item?.itemId) {
             R.id.button_create_events -> pressEventCreationButton()
         }
                return super.onOptionsItemSelected(item)

    }

    fun pressEventCreationButton() {
        val presenter = CreateFragmentPresenter()
        presenter.onClick()
    }
}
