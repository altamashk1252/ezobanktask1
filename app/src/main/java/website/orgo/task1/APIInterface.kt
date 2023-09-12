package website.orgo.task1

import retrofit2.Response
import retrofit2.http.GET
import website.orgo.task1.models.ApiResponse

interface APIInterface {
    @GET("task")
    suspend fun getdata(): Response<ApiResponse>
}