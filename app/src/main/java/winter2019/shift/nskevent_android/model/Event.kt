package winter2019.shift.nskevent_android.model

import android.os.Parcelable

class Event():Parcelable {

    var id: Int?=null
    var title: String?=null
    var message: String?=null
    var date: String?=null
    var place: String?=null
    var memberCount: Int?=null
    var autor: String?=null

    constructor(id: Int?, title: String?, message: String?, date: String?, place: String?, memberCount: Int?, autor: String?) : this() {
        this.id=id
        this.title=title
        this.message=message
        this.date=date
        this.place=place
        this.memberCount=memberCount
        this.autor=autor
    }

    protected constructor(dest: android.os.Parcel) : this() {
        id=dest.readInt()
        title=dest.readString()
        message=dest.readString()
        date=dest.readString()
        place=dest.readString()
        memberCount=dest.readInt()
        autor=dest.readString()
    }

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<Event> {
            override fun createFromParcel(`in`: android.os.Parcel): Event {
                return Event(`in`)
            }

            override fun newArray(size: Int): Array<Event?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(dest: android.os.Parcel?, flags: Int) {
        dest?.writeInt(id!!)
        dest?.writeString(title)
        dest?.writeString(message)
        dest?.writeString(date)
        dest?.writeString(place)
        dest?.writeInt(memberCount!!)
        dest?.writeString(autor)
    }

    override fun describeContents(): Int {
        return 0
    }
}