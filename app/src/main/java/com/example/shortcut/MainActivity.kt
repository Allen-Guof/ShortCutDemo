package com.example.shortcut

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent;
        print(intent)
        val context = this
        findViewById<View>(R.id.btn_hello).setOnClickListener {
            Toast.makeText(context, "创建动态快捷方式", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, ShortCutActivity::class.java)
            intent.action = dynamicShortcutAction
            val shortcut = ShortcutInfoCompat.Builder(context, "id1")
                .setShortLabel("动态快捷方式")
                .setLongLabel("动态快捷方式Long")
                .setIcon(IconCompat.createWithResource(context, R.mipmap.ic_launcher))
                .setIntent(
                    intent
                )
                .build()
            ShortcutManagerCompat.pushDynamicShortcut(context, shortcut)
        }

        findViewById<View>(R.id.btn_pinned_shortcut).setOnClickListener {

            val intent = Intent(context, ShortCutActivity::class.java)
            intent.action = dynamicShortcutAction
            val shortcut = ShortcutInfoCompat.Builder(context, "id2")
                .setShortLabel("固定快捷方式")
                .setLongLabel("固定快捷方式Long")
                .setIcon(IconCompat.createWithResource(context, R.mipmap.ic_launcher))
                .setIntent(
                    intent
                )
                .build()
//            ShortcutManagerCompat.pushDynamicShortcut(context, shortcut)
            if(!ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
                Toast.makeText(context, "app not supported pinned short cuts", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            ShortcutManagerCompat.requestPinShortcut(context,shortcut, null)
        }
    }
}