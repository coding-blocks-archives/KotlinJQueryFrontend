package main.kotlin

import kotlin.browser.*
import kotlin.dom.*
import kotlinx.html.*
import kotlinx.html.dom.*
import types.*
import types.jQuery


data class Todo(
		var task: String?,
		var done: Boolean? = false
)
fun main(args: Array<String>) {
    window.onload = {
        val J = jQuery
        console.log("Started")

        var todos: ArrayList<Todo> = ArrayList()

        val list = J("#todolist")
        val btn = J("#addtodo")
        val todo = J("#newtodo")

        fun refresh () {
            console.log("refresh")
            list.empty()
            todos = JSON.parse(localStorage.getItem("TODOS") ?: "[]") as ArrayList<Todo>
            console.log(todos)
            for (t in todos) {
                list.get()[0].append { li { +t.task!! } }
            }
        }

        fun saveList () {
            console.log("save")
            localStorage.setItem("TODOS", JSON.stringify(todos))
        }

        btn.click {
            todos.add(Todo(task = todo.`val`().toString()))
            saveList()
            refresh()
        }

        0
    }
}