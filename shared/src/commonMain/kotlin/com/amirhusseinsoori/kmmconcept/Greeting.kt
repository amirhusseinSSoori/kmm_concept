package com.amirhusseinsoori.kmmconcept

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}