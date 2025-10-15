package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.*

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Attach swipe helper
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // >= 10 items
        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Mochi", "Sleeps all day",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Shadow", "Stealth mover",
                    "https://cdn2.thecatapi.com/images/MTc5ODIyNQ.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna", "Purr machine",
                    "https://cdn2.thecatapi.com/images/9oo.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Tiger", "Loves cardboard boxes",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyNg.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Pixel", "Debugger of yarn",
                    "https://cdn2.thecatapi.com/images/8f1.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Nori", "Treat hunter",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMg.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Ziggy", "Window watcher",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyNA.jpg")
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
