package com.example.submissionexpert1.domain.common

sealed class Result<out T> {
  data object Loading : Result<Nothing>()
  data class Success<T>(val data : T) : Result<T>()
  data class Error(val message : String?) : Result<Nothing>()

}

fun <T> successResult(data : T) : Result<T> {
  return Result.Success(data)
}

fun <T> errorResult(message : String?) : Result<T> {
  return Result.Error(message)
}

