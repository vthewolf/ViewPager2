package com.example.myapplication

import MyViewPagerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Configurar la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Configurar el SwipeRefreshLayout
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            // Acción que se ejecuta al realizar el gesto de pull-to-refresh
            refreshData()
        }

        // Configuración del ViewPager2 (adaptador y contenido)
        val customers = listOf(
            Customer(
                "Aleix Cruz",
                "https://upload.wikimedia.org/wikipedia/commons/d/d7/Commons_QR_code.png",
                "https://cdn-icons-png.flaticon.com/512/3065/3065699.png"
            ),
            Customer(
                "Belén Cerezo",
                "https://boofcv.org/images/thumb/b/bb/Example_render_microqr.png/400px-Example_render_microqr.png",
                "https://www.iconarchive.com/download/i141851/iconarchive/cute-animal/Cute-Monkey.1024.png"
            ),
            Customer(
                "Víctor Santiago",
                "https://raw.githubusercontent.com/kozakdenys/qr-code-styling/master/src/assets/qr_code_example.png",
                "https://cdn-icons-png.flaticon.com/128/427/427544.png"
            )
        )
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter =
            MyViewPagerAdapter(customers) // Configura tu adaptador personalizado aquí

        // Configurar el WormDotsIndicator con ViewPager2
        val dotsIndicator: WormDotsIndicator = findViewById(R.id.wormDotsIndicator)
        dotsIndicator.attachTo(viewPager)

    }

    private fun refreshData() {
        // Simular una operación de carga (por ejemplo, desde una API) usando corrutinas
        // Este bloque de código se ejecuta de manera asíncrona en segundo plano
        CoroutineScope(Dispatchers.Main).launch {
            // Mostrar el spinner de carga del SwipeRefreshLayout
            swipeRefreshLayout.isRefreshing = true

            // Simular una operación de carga (por ejemplo, una solicitud de red)
            delay(2000) // Simular un retraso de 2 segundos

            // Actualizar los datos o cualquier otra acción que necesites
            // Por ejemplo, aquí podrías actualizar la lista de clientes o refrescar la UI

            // Ocultar el spinner de carga
            swipeRefreshLayout.isRefreshing = false
        }
    }
}
