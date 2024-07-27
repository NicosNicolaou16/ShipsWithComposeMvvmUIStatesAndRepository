package com.nicos.ships.compose.ship_details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import com.nick.samplecomposewithhiltandroom.compose.generic_compose_views.CustomToolbar
import com.nicos.ships.R
import com.nicos.ships.compose.generic_compose_views.ShowDialog
import com.nicos.ships.compose.generic_compose_views.StartDefaultLoader
import com.nicos.ships.data.room_database.ships.ShipsModel
import com.nicos.ships.utils.extensions.getProgressDrawable
import kotlinx.coroutines.Dispatchers

const val SHIP_ID_KEY = "ship_id_key"

@Composable
internal fun ShipDetailsScreen(
    shipId: String,
    shipDetailsViewModel: ShipDetailsViewModel = hiltViewModel()
) {
    shipDetailsViewModel.queryShipById(shipId)
    val shipDetailsState = shipDetailsViewModel.shipDetailsState.collectAsState().value
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Color.Gray,
        topBar = {
            CustomToolbar(shipDetailsState.shipModel?.ship_name ?: "")
        },
        content = { paddingValue ->
            if (shipDetailsState.isLoading) StartDefaultLoader()
            if (shipDetailsState.error != null) ShowDialog(
                title = shipDetailsState.error,
                message = ""
            )
            ShipDetailsView(shipDetailsState.shipModel, paddingValue)
        })
}

@Composable
private fun ShipDetailsView(
    shipData: ShipsModel?,
    paddingValues: PaddingValues
) {
    val context = LocalContext.current
    Box(contentAlignment = Alignment.TopCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = ImageRequest.Builder(context = context).apply {
                    data(shipData?.image)
                    scale(Scale.FIT)
                    placeholder(getProgressDrawable(context))
                    error(R.drawable.ic_baseline_image_24)
                    fallback(R.drawable.ic_baseline_image_24)
                    memoryCachePolicy(CachePolicy.ENABLED)
                    dispatcher(Dispatchers.Default)
                }.build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 300.dp)
            )
            BasicInfo(shipData)
        }
    }
}

@Composable
private fun BasicInfo(shipData: ShipsModel?) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(9.dp)
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            androidx.compose.material.Text(
                text = stringResource(R.string.ship_name) + shipData?.ship_name,
                modifier = Modifier.width(width = 300.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 21.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                ),
                color = Color.White,
            )
            androidx.compose.material.Text(
                text = stringResource(R.string.ship_type) + shipData?.ship_type,
                style = TextStyle(
                    fontSize = 21.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            androidx.compose.material.Text(
                text = stringResource(R.string.is_active),
                style = TextStyle(
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .background(if (shipData?.active == true) Color.Green else Color.Red)
            )
        }
    }
}