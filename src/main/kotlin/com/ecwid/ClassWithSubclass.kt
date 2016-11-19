package com.ecwid

/**
 * Created by aleksandr on 16.11.16.
 */
class ClassWithSubclass {

    private var propertyInt1: Int = 1

    private val propertyIntVal1: Int = 1

    private var collectionInt = mutableListOf(1, 2, 3, 4, 5)

    private val collectionIntVal = mutableListOf(1, 2, 3, 4, 5)

    private var subClass = SubClass(2, mutableListOf(6, 7, 8, 9, 0))

    constructor()

    constructor(propertyInt1: Int, CollectionInt: MutableList<Int>) {
        this.propertyInt1 = propertyInt1
        this.collectionInt = CollectionInt
    }

    constructor(subClass: SubClass){
        this.subClass = subClass
    }

    public class SubClass {

        constructor()

        public constructor(subPropInt1: Int, subCollectionInt: MutableList<Int>) {
            this.subPropInt1 = subPropInt1
            this.subCollectionInt = subCollectionInt
        }

        private var subPropInt1: Int = 1

        private val subPropIntVal1: Int = 1

        private var subCollectionInt = mutableListOf(1, 2, 3, 4, 5)

        private val subCollectionIntVal = mutableListOf(1, 2, 3, 4, 5)
    }
}