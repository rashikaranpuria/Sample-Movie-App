package app.rashi.com.sample_movie_app.ui.base

interface IBasePresenter<V : IBaseView> {

    fun onAttach(v: V)

    fun onDetach()
}