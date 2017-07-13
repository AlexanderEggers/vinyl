package com.acando.vinyl.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "shopping_cart")
class ShoppingCart {

    @PrimaryKey
    var id: Int = 0
    var itemId: Int = 0
}