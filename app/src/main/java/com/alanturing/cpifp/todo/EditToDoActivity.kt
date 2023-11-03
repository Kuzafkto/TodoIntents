package com.alanturing.cpifp.todo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.databinding.ActivityCreateToDoBinding
import com.alanturing.cpifp.todo.databinding.ActivityEditToDoBinding
import com.alanturing.cpifp.todo.model.Task


class EditToDoActivity:AppCompatActivity() {
    private lateinit var binding: ActivityEditToDoBinding
    private val repository = TaskLocalRepository.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val task: Task? =intent?.extras?.getParcelable("TASK")
        var taskId = 0
        if(task!=null){
            taskId = task.id
        }
        binding.titleInput.setText(task?.title)
        binding.descriptionInput.setText(task?.description)
        binding.confirmButton.setOnClickListener{
            val task=Task(taskId,binding.titleInput.text.toString(),binding.descriptionInput.text.toString())
            repository.update(task)
            setResult(Activity.RESULT_OK)
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.cancelButton.setOnClickListener(){
            finish();
        }
    }
    }