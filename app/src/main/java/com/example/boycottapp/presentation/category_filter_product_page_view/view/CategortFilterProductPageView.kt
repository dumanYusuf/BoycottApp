package com.example.boycottapp.presentation.category_filter_product_page_view.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.boycottapp.R
import com.example.boycottapp.domain.model.Category
import com.example.boycottapp.presentation.category_filter_product_page_view.CategoryFilterProductViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategortFilterProductPageView(
    viewModel: CategoryFilterProductViewModel= hiltViewModel(),
    onBackPresed:()->Unit,
    category:Category
) {

    val state=viewModel.state.collectAsState()
    val context= LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.loadCategoryFilterProduct(category.categoryId)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { onBackPresed() }) {
                           Icon(painter = painterResource(id = R.drawable.back), contentDescription ="" )
                        }
                        Text(
                            color =MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(10.dp),
                            text = category.categoryName
                        )
                    }
                }
            })
        },


        content = {innrrPadding->

            if (state.value.isLoading){
                CircularProgressIndicator(
                    color = Color.Red,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
            else{
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innrrPadding),
                    columns = GridCells.Fixed(2)) {
                    items(state.value.productList){productList->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                                .size(250.dp)) {
                            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop,
                                    painter = rememberAsyncImagePainter(model = productList.productImage,
                                        imageLoader = ImageLoader(context) ),
                                    contentDescription ="" )
                                Spacer(modifier = Modifier.padding(5.dp))
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = when (productList.productStatus) {
                                                "Boykot" -> Color.Red.copy(alpha = 0.3f)
                                                "Uygun" -> Color.Blue.copy(alpha = 0.3f)
                                                else -> Color.Gray.copy(alpha = 0.3f)
                                            },
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(8.dp)
                                ) {
                                    Text(
                                        color = when (productList.productStatus) {
                                            "Boykot" -> Color.Red
                                            "Uygun" -> Color.Blue
                                            else -> Color.Black
                                        },
                                        fontSize = 20.sp,
                                        text = productList.productStatus
                                    )
                                }
                                Spacer(modifier = Modifier.padding(5.dp))
                                Text(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    text = productList.productName)
                            }
                        }
                    }
                }
            }

        }
    )
}