package com.example.rickandmorty.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "characters")
@Parcelize
data class Character(
    @Expose
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @Expose
    @SerializedName("url")
    var url: String? = "",
    @Expose
    @SerializedName("edited")
    var edited: String? = "",
    @Expose
    @SerializedName("created")
    var created: String? = "",
    @Expose
    @SerializedName("films_string")
    var filmsList: String? = "",
    @Expose
    @Ignore
    @SerializedName("starships")
    var starships:  List<String>? = null,
    @Expose
    @Ignore
    @SerializedName("vehicles")
    var vehicles:  List<String>? = null,
    @Expose
    @Ignore
    @SerializedName("species")
    var species:  List<String>? = null,
    @Expose
    @Ignore
    @SerializedName("films")
    var films:  List<String>? = null,
    @Expose
    @SerializedName("homeworld")
    var homeworld: String? = "",
    @Expose
    @SerializedName("gender")
    var gender: String? = "",
    @Expose
    @SerializedName("birth_year")
    var birth_year: String? = "",
    @Expose
    @SerializedName("eye_color")
    var eye_color: String? = "",
    @Expose
    @SerializedName("skin_color")
    var skin_color: String? = "",
    @Expose
    @SerializedName("hair_color")
    var hair_color: String? = "",
    @Expose
    @SerializedName("mass")
    var mass: String? = "",
    @Expose
    @SerializedName("height")
    var height: String? = "",
    @Expose

    @SerializedName("name")
    var name: String? = ""
):Parcelable
