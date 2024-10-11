package com.example.boycottapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.boycottapp.R
import com.example.boycottapp.Screan
import com.example.boycottapp.domain.model.Category
import com.example.boycottapp.presentation.about_us_view.AboutPageView
import com.example.boycottapp.presentation.category_filter_product_page_view.view.CategortFilterProductPageView
import com.example.boycottapp.presentation.category_page_view.view.CategoryPageView
import com.example.boycottapp.presentation.home_page_view.view.HomePageView
import com.example.boycottapp.presentation.news_page_view.view.NewsPageView
import com.example.boycottapp.presentation.product_detail_view.ProductDetailPageView
import com.google.gson.Gson
import java.net.URLDecoder

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PageController() {
    val navController = rememberNavController()
    val items = listOf("Anasayfa", "Kategoriler", "Haberler", "Hakkında")
    val currentIndex = remember { mutableStateOf(0) }

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Scaffold(
        content = {
            NavHost(navController = navController, startDestination = Screan.HomePageView.route) {
                composable(Screan.HomePageView.route) {
                    HomePageView(navController = navController)
                }
                composable(Screan.CategoryPageView.route) {
                    CategoryPageView(navController = navController)
                }
                composable(Screan.CategoryFilterProductPage.route+"/{category}",
                    arguments = listOf(
                        navArgument("category"){type= NavType.StringType}
                    )
                ) {
                    val jsonCategory = it.arguments?.getString("category")
                    val decodedJsonCategory = URLDecoder.decode(jsonCategory, "UTF-8")
                    val category = Gson().fromJson(decodedJsonCategory, Category::class.java)
                  CategortFilterProductPageView(
                      onBackPresed = {
                          navController.popBackStack()
                          currentIndex.value=1
                      },
                      category = category)
                }
                composable(Screan.NewsPageView.route) {
                    NewsPageView()
                }
                composable(Screan.AboutPageView.route) {
                    AboutPageView()
                }
                composable(Screan.ProductDetailPageView.route) {
                    ProductDetailPageView {
                        navController.popBackStack()
                        currentIndex.value=0
                    }
                }
            }
        },
        bottomBar = {
            if (currentRoute in listOf(Screan.HomePageView.route, Screan.CategoryPageView.route, Screan.NewsPageView.route, Screan.AboutPageView.route)) {
                NavigationBar{
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = currentIndex.value == index,
                            onClick = {
                                currentIndex.value = index
                                when (index) {
                                    0 -> navController.navigate(Screan.HomePageView.route)
                                    1 -> navController.navigate(Screan.CategoryPageView.route)
                                    2 -> navController.navigate(Screan.NewsPageView.route)
                                    3 -> navController.navigate(Screan.AboutPageView.route)
                                }
                            },
                            label = { Text(text = item) },
                            icon = {
                                when (item) {
                                    "Anasayfa" -> {
                                        Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
                                    }
                                    "Kategoriler" -> {
                                        Icon(painter = painterResource(id = R.drawable.category), contentDescription = "")
                                    }
                                    "Haberler" -> {
                                        Icon(painter = painterResource(id = R.drawable.news), contentDescription = "")
                                    }
                                    "Hakkında" -> {
                                        Icon(painter = painterResource(id = R.drawable.person), contentDescription = "")
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    )
}
