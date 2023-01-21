package com.rxyzent.foodapp.core.dataProvider.db

import androidx.room.*
import com.rxyzent.foodapp.core.model.db.Favorite


@Dao
interface DbDao {

    @Query("SELECT * FROM favorite_table")
    fun getAllData(): List<Favorite>

    @Insert(entity = Favorite::class, onConflict = OnConflictStrategy.REPLACE)
    fun addMeal(meal: Favorite)

    @Insert(entity = Favorite::class, onConflict = OnConflictStrategy.REPLACE)
    fun addMeals(vararg meal: Favorite)

    @Delete(entity = Favorite::class)
    fun deleteMeal(meal: Favorite)

    @Update(entity = Favorite::class)
    fun updateData(meal: Favorite)

    @Query("SELECT * FROM favorite_table WHERE id LIKE :number")
    fun searchMealsById(number: String): List<Favorite>

    @Query("SELECT * FROM favorite_table WHERE id LIKE :number LIMIT 1")
    fun searchMealById(number: String): Favorite

}