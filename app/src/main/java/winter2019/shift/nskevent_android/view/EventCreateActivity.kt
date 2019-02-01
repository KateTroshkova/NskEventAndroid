package winter2019.shift.nskevent_android.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import kotlinx.android.synthetic.main.activity_message_sending.view.*
import kotlinx.android.synthetic.main.fragment_event_creating.*
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
    private var alertDialog:AlertDialog?=null

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
    }

    override fun hideProgressBar() {
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

        titleEditText = findViewById<EditText>(R.id.title_event)
        messageEditText = findViewById<EditText>(R.id.event_message)
        placeEditText = findViewById<EditText>(R.id.location_event)
        dateEditText = findViewById<EditText>(R.id.event_date)
        emailEditText = findViewById<EditText>(R.id.event_email)
        var buttonCreateEvent = findViewById<Button>(R.id.button_create_events)
        val progressBarCreate = findViewById<ProgressBar>(R.id.progress_bar_create)

/*
        val presenter = CreateFragmentPresenter()
        button_create.setOnClickListener {
            presenter.onClick()
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_event_create, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         when (item?.itemId) {
             R.id.button_create_events -> {
                 val viewMessageSend = LayoutInflater.from(this).inflate(R.layout.activity_message_sending, null)
                 val builder = AlertDialog.Builder(this)
                         .setTitle("Введите ваш email для подтверждения")
                         .setView(viewMessageSend)
                 alertDialog = builder.show()

                 val presenter = CreateFragmentPresenter()
                 presenter.attachView(this)
                 viewMessageSend.button_sending.setOnClickListener {
                     presenter.onClick()
                 }

             }
         }
                return super.onOptionsItemSelected(item)

    }

}
