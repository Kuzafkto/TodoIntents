package com.alanturing.cpifp.todo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.databinding.ActivityCreateToDoBinding
import com.alanturing.cpifp.todo.databinding.ActivityMainBinding
import com.alanturing.cpifp.todo.model.Task

class CreateToDoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateToDoBinding
    private val repository = TaskLocalRepository.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createButton.setOnClickListener {
            var taskId = 0
            val task = Task(++taskId, binding.titleInput.text.toString(), binding.descriptionInput.text.toString())
            repository.add(task)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.cancelButton.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}