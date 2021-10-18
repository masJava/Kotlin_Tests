package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTests {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun onAttach_Test() {
        assertTrue(presenter.viewIsAttached())
    }

    @Test
    fun onDetach_Test() {
        presenter.onDetach()
        assertFalse(presenter.viewIsAttached())
    }

    @Test
    fun incrementFun_Test() {
        presenter.setCounter(0)
        presenter.onIncrement()
        verify(viewContract, times(1)).setCount(1)
    }

    @Test
    fun decrementFun_Test() {
        presenter.setCounter(0)
        presenter.onDecrement()
        verify(viewContract, times(1)).setCount(-1)
    }
}