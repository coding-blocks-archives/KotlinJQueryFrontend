package main.kotlin

import kotlin.browser.*
import kotlin.dom.*
import kotlinx.html.*
import kotlinx.html.dom.*
import types.JQuery
import types.JQueryStatic
import types.`$`
import types.jQuery


data class Todo(
		var task: String?,
		var done: Boolean? = false
)
fun main(args: Array<String>) {
    window.onload = {
        val J = jQuery
        console.log("Started")

        var todos = ArrayList<Todo>()

        val list = J("#todolist")
        val btn = J("#addtodo")
        val todo = J("#newtodo")

        fun refresh () {
            list.empty()
            for (t in todos) {
                list.get()[0].append { li { +t.task!! } }
            }
        }

        btn.click {
            todos.add(Todo(task = todo.`val`().toString()))
            refresh()
        }

        0
    }
}