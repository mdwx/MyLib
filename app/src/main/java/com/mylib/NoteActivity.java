package com.mylib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import base.greendao.Customer;
import base.greendao.Note;
import base.greendao.NotesAdapter;
import base.greendao.Types;

public class NoteActivity extends AppCompatActivity {

    private EditText editText;
    private View addNoteButton;

    private NotesAdapter notesAdapter;
    private DaoManager daoManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setUpViews();

        // get the note DAO
        daoManager = new DaoManager(((App) getApplication()).getDaoSession(), Note.class);

//        // query all notes, sorted a-z by their text
//        notesQuery = noteDao.queryBuilder().orderAsc(NoteDao.Properties.Text).build();

        updateNotes();

    }
    private void updateNotes() {
        notesAdapter.setNotes(daoManager.getList());
    }

    protected void setUpViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewNotes);
        //noinspection ConstantConditions
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notesAdapter = new NotesAdapter(new NotesAdapter.NoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Note note = notesAdapter.getNote(position);
                Long noteId = note.getId();

                daoManager.getDao().deleteByKey(noteId);
                Log.d("DaoExample", "Deleted note, ID: " + noteId);

                updateNotes();
            }
        });
        recyclerView.setAdapter(notesAdapter);

        addNoteButton = findViewById(R.id.buttonAdd);
        //noinspection ConstantConditions
        addNoteButton.setEnabled(false);

        editText = (EditText) findViewById(R.id.editTextNote);
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    addNote();
                    return true;
                }
                return false;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean enable = s.length() != 0;
                addNoteButton.setEnabled(enable);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void onAddButtonClick(View view) {
        addNote();
    }

    private void addNote() {


        String noteText = editText.getText().toString();
        editText.setText("");

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());

        Note note = new Note(null, noteText, comment, new Date(), Types.TEXT);
        daoManager.insert(note);
        daoManager.insert(Customer.class,new Customer(10L,"person1", 32, "man",new Date(),new Date(), null,new Date()));

        List list = daoManager.getList(Customer.class);
        if(list != null) {
            for (Object p : list) {
                System.out.println(p.toString());
            }
    }
        daoManager.getDao(Customer.class).deleteAll();
        Log.d("DaoExample", "Inserted new note, ID: " + note.getId());

        updateNotes();
    }
}

