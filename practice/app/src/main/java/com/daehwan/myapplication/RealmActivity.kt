package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.daehwan.myapplication.Android.School
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded() // 데이터베이스에 변경사항이 있으면 다 지우겠다
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        findViewById<Button>(R.id.button_save).setOnClickListener {
            realm.executeTransaction {
                // A테이블에서 데이터를 가져온다
                // B테이블에서 데이터를 가져온다
                // C테이블에서 데이터를 가져온다
                // 조합을 한다
                // D테이블에 저장을 한다
                with(it.createObject(School::class.java)){
                    this.name = "한양 대학교"
                    this.location = "서울"
                }
                with(it.createObject(School::class.java)){
                    this.name = "서울 대학교"
                    this.location = "서울"
                }
            }
        }
        findViewById<Button>(R.id.button_load).setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findAll()
                Log.d("dataa","data : "+ data[0])
            }
        }
        findViewById<Button>(R.id.button_delete).setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }

    }
}