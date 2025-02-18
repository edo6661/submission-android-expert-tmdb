package com.example.submissionexpert1.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genres")
data class GenreEntity(
  @PrimaryKey
  val genreId : Int,
  val name : String
)