package com.example.task1_note.model;

public class MainModel {
    /**
     * Псевдо-сохранение заметки, всегда возвращает истину
     * @param note текст введённой заметки
     * @return всегда возвращает true
     */
    public boolean addNoteToDb(String note){
        return true;
    }
}
