package com.daehwan.myapplication

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class School: RealmObject() {
    var name : String? = null
    var location : String? = null
}