package org.example.kmpmovie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform