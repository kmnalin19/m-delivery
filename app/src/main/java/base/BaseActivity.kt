package base

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity


/**
 * @author nalin madushanka
 * base for Activities
 */
open class BaseActivity : AppCompatActivity() {

    /**
     * addToBackStack
     * @param fragment - next fragment want to load
     * @param container - layout to replace fragment
     */
    fun replaceFragment(fragment: Fragment, container : Int){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(container, fragment, "rageComicList")
            .addToBackStack("fragment")
            .commit()
    }
}