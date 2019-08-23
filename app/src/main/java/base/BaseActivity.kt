package base

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity() {

    fun replaceFragment(fragment: Fragment, container : Int){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(container, fragment, "rageComicList")
            .addToBackStack("fragment")
            .commit()
    }
}