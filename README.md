# Ships With Compose Mvvm UI States and Repository

This project is an application that applied some of the latest Google technologies for Android such
as Jetpack Compose, Hilt Dependencies Injection
and Room Database.

# The Project Contain the following technologies

The programming language is the [Kotlin](https://kotlinlang.org/docs/getting-started.html), it is a
modern, JVM-based programming language that is concise, safe, and interoperable with Java. <br />
[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) is used for asynchronous
tasks. <br />
[Kotlin KTX](https://developer.android.com/kotlin/ktx) is a collection of Kotlin extensions that
offer more concise and expressive code for working with Android APIs and libraries.
The UI is build using [Jetpack Compose](https://developer.android.com/develop/ui/compose). <br />
[Retrofit](https://square.github.io/retrofit/) is responsible for making requests and retrieving
data from the remote server. ([Repository](https://github.com/square/retrofit)) <br />
[Room Database](https://developer.android.com/training/data-storage/room) is responsible for saving
the retrieved data from the remote server, querying data from the local database, and supporting
offline functionality.  <br />
[Hilt Dependencies Injection](https://developer.android.com/training/dependency-injection/hilt-android)
is an Android library that simplifies dependency injection by using annotations to automatically
manage and provide dependencies across components, built on top of
Dagger. ([Documentation](https://dagger.dev/hilt/)) <br />
[MVVM](https://developer.android.com/topic/architecture#recommended-app-arch) with repository is an
architecture where the Repository manages data sources (e.g., network, database), the ViewModel
processes the data for the UI, and the View displays the UI, ensuring a clear separation of
concerns. <br />
[UI State](https://developer.android.com/topic/architecture/ui-layer/events#handle-viewmodel-events)
to initial, loading, loaded and error. <br />
[KSP](https://kotlinlang.org/docs/ksp-overview.html) (Kotlin Symbol Processing) is a tool for
processing Kotlin code at compile time, enabling developers to create powerful code generation and
annotation processing solutions. (ksp only setup for Room
Database) ([Repository](https://github.com/google/ksp)) <br />
[R8](https://developer.android.com/build/shrink-code) enabled, is a code shrinker and obfuscator for
Android that optimizes and reduces the size of APKs by removing unused code and resources, while
also obfuscating the remaining code to improve security. <br />
[Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) is a domain-specific
language for configuring Gradle build scripts using Kotlin syntax, offering better IDE support and
type safety compared to Groovy. <br />

# Versioning

Target SDK version: 35 <br />
Minimum SDK version: 28 <br />
Kotlin version: 2.1.20 <br />
Gradle version: 8.10.0 <br />

# Tutorials (Combination)

https://www.youtube.com/watch?v=eAbKK7JNxCE&ab_channel=PhilippLackner <br />
https://github.com/philipplackner/WeatherApp <br />
https://developer.android.com/topic/architecture/ui-layer/state-production <br />
https://github.com/android/architecture-samples <br />
https://github.com/android/sunflower <br />

# Feeds/Urls/End Point (parsing some data from the response)

## (Links References for Ends Points)

https://github.com/r-spacex/SpaceX-API (GitHub) <br />
https://docs.spacexdata.com/?version=latest (Postman) <br />