package website.orgo.task1.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class ItemResponse {
    @SerializedName("itemName")
    @Expose
    var itemName: String? = null

    @SerializedName("itemPrice")
    @Expose
    var itemPrice: Int? = null

    @SerializedName("itemBarcode")
    @Expose
    var itemBarcode: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

}