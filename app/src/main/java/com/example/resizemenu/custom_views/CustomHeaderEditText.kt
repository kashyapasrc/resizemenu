package com.example.resizemenu.custom_views

import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.resizemenu.R


class CustomHeaderEditText @JvmOverloads constructor(
    context: Context, val attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var titleView: TextView
    private lateinit var editTextValue: EditText

    init {
        val view = inflate(context, R.layout.custom_layuot_header_edittext, this)
        titleView = view.findViewById<TextView>(R.id.title)
        editTextValue = view.findViewById<EditText>(R.id.value)
        setXmlValues()
    }

    private fun setXmlValues() {

        val attributeArray: TypedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.CustomHeaderEditText
        )
        if(attributeArray!=null){
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//               val title = attributeArray.getString(R.styleable.CustomHeaderEditText_title);
//                setTitle(title = title)
//            }
//            attributeArray.recycle()

           // setCustomAttributes()
        }

    }

    private fun setCustomAttributes() {
//        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomHeaderEditText_title)
//
//        val n = a.indexCount
//        for (i in 0 until n) {
//            val attr = a.getIndex(i)
//
//        }


    }

    fun setTitle(title: String?) {

        titleView.setText(title)
    }


}