package com.ecwid

/**
 * Created by aleksandr on 14.11.16.
 */

class Class1 {

     var property1: Int = 1
        get
        private set (value) {
            field = value
        }

    constructor(){
    }

    constructor(property1: Int) {
        this.property1 = property1
    }


}
