# Ships With Compose Mvvm UI States and Repository

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Static Badge](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Static Badge](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

This project is an Android application that demonstrates a modern, scalable architecture using some of the latest technologies recommended by Google, including Jetpack Compose, Hilt, and Room.

## ✨ Features

*   **Modern UI:** Built entirely with **Jetpack Compose**, Android's declarative UI toolkit.
*   **Clean Architecture:** Follows the **MVVM (Model-View-ViewModel)** pattern with a repository, ensuring a robust and maintainable codebase.
*   **Offline Support:** Caches data using **Room Database**, allowing the app to function without an internet connection.
*   **Efficient Networking:** Fetches data from a remote server using **Retrofit**.
*   **Reliable State Management:** Implements a **UI State** pattern to handle loading, success, and error states gracefully.
*   **Optimized Performance:** Leverages **Coroutines** for asynchronous operations, **KSP** for faster annotation processing, and **R8** for code shrinking and optimization.
*   **Simplified Dependency Injection:** Uses **Hilt** to manage dependencies throughout the app.

## 🛠️ Tech Stack & Libraries

This project is built with **[Kotlin](https://kotlinlang.org/docs/getting-started.html)** and utilizes a variety of modern Android libraries and tools:

-   **UI:** [Jetpack Compose](https://developer.android.com/develop/ui/compose)
-   **Architecture:** [MVVM](https://developer.android.com/topic/architecture#recommended-app-arch), [Repository Pattern](https://developer.android.com/topic/architecture/data-layer), [UI State Management](https://developer.android.com/topic/architecture/ui-layer/events#handle-viewmodel-events)
-   **Asynchronicity:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html), [Kotlin KTX](https://developer.android.com/kotlin/ktx)
-   **Data:** [Retrofit](https://square.github.io/retrofit/) (Networking), [Room](https://developer.android.com/training/data-storage/room) (Database)
-   **Dependency Injection:** [Hilt](https://dagger.dev/hilt/)
-   **Build & Optimization:** [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html), [KSP](https://kotlinlang.org/docs/ksp-overview.html), [R8](https://developer.android.com/build/shrink-code)

## ⚙️ Versioning

-   **Target SDK:** `36`
-   **Minimum SDK:** `29`
-   **Kotlin Version:** `2.3.10`
-   **Gradle Version:** `9.0.1`

## 🛰️ Data Source

The data for this application is parsed from the SpaceX API.

-   **API GitHub:** [SpaceX-API GitHub](https://github.com/r-spacex/SpaceX-API)
-   **API Documentation:** [SpaceX-API Docs (Postman)](https://docs.spacexdata.com/?version=latest)

## 📚 Inspirations & Tutorials

This project was built by combining knowledge and techniques from various excellent resources:

-   [Philipp Lackner's WeatherApp Tutorial](https://www.youtube.com/watch?v=eAbKK7JNxCE) and [Repository](https://github.com/philipplackner/WeatherApp)
-   [Android Architecture - UI Layer State Production](https://developer.android.com/topic/architecture/ui-layer/state-production)
-   [Official Android Architecture Samples](https://github.com/android/architecture-samples)
-   [Google's Sunflower Sample App](https://github.com/android/sunflower)

## ⭐ Stargazers

If you enjoy this project, please give it a star!
Check out all the stargazers
here: [Stargazers on GitHub](https://github.com/NicosNicolaou16/ShipsWithComposeMvvmUIStatesAndRepository/stargazers)


## 🙏 Support & Contributions

This library is actively maintained. Feedback, bug reports, and feature requests are welcome! Please feel free to **open an issue** or submit a **pull request**.