package winter2019.shift.nskevent_android.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_message_sending.*
import kotlinx.android.synthetic.main.activity_message_sending.view.*
import kotlinx.android.synthetic.main.fragment_event_viewing.view.*
import mehdi.sakout.fancybuttons.FancyButton
import winter2019.shift.nskevent_android.MainActivity
import winter2019.shift.nskevent_android.R
import winter2019.shift.nskevent_android.model.Event
import winter2019.shift.nskevent_android.presenter.Action
import winter2019.shift.nskevent_android.presenter.DialogPresenter
import winter2019.shift.nskevent_android.presenter.MVPContract
import winter2019.shift.nskevent_android.presenter.ViewFragmentPresenter

class EventViewActivity : AppCompatActivity(), MVPContract.ItemView, MVPContract.DialogView {

    private var alertDialog:AlertDialog?=null
    private var emailEditText:EditText?=null
    private var viewProgressBar: ProgressBar? = null

    override fun getEmail(): String {
        return emailEditText?.text.toString()
    }

    override fun showProgressBar() {
        viewProgressBar?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        viewProgressBar?.visibility = View.INVISIBLE

    }

    override fun hideDialog() {
        alertDialog?.dismiss()
    }

    override fun onSuccess() {
        Toast.makeText(applicationContext, "Операция прошла успешна", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onError() {
        Toast.makeText(applicationContext, "Регистраяция не удалась. Попробуйте еще раз позже.", Toast.LENGTH_SHORT).show()
    }

    override fun showDialog(event: Event?, action: Action?) {
        val viewMessageSend = LayoutInflater.from(this).inflate(R.layout.activity_message_sending, null)
        viewProgressBar=viewMessageSend.findViewById(R.id.progress_bar)
        viewProgressBar?.visibility=View.INVISIBLE
        viewProgressBar?.indeterminateDrawable?.setColorFilter(resources.getColor(R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
        val builder = AlertDialog.Builder(this)
                .setView(viewMessageSend)
        alertDialog = builder.show()

        val presenter = DialogPresenter(event, action)
        presenter.attachView(this)


        viewMessageSend.button_sending.setOnClickListener {
            presenter.onClick()
        }
        viewMessageSend.button_cancel.setOnClickListener {
            alertDialog?.dismiss()
        }

        emailEditText = viewMessageSend.findViewById<EditText>(R.id.edit_text_email_send)
    }

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_event_viewing)

        val txtTitile = findViewById<TextView>(R.id.title_event)
        val txtMessage = findViewById<TextView>(R.id.event_message)
        val txtLocation = findViewById<TextView>(R.id.location_event)
        val txtDate = findViewById<TextView>(R.id.event_date)
        val butArgee = findViewById<FancyButton>(R.id.event_agree)
        val butRefuse = findViewById<FancyButton>(R.id.event_refuse)
        val butEventDelete = findViewById<ImageView>(R.id.button_event_delete)
        val txtMembers=findViewById<TextView>(R.id.event_member)
        findViewById<ImageView>(R.id.back_button).setOnClickListener { onBackPressed() }

        val event: Event = intent.getParcelableExtra("EventsList")
        txtTitile.text = event.title
        txtMessage.text = event.message
        txtLocation.text = event.place
        txtDate.text = event.date
        txtMembers.text=event.memberCount.toString()

        val presenter = ViewFragmentPresenter(event)
        presenter.attachView(this)
        butArgee.setOnClickListener {
            presenter.onAccept()
        }
        butRefuse.setOnClickListener {
            presenter.onRefuse()
        }
        butEventDelete.setOnClickListener {
            presenter.onDelete()
        }
    }
}