package com.ecwid

/**
 * Created by aleksandr on 16.11.16.
 */
class ClassWithSubclass {

    private var propertyInt1: Int = 1

    private val propertyIntVal1: Int = 1

    private var CollectionInt = mutableListOf(1, 2, 3, 4, 5)

    private val CollectionIntVal = mutableListOf(1, 2, 3, 4, 5)

    constructor()

    constructor(propertyInt1: Int, CollectionInt: MutableList<Int>) {
        this.propertyInt1 = propertyInt1
        this.CollectionInt = CollectionInt
    }

    class SubClass {

        constructor()

        constructor(subPropInt1: Int, subCollectionInt: MutableList<Int>) {
            this.subPropInt1 = subPropInt1
            this.subCollectionInt = subCollectionInt
        }

        private var subPropInt1: Int = 1

        private val subPropIntVal1: Int = 1

        private var subCollectionInt = mutableListOf(1, 2, 3, 4, 5)

        private val subCollectionIntVal = mutableListOf(1, 2, 3, 4, 5)
    }
}