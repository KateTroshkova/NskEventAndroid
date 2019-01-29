package winter2019.shift.nskevent_android.model.retrofit

import io.reactivex.Observable
import retrofit2.http.*
import winter2019.shift.nskevent_android.model.Event

interface IRequest {

    @GET("/api/v001/events")
    fun getAllEvent(): Observable<List<Event>>

    @GET("api/v001/events/{id}")
    fun getEvent(@Path("id") id:Int):Observable<Event>

    @GET("/api/v001/events")
    fun getNEvent(@Query("page") page:Int, @Query("limit") limit:Int):Observable<List<Event>>

    @PUT("/api/v001/events/{id}")
    fun sendAccept(@Path("id") id:Int, @Query("email") email:String):Observable<String>

    @POST("/api/v001/events")
    fun createEvent(@Body event:Event):Observable<Int>

    @DELETE("/api/v001/events/{id}")
    fun deleteEvent(@Path("id") id:Int, @Query("email") email:String):Observable<String>

    @DELETE("/api/v001/events/{id}")
    fun sendRefuse(@Path("id") id:Int, @Query("email") email:String):Observable<String>

}