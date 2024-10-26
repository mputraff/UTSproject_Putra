package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        // Mengambil data dari intent
        val foodName = intent.getStringExtra("FOOD_NAME")
        val servings = intent.getStringExtra("SERVINGS")
        val orderingName = intent.getStringExtra("ORDERING_NAME")
        val notes = intent.getStringExtra("NOTES")

        // Menampilkan data di TextView
        findViewById<TextView>(R.id.tvConfirmFoodName).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.tvConfirmServings).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.tvConfirmName).text = "Ordering Name: $orderingName"
        findViewById<TextView>(R.id.tvConfirmNotes).text = "Additional Notes: $notes"

        // Menambahkan click listener untuk tombol Back to Menu
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            // Kembali ke ListFoodActivity dan membersihkan stack activity sebelumnya
            val intent = Intent(this, ListFoodActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}