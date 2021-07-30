package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.view.adapter.ProfessorsAdapter
import com.esielkar.calificame.model.Faculty
import com.esielkar.calificame.model.Professor
import com.esielkar.calificame.model.ProfessorStats
import com.esielkar.calificame.model.University
import com.esielkar.calificame.utils.ProfessorWithInfo
import com.esielkar.calificame.view.HeaderCardView

class ProfessorsActivity : AppCompatActivity() {
    private lateinit var rec : RecyclerView
    private lateinit var headerCV : HeaderCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professors)

        //TODO: Universidad con facultad de prueba
        val u = University(resources.getString(R.string.university_name), setOf(
            Faculty(resources.getString(R.string.faculty_name),
                mapOf(
                    Professor(resources.getString(R.string.professor_name)) to ProfessorStats()
                ))
        ))

        val p = setOf(
            ProfessorWithInfo(Professor("Mayra Jiménez Maldonado"), 50, 80),
            ProfessorWithInfo(Professor("Luis David Ayala López"), 63, 60),
            ProfessorWithInfo(Professor("Esiel Kevin Arizmendi Ramírez"), 20, 40),
            ProfessorWithInfo(Professor("Héctor Manuel Chávez Troncoso"), 90, 80)
        )


        headerCV = findViewById(R.id.headerCV)
        headerCV.title = u.faculties.first().name
        headerCV.subtitle = u.name


        rec = findViewById(R.id.rec)
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            rec.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                setDrawable(it)
            })
        }
        rec.adapter = ProfessorsAdapter(p, onItemClickListener = {
            val intent = Intent(this, GeneralStatsActivity::class.java)
            //putExtra(it) TODO: Parcelable
            startActivity(intent)
        })
    }
}