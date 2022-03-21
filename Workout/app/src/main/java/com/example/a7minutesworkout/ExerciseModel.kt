package com.example.a7minutesworkout

class ExerciseModel (
    private var id : Int,
    private var name : String,
    private var image : Int,
    private var isCompleted : Boolean,
    private var isSelected: Boolean
){
    // ID
    fun getId(): Int {
        return id
    }
    fun setId(id: Int){
        this.id = id
    }

    // Name
    fun getname(): String {
        return name
    }
    fun setname(id: String){
        this.name = name
    }

    // Image
    fun getimage(): Int {
        return image
    }
    fun setimage(id: Int){
        this.image = image
    }

    // IsCompleted
    fun getisCompleted(): Boolean {
        return isCompleted
    }

    fun setisCompleted(id: Boolean){
        this.isCompleted = isCompleted
    }
    fun getisSelected(): Boolean {
        return isSelected
    }

    fun setisSelected(id: Boolean){
        this.isSelected = isSelected
    }
}