package com.example.shortcut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

const val staticShortcutAction = "android.intent.action.staticShortcutAction"
const val dynamicShortcutAction = "android.intent.action.dynamicShortcutAction"
const val pinnedShortcutAction = "android.intent.action.pinnedShortcutAction"

class ShortCutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_short_cut)
        val intent = intent;
        print(intent)
        when (intent?.action) {
            staticShortcutAction -> {
                Toast.makeText(this, "静态快捷方式", Toast.LENGTH_SHORT).show()
            }
            dynamicShortcutAction -> {
                Toast.makeText(this, "动态快捷方式", Toast.LENGTH_SHORT).show()
            }
            pinnedShortcutAction -> {
                Toast.makeText(this, "固定快捷方式", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

    }
}