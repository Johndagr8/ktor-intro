package com.example.plugins

import com.example.models.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("files")
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
        get("/") {
            call.respondRedirect("articles")
        }
        route("articles") {
            get {
                call.respond(FreeMarkerContent("index.ftl", mapOf("articles" to articles)))
            }
            get("new") {
                // Show a page with fields for creating a new article
            }
            post {
                // Save an article
            }
            get("{id}") {
                // Show an article with a specific id
            }
            get("{id}/edit") {
                // Show a page with fields for editing an article
            }
            post("{id}") {
                // Update or delete an article
            }
        }
    }
}
