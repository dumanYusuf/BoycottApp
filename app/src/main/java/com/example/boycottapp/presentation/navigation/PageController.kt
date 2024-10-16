package com.example.boycottapp.presentation.navigation

import SplashScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.boycottapp.BannerAdView
import com.example.boycottapp.R
import com.example.boycottapp.Screan
import com.example.boycottapp.domain.model.Category
import com.example.boycottapp.domain.model.News
import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.presentation.about_app_page_view.AboutAppPageView
import com.example.boycottapp.presentation.about_us_view.view.AboutPageView
import com.example.boycottapp.presentation.category_filter_product_page_view.view.CategortFilterProductPageView
import com.example.boycottapp.presentation.category_page_view.view.CategoryPageView
import com.example.boycottapp.presentation.contact_us_page_view.ContactUsePageView
import com.example.boycottapp.presentation.donation_page_view.DonationPage
import com.example.boycottapp.presentation.gemini_page_view.GeminiPageView
import com.example.boycottapp.presentation.home_page_view.view.HomePageView
import com.example.boycottapp.presentation.news_page_detail_page.NewsDetailPage
import com.example.boycottapp.presentation.news_page_view.view.NewsPageView
import com.example.boycottapp.presentation.objection_page_view.view.ObjectionPageView
import com.example.boycottapp.presentation.partner_ship_page_view.PartnerShipPageView
import com.example.boycottapp.presentation.product_detail_view.ProductDetailPageView
import com.example.boycottapp.presentation.suggestion_page_view.view.SuggestionPageView
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
            NavHost(
                navController = navController, startDestination = Screan.SplashScreen.route,) {

                composable(Screan.SplashScreen.route) {
                    SplashScreen(navController = navController)
                }

                composable(Screan.HomePageView.route) {
                    HomePageView(navController = navController)
                }
                composable(Screan.CategoryPageView.route) {
                   CategoryPageView(navController = navController, curentIndex = currentIndex)
                }
                composable(Screan.SuggestionPageView.route) {
                    SuggestionPageView(
                        onBackPresed = {
                            navController.popBackStack()
                            currentIndex.value = 3
                        })
                }
                composable(Screan.ObjectionPageView.route) {
                    ObjectionPageView(onBackPresed = {
                        navController.popBackStack()
                        currentIndex.value = 3
                    })
                }
                composable(Screan.AboutAppPageView.route) {
                    AboutAppPageView {
                        navController.popBackStack()
                        currentIndex.value = 3
                    }
                }
                composable(Screan.ContactUsePageView.route) {
                    ContactUsePageView {
                        navController.popBackStack()
                        currentIndex.value = 3
                    }
                }
                composable(Screan.CategoryFilterProductPage.route + "/{category}",
                    arguments = listOf(
                        navArgument("category") { type = NavType.StringType }
                    )
                ) {
                    val jsonCategory = it.arguments?.getString("category")
                    val decodedJsonCategory = URLDecoder.decode(jsonCategory, "UTF-8")
                    val category = Gson().fromJson(decodedJsonCategory, Category::class.java)
                    CategortFilterProductPageView(
                        onBackPressed = {
                            navController.popBackStack()
                            currentIndex.value = 1
                        },
                        navController = navController,
                        category = category
                    )
                }
                composable(Screan.NewsPageView.route) {
                   NewsPageView(navController = navController, curentIndex =currentIndex )
                }
                composable(Screan.NewsDetailPage.route+"/{news}",
                    arguments = listOf(
                        navArgument("news"){type= NavType.StringType}
                    )
                ) {
                    val news = it.arguments?.getString("news")
                    val decodeNews = URLDecoder.decode(news, "UTF-8")
                    val newsHaber = Gson().fromJson(decodeNews, News::class.java)
                    NewsDetailPage(
                        onBackPressed = {
                            navController.popBackStack()
                            currentIndex.value=2
                        }, news =newsHaber )
                }
                composable(Screan.AboutPageView.route) {
                    AboutPageView(navController = navController, curentIndex = currentIndex)
                }
                composable(Screan.GeminiPageView.route) {
                GeminiPageView(onBackPressed = {
                    navController.popBackStack()
                    currentIndex.value=3
                })

                }
                composable(Screan.DonationPageView.route) {
                    DonationPage {
                        navController.popBackStack()
                        currentIndex.value = 3
                    }
                }
                composable(Screan.PartnerShipPageView.route) {
                    PartnerShipPageView {
                        navController.popBackStack()
                        currentIndex.value = 3
                    }
                }
                composable(Screan.ProductDetailPageView.route + "/{product}",
                    arguments = listOf(
                        navArgument("product") { type = NavType.StringType }
                    )
                ) {
                    val jsonCategory = it.arguments?.getString("product")
                    val decodedJsonCategory = URLDecoder.decode(jsonCategory, "UTF-8")
                    val product = Gson().fromJson(decodedJsonCategory, Products::class.java)
                    ProductDetailPageView(
                        onBackPresed = {
                            navController.popBackStack()
                            currentIndex.value = 0
                        }, products = product
                    )
                }
            }
        },
        bottomBar = {
            Column {
                BannerAdView()
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
                                label = { Text(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    text = item) },
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
        }
    )
}
