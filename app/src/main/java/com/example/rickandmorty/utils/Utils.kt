package com.example.rickandmorty.utils

object Utils {
    fun spliPeopleString(s: String): String {

        val separated = s.split("/")
        if (separated.size < 2)
            return ""
        return "characters/"+separated[separated.size- 2]
    }

    fun getImagePeople( url : String):String{

        return "https://starwars-visualguide.com/assets/img/"+ spliPeopleString(url) +".jpg"
    }

}