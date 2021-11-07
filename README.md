# stateflow-flow-sharedflow-livedata
Basic app to use different type of observables StateFlow, Flow, SharedFlow, LiveData, State, Channel... 

**StateFlow, Flow, SharedFlow, LiveData**

<a href="https://github.com/raheemadamboev/stateflow-flow-sharedflow-livedata/blob/master/app-debug.apk">Demo app</a> 

**LiveData**

LiveData is an lifecycle aware observable data holder ( means it knows the lifecycle of the activity or an fragment) use it when you play with UI elements(views).

<img src="https://github.com/raheemadamboev/stateflow-flow-sharedflow-livedata/blob/master/screenshot-livedata.gif" alt="Italian Trulli" width="296" height="576">

**StateFlow**

StateFlow(hot stream)  does similar things like LiveData but it is made using flow by kotlin guys and  only difference compare to LiveData is its not lifecycle aware but this is also been solved using repeatOnLifecycle api's, So whatever LiveData can do StateFlow can do much better with power of flow's api. StateFlow won't emit same value.

<img src="https://github.com/raheemadamboev/stateflow-flow-sharedflow-livedata/blob/master/screenshot-stateflow.gif" alt="Italian Trulli" width="296" height="576">

**Flow**

Flow (cold stream) - In general think of it like a stream of data flowing in a pipe with both ends having a producer and consumer running on a coroutine.

<img src="https://github.com/raheemadamboev/stateflow-flow-sharedflow-livedata/blob/master/screenshot-flow.gif" alt="Italian Trulli" width="296" height="576">

**SharedFlow**

SharedFlow(hot stream) - name itself says it is shared, this flow can be shared by multiple consumers, I mean if multiple collect calls happening on the sharedflow there will be a single flow which will get shared across all the consumers unlike normal flow.

<img src="https://github.com/raheemadamboev/stateflow-flow-sharedflow-livedata/blob/master/screenshot-sharedflow.gif" alt="Italian Trulli" width="296" height="576">

**Channel**

SharedFlow as a hot flow will emit data even if no one listening. Channel will hold data till someone consumes it. So if your view not ready to receive an event and sharedFlow emits it, the event will be lost. So channels are better to send one time events. Obviously you can set reply count for shared flow, but then your event will be repeated .

**Tech stack:**

- Dependency Injection (Hilt)
- Kotlin Coroutines
- Flow
- StateFlow
- SharedFlow
- LiveData
- ViewModel
