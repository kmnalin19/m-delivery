package base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import listeners.IView

/**
 * Base for all Fragment
 * extend androidx.fragment.app.Fragment,IView
 */
abstract class BaseFragment<P : BasePresenter<IView>> : IView, Fragment() {


    /**
     * implement in all fragment to create Presenter
     * @param view - fragment layout
     * @return BasePresenter type
     */
    protected abstract fun instantiatePresenter(view: View): P

    /**
     * addToBackStack
     * @param fragment - next fragment want to load
     * @param container - layout to replace fragment
     */
    fun replaceFragment(fragment: Fragment, container : Int){
        activity!!.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(container, fragment, "rageComicList").addToBackStack("fragment")
            .commit()
    }

    /**
     * replace without adding ToBackStack
     * @param fragment - next fragment want to load
     * @param container - layout to replace fragment
     */
    fun replaceFragment1(fragment: Fragment, container : Int){

        // it won't add to stack
        activity!!.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(container, fragment, "rageComicList")
            .commit()
    }

    /**
     * call instantiatePresenter to create Presenter
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        instantiatePresenter(view)
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * IView override fun
     * @return Context - application context
     */
    override fun requestContext(): Context {
        return activity!!.applicationContext
    }

    /**
     * IView override fun
     * @return Context - current activity
     */
    override fun requestActivity(): Activity {
       return activity!!
    }

    override fun onFailed(o: Any) {
    }

    override fun onSuccess(o: Any) {
    }

    override fun onError(o: Any) {
    }
}