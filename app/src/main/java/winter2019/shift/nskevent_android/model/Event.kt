package winter2019.shift.nskevent_android.model

data class Event(var id:String?,
                 var title:String,
                 var text:String,
                 var place:String,
                 var time:String,
                 var memberCount:Int,
                 var author:String)