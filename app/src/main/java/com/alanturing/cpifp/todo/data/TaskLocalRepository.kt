package com.alanturing.cpifp.todo.data

import com.alanturing.cpifp.todo.model.Task

class TaskLocalRepository() {
    companion object {
        private var _INSTANCE:TaskLocalRepository? = null
        fun getInstance():TaskLocalRepository {
            //return _INSTANCE ?: TaskLocalRepository()
            if (_INSTANCE == null) {
                _INSTANCE = TaskLocalRepository()
            }
            return _INSTANCE!!
        }
    }
    private val _tasks = mutableListOf<Task>()
    private var id=0

    val tasks:List<Task>
        get() = _tasks

    fun add(task:Task) {
        task.id=id++
        _tasks.add(task)
    }
    fun delete(id:Int) {
        val existingTask = _tasks.find {it.id == id}
        if (existingTask != null) {
            _tasks.remove(existingTask)
        }
    }
    fun update(task:Task) {
        val existingTask = _tasks.find {it.id == task.id}
        if (existingTask != null) {
            val index = _tasks.indexOf(existingTask)
            _tasks[index] = task
        }
    }
}