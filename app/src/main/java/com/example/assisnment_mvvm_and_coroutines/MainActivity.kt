package com.example.assisnment_mvvm_and_coroutines

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.assisnment_mvvm_and_coroutines.models.Article
import com.example.assisnment_mvvm_and_coroutines.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var articleList: List<Article>? = null
    private var mainViewModel: MainViewModel? = null
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel?.init()

        coroutineScope.launch {
            articleList = getArticleList()
            Toast.makeText(this@MainActivity, "Article list size " + articleList?.size, Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun getArticleList(): List<Article>? = withContext(Dispatchers.IO){
        mainViewModel?.getHeadlines("us")?.body()?.articles
    }
}