package com.alanturing.cpifp.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alanturing.cpifp.todo.databinding.TodoItemBinding
import com.alanturing.cpifp.todo.model.Task

class TasksAdapter(val datos:List<Task>,val onShare:((t:Task,v: View)->Unit),val onEditItem:((t:Task,v:View)->Unit)): RecyclerView.Adapter<TasksAdapter.TaskViewHolder>(){
    inner class TaskViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTask(t:Task){
            binding.title.text = t.title
            binding.description.text = t.description
            binding.isCompleted.isChecked = t.isCompleted
            binding.btnShare.setOnClickListener{
                onShare(t,it)
            }
            binding.btnEdit.setOnClickListener{
                onEditItem(t,it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false,)
        return TaskViewHolder(binding)
    }

    override fun getItemCount() = datos.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = datos[position]
        holder.bindTask(task)
    }
}