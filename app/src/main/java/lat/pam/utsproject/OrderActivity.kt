package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        // Mengambil nama makanan dari intent
        val foodName = intent.getStringExtra("FOOD_NAME")

        // Mencari TextView di layout dan mengatur teksnya
        val tvFoodName = findViewById<TextView>(R.id.etFoodName)
        tvFoodName.text = foodName
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val servings = findViewById<EditText>(R.id.etServings).text.toString()
            val orderingName = findViewById<EditText>(R.id.etName).text.toString()
            val notes = findViewById<EditText>(R.id.etNotes).text.toString()

            // Pindah ke ConfirmationActivity dengan membawa data
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("FOOD_NAME", foodName)
                putExtra("SERVINGS", servings)
                putExtra("ORDERING_NAME", orderingName)
                putExtra("NOTES", notes)
            }
            startActivity(intent)
        }
    }
}