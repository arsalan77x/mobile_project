package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class ReviewActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Button raedButton = (Button) findViewById(R.id.read);
        TextView authorText = (TextView) findViewById(R.id.author);
        TextView pagesText = (TextView) findViewById(R.id.pages);
        TextView genreText = (TextView) findViewById(R.id.genre);
        TextView publishText = (TextView) findViewById(R.id.publishDate);
        TextView reviewText = (TextView) findViewById(R.id.review);
        ImageView image = (ImageView) findViewById(R.id.image);

        if (Objects.equals(HomeActivity.tester, "1")) {
            image.setImageResource(R.drawable.book1);
            authorText.setText("Author: J.R.R Tolkien");
            pagesText.setText("Pages: 803");
            publishText.setText("Originally published: July 29, 1954");
            genreText.setText("Genre: fantasy, epic");
            reviewText.setText("Summary:The Fellowship of the Ring is the first of three volumes of the epic novel[2] The Lord of the Rings by the English author J. R. R. Tolkien. It is followed by The Two Towers and The Return of the King. It takes place in the fictional universe of Middle-earth, and was originally published on 29 July 1954 in the United Kingdom.\n" +
                    "\n" +
                    "The volume consists of a foreword, in which the author discusses his writing of The Lord of the Rings, a prologue titled \"Concerning Hobbits, and other matters\", and the main narrative in Book I and Book II.");
        }
        if (Objects.equals(HomeActivity.tester, "3")) {
            image.setImageResource(R.drawable.book3);
            authorText.setText("Author: Fyodor Dostoyevsky");
            pagesText.setText("Pages: 840");
            publishText.setText("Originally published: 1880");
            genreText.setText("Genre: Novel, Fiction, Suspense");
            reviewText.setText("Set in 19th-century Russia, The Brothers Karamazov is a passionate philosophical novel that enters deeply into questions of God, free will, and morality. It is a theological drama dealing with problems of faith, doubt, and reason in the context of a modernizing Russia, with a plot that revolves around the subject of patricide. Dostoevsky composed much of the novel in Staraya Russa, which inspired the main setting.[1] It has been acclaimed as one of the supreme achievements in world literature.");
        }
        if (Objects.equals(HomeActivity.tester, "2")) {
            image.setImageResource(R.drawable.book2);
            authorText.setText("Author:  George Orwell");
            pagesText.setText("Pages: 328");
            publishText.setText("Originally published: June 8, 1949");
            genreText.setText("Genre: Science fiction, Dystopian Fiction");
            reviewText.setText("Nineteen Eighty-Four (also published as 1984) is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime. Thematically, it centres on the consequences of totalitarianism, mass surveillance and repressive regimentation of people and behaviours within society.Orwell, a democratic socialist, modelled the authoritarian state in the novel on Stalinist Russia and Nazi Germany. More broadly, the novel examines the role of truth and facts within societies and the ways in which they can be manipulated.");
        }

        raedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReviewActivity.this, ReaderActivity.class));
            }
        });
    }
}