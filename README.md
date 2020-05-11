# Kotlin HTTP request example 
**IGNORE MASTER BRANCH, GO STRAIGHT TO `rickandmorty-api` branch for the example**

## Branch
- `rickandmorty-api` - Simple implementation using MVVM App Architecture
  - The app retrieve a list of Character from `Remote API` (https://rickandmortyapi.com/). Retrieved data is stored in `RoomDB` for 5 minutes so if user is closing and re-open the app within 5 minutes, the data will be fetched from `RoomDB`. However the user can force load from `Remote API` by triggering `onRefresh()`(sliding down the view) in SwipeRefreshLayout. 

## Stack
- AndroidViewModel
- Navigation Component
- Room
- RxJava
- Coroutines
- Retrofit
- Data Binding
- Glide
- Anko
