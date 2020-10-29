package com.binar.roomsynrgy.main

import com.binar.roomsynrgy.db.Item
import com.binar.roomsynrgy.db.ItemDatabase
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainActivityPresenterTest {
    lateinit var presenter: MainActivityPresenter

    @Mock
    lateinit var listener: MainActivityPresenter.Listener

    @Mock
    lateinit var db: ItemDatabase


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainActivityPresenter(db, listener)
    }

    @Test
    fun goToAddActivity() {
        presenter.goToAddActivity()
        Mockito.verify(listener).goToAddActivity()
    }

    @Test
    fun gotoEditActivity() {

        val item = Item(null,"Test",1)
        presenter.goToEditActivity(item)

        Mockito.verify(listener).goToEditActivity(item)
    }

//    @Test
//    fun deleteItemFailed(){
//        val item = Item(99,"Test",1)
//        presenter.deleteItem(item)
//
//        Mockito.verify(listener).showDeletedFailed(item)
//    }
}