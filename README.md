

# 1. Base

This can be accessed by all modules. Contains utils, abstractions and network calls.

# 2. app

Contains main application and injections. Has access to all modules. 

# 3. albums

Provides albums code and unit tests.

# Gradle

1. config-android.gradle

Contains android configuration.

2. config-properties.gradle

Contains properties that needs to be secured. BASE_URL in this code.

3. dependencies-all.gradle

Contains group of dependencies.

4. dependencies-versions.gradle

Contains dependencies version.

# Libraries Used

1. RxJava
2. Android Architecture Components(AndroidX, Lifecycle, LiveData, ViewModel)
3. Retrofit, OkHttp, Gson
4. Dagger 2 (Dependency Injection)
5. Mockito
6. Junit(For unit tests)
7. Ktlint(For lint fixes)
6. Timber(For Logging)

In case you have any question, please let me know.
