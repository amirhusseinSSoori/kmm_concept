package com.amirhusseinsoori.kmmconcept

class SimpleCollection {
    private var list= ArrayList<String>()
    fun showList(): List<String> {
        return  list
    }


    fun addData(input:String){
        list.add(input)
    }
    fun removeData(input:String){
        list.remove(input)
    }
}