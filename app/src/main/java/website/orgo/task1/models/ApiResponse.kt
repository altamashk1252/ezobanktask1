package website.orgo.task1.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ApiResponse {

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("items")
    @Expose
    var items: List<ItemResponse>? = null
}