# Baut
Stands for 'BA'se 'UT'ility. Base project file needed to make MVVM project with Kotlin and Coroutines. Reference based on company where I work as an intern.

## Branch
- `master` - Base Utility (first 8 commit)
- `rickandmorty-api` - Simple implementation using MVVM App Architecture
  - The app retrieve a list of Character from `Remote API` (https://rickandmortyapi.com/). Retrieved data is stored in `RoomDB` for 5 minutes so if user is closing and re-open the app within 5 minutes, the data will be fetched from `RoomDB`, not from `Remote API`. However the user can force load from Remote API by triggering `onRefresh()`(sliding down the view) in SwipeRefreshLayout. 

## Stack
- AndroidViewModel
- Navigation Component
- Room
- RxJava
- Coroutines
- Retrofit
- Data Binding
- Material Design
- Glide
- Anko
- Espresso
- Mockito

