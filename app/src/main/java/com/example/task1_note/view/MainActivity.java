package com.example.task1_note.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.task1_note.R;
import com.example.task1_note.model.MainModel;
import com.example.task1_note.presenter.MainPresenter;
import com.example.task1_note.presenter.MainPresenterInterface;

public class MainActivity extends AppCompatActivity{

    private MainPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Вопрос:
                    Насколько я понял, в данном случае в обязанности View входит только оповещение
                Presenter о нажатии пользователем кнопки, а дальнейшую логику должен выполнять Presenter.
                Если мы создадим интерфейс для View, к которому будет обращаться Presenter,
                то не сможем использовать, к примеру, findViewById(), чтобы получить введённый
                пользователем текст.
                    Что нужно делать в этом случае? Создавать метод, возвращающий
                необходимую строку, или передавать её в качестве параметра из View в Presenter?
                Или совсем другой вариант?*/
                presenter.addNote();
            }
        });
        MainModel model = new MainModel();
        presenter = new MainPresenter(model);
        presenter.attachView(this);
    }

    /*Вопрос:
        Правильно ли, что уведомление должен выводить View?*/
    public void showSaveNotify(String notify) {
        Toast toast = Toast.makeText(this, notify, Toast.LENGTH_LONG);
        toast.show();
    }
}
