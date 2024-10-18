package com.dumanyusuf.boycottapp.presentation.news_page_view.view


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.dumanyusuf.boycottapp.Screan
import com.dumanyusuf.boycottapp.presentation.news_page_view.NewsViewModel
import com.google.gson.Gson
import java.net.URLEncoder

@Composable
fun NewsPageView(
    viewModel: NewsViewModel= hiltViewModel(),
    navController: NavController,
     curentIndex:MutableState<Int>
) {

    val state=viewModel.state.collectAsState()
    val context= LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.loadNewsBoykot()
    }
    BackHandler {
        curentIndex.value = 0
        navController.navigate(Screan.HomePageView.route) {
            popUpTo(Screan.HomePageView.route) { inclusive = true }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = "Haberler")

            if (state.value.isLoading){
                CircularProgressIndicator(
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
            else{
                LazyColumn (modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 140.dp)){
                    items(state.value.newsList){news->
                        Card (modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(Color.Black)
                            .size(300.dp)){
                           Box {
                               Image(
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .size(300.dp).clickable {
                                           val newsObject = Gson().toJson(news)
                                           val encodedProductObject =
                                               URLEncoder.encode(newsObject, "UTF-8")
                                           navController.navigate(Screan.NewsDetailPage.route+"/$encodedProductObject")
                                       },
                                   contentScale = ContentScale.Crop,
                                   painter = rememberAsyncImagePainter(model =news.newsImage , imageLoader = ImageLoader(context) ) ,
                                   contentDescription = "")

                               Box(
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .align(Alignment.BottomEnd)
                                       .background(Color.Black.copy(alpha = 0.6f))
                                       .padding(8.dp)
                               ){
                                   Text(
                                       modifier = Modifier.align(Alignment.BottomEnd),
                                       color = Color.White,
                                       fontSize = 20.sp,
                                       fontWeight = FontWeight.Bold,
                                       text = news.newsTitle)
                               }

                           }
                        }
                    }

                }
                }
            }
        }
    }