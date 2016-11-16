package com.ecwid

/**
 * Created by aleksandr on 16.11.16.
 */
class ClassCollection {
    private val collectionIntVal = listOf(1, 2, 3, 4, 5)

    private var collectionInt = mutableListOf(1, 2, 3, 4, 5)
        private set(value) {
            field = value
        }



    constructor(collectionInt: MutableList<Int>) {
        this.collectionInt = collectionInt
    }

    constructor()
}