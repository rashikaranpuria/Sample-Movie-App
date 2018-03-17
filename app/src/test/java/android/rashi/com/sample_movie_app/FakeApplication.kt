package android.rashi.com.sample_movie_app

import android.rashi.com.sample_movie_app.di.Components.AppComponent
import org.mockito.Mockito.mock

class FakeApplication: MovieApplication() {
    var applicationComponent: AppComponent = mock(AppComponent::class.java)
}