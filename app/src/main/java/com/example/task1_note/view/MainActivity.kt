package com.example.task1_note.view

import androidx.appcompat.app.AppCompatActivity
import com.example.task1_note.presenter.MainPresenter
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.task1_note.R
import com.example.task1_note.model.MainModel
import android.widget.Toast

/*
    Сделать приложение "Заметка".
    Приложение должно содержать экран редактирования и, при нажатии на кнопку сохранения данных,
    вывести на экран сообщение об успешном сохранении текста.
    - Реализовать паттерн MVP.
*/

class MainActivity : AppCompatActivity(), IMainView {
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val model = MainModel()
        presenter = MainPresenter(model, this)
        presenter
        findViewById<View>(R.id.saveButton).setOnClickListener {
            val text = findViewById<EditText>(R.id.editText).text.toString()
            presenter.addNote(text)
        }
    }

    /**
     * Уведомляет об успешном сохранении заметки
     */
    override fun successSaveNotify() {
        Toast.makeText(this, "Заметка успешно сохранена", Toast.LENGTH_SHORT).show()
    }

    /**
     * Уведомляет о неудачном сохранении заметки
     */
    override fun errorSaveNotify() {
        Toast.makeText(this, "Не удалось сохранить заметку", Toast.LENGTH_SHORT).show()
    }
}