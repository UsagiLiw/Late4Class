package com.example.late4class

import com.example.late4class.Class_module.ClassList
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.internal.configuration.MockAnnotationProcessor

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Mock
    private lateinit var welcome: welcome
    private lateinit var login: MainActivity
    private lateinit var Class: ClassList

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        welcome = welcome()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
