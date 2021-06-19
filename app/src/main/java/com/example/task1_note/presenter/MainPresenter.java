package com.example.task1_note.presenter;


import android.widget.EditText;

import com.example.task1_note.R;
import com.example.task1_note.model.MainModel;
import com.example.task1_note.view.MainActivity;

public class MainPresenter implements MainPresenterInterface {

    private MainActivity view;
    private final MainModel model;

    public MainPresenter(MainModel model){
        this.model = model;
    }

    public void attachView(MainActivity view){
        this.view = view;
    }

    @Override
    public void addNote(){
        EditText editText = view.findViewById(R.id.editText);
        String text = editText.getText().toString();
        /*Вопрос:
            Нужно ли создавать интерфейс для Model?*/
        if(model.addNoteToDb(text)){
            view.showSaveNotify("Заметка сохранена");
        } else {
            view.showSaveNotify("Ошибка сохранения");
        }
    }
}
