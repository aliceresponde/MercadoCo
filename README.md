# Alicia Beltran - Android Dev - CO

Example app with latest development standards in Android SDK and Kotlin

# Description
- MerCo is a single activity application that uses open MercadoLibre's API's to search items available in Colombia, and show related details.
- Splash screen - Simple intro that shows a lottie animation
- Search Item screen - Search field to request items, and shows the  result
- The app require internet access but  identify when connection is not able.

# Technologies and techniques
- [MVVM] - MVVM architecture with Clean and Repository.
- [Kotlin] - Code language.
- [Hilt] - Dependency injection for effective layers separation and total independence of components (experimental Google alternative as Dagger II wraper).
- [Kotlin Coroutines] - Asynchronous tasks management.
- [LiveData] - For communication between components through the Observer pattern.
- [Navigation] - For navigation between views.
- [Coil] - An image loading and caching library.
- [Retrofit] y [GSON] - For Rest API consume.
- [mancj/MaterialSearchBar] - Custom search bar based on material design
- [Lottie] - Animation and Interactive Design
- -[Image Indicator] - Complement to View Pager, as indicator of content.

# Application layers : Here all layers use interfaces to represent abstractions an contracts to emable UnitTest and made maintainable code
[![Layers](https://s17-us2.startpage.com/cgi-bin/serveimage?url=https:%2F%2Fcdn-images-1.medium.com%2Fmax%2F1200%2F1*Tt_OwtZJ993YzswuRyPQiA.png&sp=66100abec54b20aa81cadfed15aaf880)]

#### Detailed explanation and responsibility of relevant classes
-  **Views (ui package):** `MainActivity` render the app and initialize Navigator.
-  **ViewModels (ui package):** `SearchViewModel` and `DetailViewModel` classes. One per screen (Simple response)
-  **Repository (data.repository package):** `Items and Details repositories`.
-  **Use case: Domain logic**
-  **Remote Data Source (data.network package):** `ApliService` has the endpoints config. `DataSource` is the data source interface and `Concrete implementation` its implementation.

## ToDo
- Add unit tests - Its not enable with hills

License
----
MIT

[MVVM]: <https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel>
[Kotlin]: <https://kotlinlang.org/>
[Dagger Hilt]: <https://dagger.dev/hilt/migration-guide.html>
[Kotlin Coroutines]: <https://kotlinlang.org/docs/reference/coroutines-overview.html>
[LiveData]: <https://developer.android.com/topic/libraries/architecture/livedata>
[Navigation]: <https://developer.android.com/guide/navigation>
[Coil]: <https://github.com/coil-kt/coil>
[Retrofit]: <https://square.github.io/retrofit/> most popular dependency to manage REST API
[Okhttp]: <https://square.github.io/okhttp/>     Complemet with retrofit and REST   
[GSON]: <https://github.com/google/gson>         Most Popular Json dependency to parse server JsonResponse into POJO (data class)   
[mancj]: <https://github.com/mancj/MaterialSearchBar> Recomended search bar
[Lottie]: <https://lottiefiles.com/22620-store>. Elegant, simple and popular animation dependency used by Huge companies as AirBnB, Tinder
[CircleIndicator]: <https://github.com/ongakuer/CircleIndicator>  Complement viewPagger
