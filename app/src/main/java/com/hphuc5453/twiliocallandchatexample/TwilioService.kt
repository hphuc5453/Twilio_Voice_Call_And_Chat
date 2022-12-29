package com.hphuc5453.twiliocallandchatexample

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal object TwilioService {
    const val baseUrl = "https://twiliochatroomaccesstoken-6263.twil.io/"

    @Provides
    internal fun provideObjectMapper(): ObjectMapper {
        return jacksonObjectMapper()
            // set FAIL_ON_UNKNOWN_PROPERTIES to false to prevent JsonMappingException from being thrown when returned response contain
            // unknown properties, default value is true which means any new properties introduced by backend will cause app to break!
            // Refer to: https://stackoverflow.com/a/12730655/1241783
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            // register JavaTimeModule to handle java.time classes such as LocalDateTime
            // Refer to: https://github.com/FasterXML/jackson-modules-java8
            .registerModule(JavaTimeModule())
            // We also need to disable the feature WRITE_DATES_AS_TIMESTAMPS in ObjectMapper to prevent Jackson
            // from adding time digits to the JSON output
            // Refer to: https://www.baeldung.com/jackson-serialize-dates
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    }

    fun getClient(client: OkHttpClient): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create(provideObjectMapper()))
            .client(client)
            .build()
    }
}