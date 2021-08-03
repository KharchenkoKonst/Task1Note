package com.example.task1_note.presenter

import com.example.task1_note.model.MainModel
import com.example.task1_note.view.MainActivity
import android.widget.EditText
import com.example.task1_note.R
import com.example.task1_note.view.IMainView

class MainPresenter(private val model: MainModel, private val view: IMainView) {

    /**
     * Псевдо-добавление заметки в базу данных
     * @param data текст заметки
     */
    fun addNote(data: String) {
        if (model.addNoteToDb(data)) {
            view.successSaveNotify()
        } else {
            view.errorSaveNotify()
        }
    }
}