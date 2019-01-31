package winter2019.shift.nskevent_android.view

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_message_sending.view.*
import winter2019.shift.nskevent_android.R
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.presenter.Action
import winter2019.shift.nskevent_android.presenter.DialogPresenter
import winter2019.shift.nskevent_android.presenter.MVPContract
import winter2019.shift.nskevent_android.presenter.ViewFragmentPresenter

class EventViewActivity : AppCompatActivity(), MVPContract.ItemView, MVPContract.DialogView {
    override fun getEmail(): String {
        val eventGuestEmail = findViewById<EditText>(R.id.edit_text_email_send).toString()
        return eventGuestEmail
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDialog(event: Event?, action: Action?) {
        val viewMessageSend = LayoutInflater.from(this).inflate(R.layout.activity_message_sending, null)

        val builder = AlertDialog.Builder(this)
                .setTitle("Введите ваш email для подтверждения")
                .setView(viewMessageSend)
        val AlertDialog = builder.show()

        viewMessageSend.button_sending.setOnClickListener {
            AlertDialog.dismiss()

            var presenter: DialogPresenter? = null
            presenter = DialogPresenter(event, action)
            presenter!!.attachView(this)

            //диалог презентер
            Toast.makeText(applicationContext, "Вы зарегистрированы", Toast.LENGTH_SHORT).show()
        }

        viewMessageSend.button_cancel.setOnClickListener {
            AlertDialog.dismiss()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_event_viewing)

        var txtTitile = findViewById<TextView>(R.id.title_event)
        var txtMessage = findViewById<TextView>(R.id.event_message)
        var txtLocation = findViewById<TextView>(R.id.location_event)
        var txtDate = findViewById<TextView>(R.id.event_date)
        val butArgee = findViewById<Button>(R.id.event_agree)
        var butRefuse = findViewById<Button>(R.id.event_refuse)

        val bundle = intent.extras

        var position = bundle.getInt("eventPosition")
        var eventsList = intent.getParcelableArrayListExtra<Event>("EventsList")

        var event: Event = eventsList.get(position) as Event
        txtTitile.text = event.title
        txtMessage.text = event.message
        txtLocation.text = event.place
        txtDate.text = event.date

        var presenter: ViewFragmentPresenter? = null
        presenter = ViewFragmentPresenter(event)
        presenter!!.attachView(this)

        butArgee.setOnClickListener {
            presenter?.onAccept()
        }

        butRefuse.setOnClickListener {
            presenter?.onRefuse()
        }
    }


}