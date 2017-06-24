package com.example.vb.kotlincalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //ekrana ilk girilen ve herhangi bir toplama çıkarma
    //isteği olmadan önceki sayı1
    var numbers1 :Double? = null

    //ekranda  işlem seçildikten sonraki değer
    var numbers2 :Double? = null

    //hangi işlemi seçtiğimizi gösteren değişken toplama çıkarma çarpma gibi
    var operations : String ? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun  btn_number_clicked(view: View ){
        val clickedbtn = view as Button;
        //başlangıçtaki değer
        var clickedBtnNumber:String = et_numbers.text.toString()

        when(clickedbtn.id){

            //hangi butona tıklandıysa kafasında o değeri tutuyoruz
            R.id.btn_0 -> { clickedBtnNumber+= "0"}
            R.id.btn_1 -> { clickedBtnNumber+= "1"}
            R.id.btn_2 -> { clickedBtnNumber+= "2"}
            R.id.btn_3 -> { clickedBtnNumber+= "3"}
            R.id.btn_4 -> { clickedBtnNumber+= "4"}
            R.id.btn_5 -> { clickedBtnNumber+= "5"}
            R.id.btn_6 -> { clickedBtnNumber+= "6"}
            R.id.btn_7 -> { clickedBtnNumber+= "7"}
            R.id.btn_8 -> { clickedBtnNumber+= "8"}
            R.id.btn_9 -> { clickedBtnNumber+= "9"}
            R.id.btn_point -> { clickedBtnNumber+= "."}

        }
        //en son hangi numaraya tıklandıysa edittext'imize atıyoruz
        et_numbers.setText(clickedBtnNumber)
    }

    fun btn_oparetor_clicked(view:View){
        val opeatorClick = view as Button

        when(opeatorClick.id){

            //eğer temizlik butonuna basarsa clear fonksiyonu çağırıp edittexti temizliyor
            R.id.btn_AC -> { clear()}

            //yüzde ve kök işlemlerini eklemedik şunalık
            R.id.btn_value -> {
            }
            R.id.btn_percent -> {
            }

            //bölme buttonuna basıldığında çalışan metodumuz
            R.id.btn_division -> {
                //ekrandaki değeri numbers1 e atıyor ve ardından
                //bölme butonu olduğundan  aklına / işaretini alıyor
                //clear ile edittexti temziliyor

                numbers1= et_numbers.text.toString().toDouble()
                operations="/"
                clear()

            }

            R.id.btn_extraction -> {
                numbers1= et_numbers.text.toString().toDouble()
                
                operations="-"
                clear()
            }

            R.id.btn_sum -> {
                numbers1= et_numbers.text.toString().toDouble()
                operations="+"
                clear()
            }

            R.id.btn_multiplication -> {
                numbers1= et_numbers.text.toString().toDouble()
                operations="*"
                clear()

            }
            R.id.btn_eqauls -> {

                //eğer direk bir sayı girilmeden = veya  işlem seçmeden yapılırsa hata döndüryourz
                if (numbers1==null)  Toast.makeText(this,"Hata işlemi seçiniz",Toast.LENGTH_SHORT)
                else  {
                    //kişi ilk sayıyı girip sonra  işlemi seçip = buttonuna bastığında
                    //numbers iki içersinde = bastığı andaki sayıyı kafasına tutuyor
                    numbers2= et_numbers.text.toString().toDouble()

                    when(operations){
                            //gelen  işleme göre yapıp onuda ekrana basıyor
                        "/"   ->  {  et_numbers.setText("${numbers1!! / numbers2!!}") }
                        "*"   ->  { et_numbers.setText("${numbers1!! * numbers2!!}")}
                        "+"  ->  {  et_numbers.setText("${numbers1!! + numbers2!!}")}
                        "-"  ->  { et_numbers.setText("${numbers1!! - numbers2!!}")}
                    }

                }

            }


        }
    }

    private fun clear() {
        et_numbers.setText("")
    }
}



