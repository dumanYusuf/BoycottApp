package com.example.boycottapp.presentation.category_page_view.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.presentation.category_page_view.CategoryViewModel

@Composable
fun CategoryPageView(
    viewModel: CategoryViewModel= hiltViewModel(),
    //products: Products
) {

    LaunchedEffect(key1 = true) {
        viewModel.loadCategory()
    }

    val state=viewModel.state.collectAsState()
    val context= LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
       Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
           Text(
               modifier = Modifier.padding(top = 50.dp),
               color = MaterialTheme.colorScheme.onBackground,
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold,
               text = "Kategoriler")
           Spacer(modifier = Modifier.padding(10.dp))
           LazyVerticalGrid(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(bottom = 140.dp),
               columns = GridCells.Fixed(2)) {
               items(state.value.categorytList){categoryList->
                   Card(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(5.dp)
                           .size(250.dp)) {
                       Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
                           Image(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .size(150.dp),
                               contentScale = ContentScale.Crop,
                               painter = rememberAsyncImagePainter(model = categoryList.categoryImage,
                                   imageLoader = ImageLoader(context) ),
                               contentDescription ="" )
                           Spacer(modifier = Modifier.padding(5.dp))

                           Text(
                               color = MaterialTheme.colorScheme.onBackground,
                               fontSize = 20.sp,
                               fontWeight = FontWeight.Bold,
                               text = categoryList.categoryName)
                           Spacer(modifier = Modifier.padding(5.dp))
                           Text(
                               color = MaterialTheme.colorScheme.onBackground,
                               fontSize = 20.sp,
                               fontWeight = FontWeight.Bold,
                               text = "${categoryList.categoryName.count()} Marka")
                       }
                   }
               }
           }

       }
    }
}