package winter2019.shift.nskevent_android.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import winter2019.shift.nskevent_android.R
import winter2019.shift.nskevent_android.presenter.MVPContract

class FuckingActivity : AppCompatActivity(), MVPContract.ListView{

    override fun load(events: MutableList<Any?>?) {
        Toast.makeText(this, events?.size.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fucking)
        var view=findViewById<ListView>(R.id.list)
    }
}
