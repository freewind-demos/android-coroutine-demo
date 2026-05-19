package demos.android.coroutine.demo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

/**
 * Kotlin Coroutine 协程演示
 * 展示协程的基本用法
 */
class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.resultText)

        findViewById<Button>(R.id.startBtn).setOnClickListener {
            startCoroutine()
        }
    }

    private fun startCoroutine() {
        resultText.text = "开始执行..."
        // 在协程中执行耗时操作
        CoroutineScope(Dispatchers.Main).launch {
            val result = withContext(Dispatchers.IO) {
                // 模拟网络请求
                delay(2000)
                "任务完成"
            }
            resultText.text = result
        }
    }
}
