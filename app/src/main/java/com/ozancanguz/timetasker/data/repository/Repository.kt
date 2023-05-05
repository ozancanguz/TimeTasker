package com.ozancanguz.timetasker.data.repository

import com.ozancanguz.timetasker.data.local.LocalDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor( localDataSource: LocalDataSource) {

    val local=localDataSource
}