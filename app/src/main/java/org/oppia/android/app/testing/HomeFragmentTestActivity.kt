package org.oppia.android.app.testing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.oppia.android.app.activity.InjectableAppCompatActivity
import org.oppia.android.app.home.HomeFragment
import org.oppia.android.app.home.RouteToRecentlyPlayedListener
import org.oppia.android.app.home.RouteToTopicListener
import org.oppia.android.app.home.RouteToTopicPlayStoryListener

/**
 * Test Activity for testing view models on the [HomeFragment].
 * This activity must implement listeners so the test can use it as a  [HomeFragmnet].
 */
class HomeFragmentTestActivity :
  RouteToTopicListener,
  RouteToTopicPlayStoryListener,
  RouteToRecentlyPlayedListener,
  InjectableAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityComponent.inject(this)
    supportFragmentManager.beginTransaction().add(
      HomeFragment(),
      "home_fragment_test_activity"
    ).commitNow()
  }

  companion object {
    fun createHomeFragmentTestActivity(context: Context): Intent {
      val intent = Intent(context, HomeFragmentTestActivity::class.java)
      return intent
    }
  }

  // Override functions are needed to fulfill listener definitions.
  override fun routeToTopic(internalProfileId: Int, topicId: String) {}
  override fun routeToTopicPlayStory(internalProfileId: Int, topicId: String, storyId: String) {}
  override fun routeToRecentlyPlayed() {}
}
