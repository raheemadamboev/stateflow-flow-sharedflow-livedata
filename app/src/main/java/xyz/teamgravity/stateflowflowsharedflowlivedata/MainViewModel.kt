package xyz.teamgravity.stateflowflowsharedflowlivedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val initialValue = "Hello World!"

    private val _liveData = MutableLiveData(initialValue)
    val liveData: LiveData<String> = _liveData

    private val _stateFlow = MutableStateFlow(initialValue)
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun updateLiveData() {
        _liveData.postValue(getApplication<Application>().applicationContext.resources.getString(R.string.livedata))
    }

    fun updateStateFlow() {
        viewModelScope.launch {
            _stateFlow.emit(getApplication<Application>().applicationContext.resources.getString(R.string.stateflow))
        }
    }

    fun updateFlow(): Flow<String> {
        return flow {
            repeat(5) { count ->
                emit("Hello $count")
                delay(1_000)
            }
        }
    }

    fun updateSharedFlow() {
        viewModelScope.launch {
            _sharedFlow.emit(getApplication<Application>().applicationContext.resources.getString(R.string.sharedflow))
        }
    }
}