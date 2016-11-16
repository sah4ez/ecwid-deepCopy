package com.ecwid

/**
 * Created by aleksandr on 14.11.16.
 */

class ClassProperty {

    private var propertyInt1: Int = 1
        private set (value) {
            field = value
        }

    private var propertyInt2: Int = 1
        private set (value) {
            field = value
        }

    private var propertyString1: String = "first"
        private set (value) {
            field = value
        }

    private val propertyIntVal: Int = 1

    private val propertyStringVal: String = "val"

    constructor() {
    }

    constructor(property1: Int) {
        this.propertyInt1 = property1
    }

    constructor(propertyInt1: Int, propertyInt2: Int, propertyString1: String) {
        this.propertyInt1 = propertyInt1
        this.propertyInt2 = propertyInt2
        this.propertyString1 = propertyString1
    }


}
