# Android Kotlin Coroutine 协程演示

## 简介

本 Demo 演示 Kotlin Coroutine 的基本用法，包括协程的创建、切换线程、挂起等。

## 基本原理

### 什么是协程？

协程是 Kotlin 提供的轻量级线程，可以挂起而不阻塞线程。

### 核心概念

1. **CoroutineScope**: 协程作用域
2. **launch**: 启动协程
3. **async/await**: 异步执行并等待结果
4. **withContext**: 切换线程

## 教程

### 1. 基本使用

```kotlin
CoroutineScope(Dispatchers.Main).launch {
    val result = withContext(Dispatchers.IO) {
        // 后台执行
        delay(1000)
        "完成"
    }
    // 更新UI
}
```

### 2. 并行执行

```kotlin
val deferred1 = async { task1() }
val deferred2 = async { task2() }
val result = awaitAll(deferred1, deferred2)
```

## 注意事项

1. 协程比线程更轻量
2. 使用 withContext 切换线程
3. ViewModelScope 自动管理协程生命周期
