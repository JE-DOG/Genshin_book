object Dependencies {

    object Compose {
        const val version = "1.4.3"

        const val ui = "androidx.compose.ui:ui:$version"
        const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val ui_tooling = "androidx.compose.ui:ui-tooling:$version"
        const val ui_test_junit4 = "androidx.compose.ui:ui-test-junit4:$version"
        const val ui_test_manifest = "androidx.compose.ui:ui-test-manifest:$version"

        object Material2 {
            const val version = "1.4.3"

            const val material2 = "androidx.compose.material:material:$version"
        }

        object Material3 {
            const val version = "1.1.1"

            const val material3 = "androidx.compose.material3:material3:$version"
        }
        
        object LiveData {
            const val version = "1.6.0-alpha01"
            
            const val runtime = "androidx.compose.runtime:runtime-livedata:$version"
        }
        object Navigation {
            
            object Voyager {
                const val version = "1.0.0-rc05"
                
                const val navigator = "cafe.adriel.voyager:voyager-navigator:$version"
                const val tab_navigator = "cafe.adriel.voyager:voyager-tab-navigator:$version"
            }
            
        }
    }

    object XML {
        object Material2 {
            const val version = "1.9.0"

            const val material2 = "com.google.android.material:material:$version"
        }

        object Material3 {
            const val version = "1.1.1"

            const val material3 = "androidx.compose.material3:material3:$version"
        }

        object Navigation {

            object Cicerone {
                const val version = "7.1"

                const val cicerone = "com.github.terrakok:cicerone:$version"
            }

        }

        object AppCompat {
            const val version = "1.6.1"

            const val app_compat = "androidx.appcompat:appcompat:$version"
        }
    }

    object AndroidX {

        object LifeCycle{
            const val version = "2.6.1"

            const val runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewmodel_compose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

        object Core {
            const val version = "1.10.1"

            const val ktx = "androidx.core:core-ktx:$version"
        }

        object Activity {
            const val version = "1.7.2"

            const val compose = "androidx.activity:activity-compose:$version"
            const val xml ="androidx.activity:activity-ktx:$version"
        }

        object Fragment {
            const val version = "1.6.1"

            const val xml = "androidx.fragment:fragment-ktx:$version"
        }

    }

    object Kotlin {
        const val version = "1.7.1"

        const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }

    object Test {
        object AndroidX {
            object Espresso {
                const val version = "3.5.1"
                
                const val core = "androidx.test.espresso:espresso-core:$version"
            }
            
            object Core {
                const val version = "2.2.0"
                
                const val core_testing = "androidx.arch.core:core-testing:$version"
            }
            
        }

        object Coroutine {
            const val version = "1.7.1"

            const val coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
        
        object Mockito {
            const val version = "4.0.0"
            
            const val core = "org.mockito:mockito-core:$version"
            const val kotlin = "org.mockito.kotlin:mockito-kotlin:$version"
            const val inline = "org.mockito:mockito-inline:$version"
        }
        
        object Junit {
            const val junit_version = "4.13.2"
            const val ext_junit_version = "1.1.5"
            
            const val junit = "junit:junit:$junit_version"
            const val ext_junit = "androidx.test.ext:junit:$ext_junit_version"
        }

    }

    object Another {
        object Database {

            object Realm {
                const val version = "1.10.1"

                const val base = "io.realm.kotlin:library-base:$version"
            }

        }

        object MultiThreading {

            object RxJava2 {

                const val version = "2.2.9"

                const val android= "io.reactivex.rxjava2:rxandroid:$version"
                const val rxJava= "io.reactivex.rxjava2:rxjava:$version"

            }
        }
        
        object Network {
            object Retrofit {
                const val version = "2.9.0"
                
                const val gson = "com.squareup.retrofit2:converter-gson:$version"
                const val retrofit = "com.squareup.retrofit2:retrofit:$version"
                const val rx_java_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
            }
            
            object OkHttp {
                const val version = "4.10.0"
                
                const val okhttp = "com.squareup.okhttp3:okhttp:$version"
                const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
            }

            object Supabase {
                private const val version = "1.2.0"
                const val bom = "io.github.jan-tennert.supabase:bom:$version"

                const val postgrest = "io.github.jan-tennert.supabase:postgrest-kt"
                const val realtime = "io.github.jan-tennert.supabase:realtime-kt"
            }

            object Ktor {
                const val version = "2.3.2"
                const val engine = "okhttp"

                const val ktor = "io.ktor:ktor-client-$engine:$version"
            }
        }
        
        object DI {
            
            object Dagger {
                const val version = "2.44.2"
                
                const val dagger = "com.google.dagger:dagger:$version"
                const val compiler = "com.google.dagger:dagger-compiler:$version"
            }
            
        }

        object PictureLoader {

            object Coil {
                const val version_coil = "2.4.0"

                const val coil_xml = "io.coil-kt:coil:$version_coil"
                const val coil_compose = "io.coil-kt:coil-compose:$version_coil"
            }

        }

    }

}