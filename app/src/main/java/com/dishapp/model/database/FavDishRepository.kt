package com.dishapp.model.database

import androidx.annotation.WorkerThread
import com.dishapp.model.entities.FavDish
import kotlinx.coroutines.flow.Flow

class FavDishRepository(private val favDishDao: FavDishDao) {


    @WorkerThread
    suspend fun insertFavDishData(favDish: FavDish) {
        favDishDao.insertFavDishDetails(favDish)
    }

    val allDishesList: Flow<List<FavDish>> = favDishDao.getAllDishesList()

    @WorkerThread
    suspend fun updateFavDishData(favDish: FavDish) {
        favDishDao.updateFavDishDetails(favDish)
    }

    val favoriteDishes: Flow<List<FavDish>> = favDishDao.getFavoriteDishesList()

    @WorkerThread
    suspend fun deleteFavDishData(favDish: FavDish) {
        favDishDao.deleteFavDishDetails(favDish)
    }

    fun filteredListDishes(value: String): Flow<List<FavDish>> =
        favDishDao.getFilteredDishesList(value)

    @WorkerThread
    suspend fun dishesList(): Flow<List<FavDish>> = favDishDao.getDishesList()
}