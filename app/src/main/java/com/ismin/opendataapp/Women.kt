package com.ismin.opendataapp
import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class Women(
    @SerializedName("datasetid")
    val datasetid: String,
    @SerializedName("recordid")
    val recordid: String,
    @SerializedName("fields")
    val fields: String,
    @SerializedName("geometry")
    val geometry: String,
    @SerializedName("record_timestamp")
    val record_timestamp: String
):Serializable

data class Fields(
    @SerializedName("desc1")

    val desc1: String,
    @SerializedName("desc2")

    val desc2: String,
    @SerializedName("desc3")

    val desc3: String,
    @SerializedName("desc4")

    val desc4: String,
    @SerializedName("geo_point_2d")

    val geo_point_2d: List<Double>,
    @SerializedName("geo_shape")
    val geo_shape: GeoShape,
    @SerializedName("lat")

    val lat: Double,
    @SerializedName("long")

    val long: Double,
    @SerializedName("name")

    val name: String,
    @SerializedName("photos")

    val photos: Photos,
    @SerializedName("short_desc")

    val short_desc: String,
    @SerializedName("tab_name")

    val tab_name: String,
    @SerializedName("thumb_url")

    val thumb_url: String
)

data class GeoShape(
    @SerializedName("coordinates")

    val coordinates: List<Double>,
    @SerializedName("type")

    val type: String
)

data class Photos(
    @SerializedName("color_summary")

    val color_summary: List<String>,
    @SerializedName("filename")

    val filename: String,
    @SerializedName("format")

    val format: String,
    @SerializedName("height")

    val height: Int,
    @SerializedName("id")

    val id: String,
    @SerializedName("mimetype")

    val mimetype: String,
    @SerializedName("thumbnail")

    val thumbnail: Boolean,
    @SerializedName("width")

    val width: Int
)

data class Geometry(
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("val")
    val type: String
)