package support

import retrofit2.HttpException
import com.google.gson.Gson


class ApiError constructor(error: Throwable) {
    var message = "An error occurred"
    var code = ""
    var field_errors = ""

    init {
        if (error is HttpException) {
            val errorJsonString = error.response()
                .errorBody()?.string()

            if (errorJsonString != null) {
                val gson = Gson()
                val errorResponse = gson.fromJson(errorJsonString, ApiError::class.java)
               
            }
        } else {
            this.message = error.message ?: this.message
        }
    }
}