# TimeTasker






# Demo 
![time tasker](https://github.com/ozancanguz/TimeTasker/assets/64928807/7f264a32-c5ec-487d-b1cf-0468b25af508)



# Architecture

This app implements MVVM architecture. App consist of different fragments and 1 root activity. Activity holds a container layout in order to manage fragments which will be controlled by navigation component. Here is the package structure:

![image](https://user-images.githubusercontent.com/64928807/219080594-d41f9c5c-6621-44dd-be6a-7fb2424b9150.png)

Data

Data package should include response models, data source . It shouldn't know any logic.

UI

UI like a feature. It contains Fragments ,viewmodels,  and feature related classes like a domains, mappers and ui models .. Make sure that all classes here are specific to the this feature. If it is a class that is also used in other features, it should be moved to the common package.

Di

This package may actually be inside the common module. But I prefer to carry outside of core package to be more visible.

**Tools that I used** :

- Navigation Component
- Hilt for dependency injection
- Coroutines
- Livedata
- View Binding
- LottieAnimationView
