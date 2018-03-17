package android.rashi.com.sample_movie_app.ui.base

import android.view.View

interface IBasePresenter<V: IBaseView> {

    fun onAttach(v: V)

    fun onDetach()

}