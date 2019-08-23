package async

import com.app.delivery.mvp.vp.list.IDeliveryListPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * handle Delivery list api request
 * iDeliveryListPresenter to call back to Presenter
 */
class AsyncDeliveryListInteractor(var iDeliveryListPresenter: IDeliveryListPresenter) {


    val client by lazy {
        RetrofitClient.createClient()
    }

    var disposable: Disposable? = null

    /**
     * get delivery list from api and notify to Presenter
     * notify type ArrayList<Delivery>
     */
    fun requestDeliveryList() {

        disposable = client.requestDeliveryList()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    iDeliveryListPresenter.requestDeliveryListSucces(it)
                },
                {
                   // val errorMessage = ApiError(it).message
                    iDeliveryListPresenter.requestDeliveryListError()
                }

            )
    }
}