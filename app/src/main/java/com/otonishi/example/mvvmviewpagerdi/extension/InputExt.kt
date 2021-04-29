package com.otonishi.example.mvvmviewpagerdi.extension

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorText")
fun TextInputLayout.setTextInputLayoutErrorMessage(errorMessage: String?) {
    this.error = errorMessage
}