package study.kase.casestudyromantwozero

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM="item"

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)
        bottomNavigationMenu.setOnItemSelectedListener { item->
            var fragment: Fragment?
            when(item.itemId){
                R.id.about_item -> {
                    fragment = AboutMeFragment()
                    replaceFragment(fragment)
                }
                R.id.my_hobby_item -> {
                    fragment = MyHobbyFragment()
                    replaceFragment(fragment)
                }

            }
            fragment = null

            when(item.itemId) {
                R.id.my_group_item -> {
                    val recyclerViewActivityIntent = Intent(this,RecyclerViewActiviy::class.java)
                    startActivity(recyclerViewActivityIntent)
                }
                R.id.sms_me_item -> {
                    val messageIntent =
                        Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:+79539130290"))
                    messageIntent.putExtra("sms_body", "Привет, Роман! :-)")
                    startActivity(messageIntent)
                }
            }
            true
        }

        bottomNavigationMenu.selectedItemId =
            if (savedInstanceState!=null) savedInstanceState.getInt(LAST_SELECTED_ITEM) else R.id.about_item

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM,bottomNavigationMenu.selectedItemId)
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view,fragment)
            .commit()
    }

    }
