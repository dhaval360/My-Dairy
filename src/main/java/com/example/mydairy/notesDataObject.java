package com.example.mydairy;

public class notesDataObject {

    private String date;
    private String noteData;

    public void setDate(String date){
        this.date = date;
    }
    public void setNoteData(String noteData){
        this.noteData = noteData;
    }

    public String getDate(){
        return date;
    }
    public String getNoteData(){
        return noteData;
    }

    public notesDataObject(String d, String n){
        date = d;
        noteData = n;
    }
}
