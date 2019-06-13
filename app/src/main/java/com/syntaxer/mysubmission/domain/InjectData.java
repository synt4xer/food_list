package com.syntaxer.mysubmission.domain;

import java.util.ArrayList;

/**
 * Created by Android Studio.
 * User: FERREL JOHN FERNANDO
 * Date: 12/06/2019.
 * Time: 11:28.
 * To change this template use File | Settings | File and Code Templates.
 */
public class InjectData {
    private static String[][] data = new String[][] {
            {"Mie Aceh", "Mie Khas Aceh", "https://alidesta.files.wordpress.com/2015/04/mie-aceh1.jpg", "Mie Aceh sangat jelas berasal dari daerah Aceh. Bahan dasar makanan ini adalah berasal dari mie kuning tebal dengan diirisi daging sapi, daging kambing yang disajikan dalam bentuk sup dengan kuah sejenis kari yang gurih serta pedas.", "Aceh"},
            {"Bika Ambon", "Makanan Khas Medan", "https://alidesta.files.wordpress.com/2015/04/bika-ambon.jpg", "Bika Ambon adalah makanan khas Indonesia dari daerah Medan, Sumatera Utara. Bika ini terbuat dari berbagai bahan seperti telur, gula serta santan yang umumnya beraroma pandan wangi.", "Medan"},
            {"Rendang", "Makanan Khas Padang", "https://alidesta.files.wordpress.com/2015/04/rendang.jpg", "Rendang makanan khas Indonesia yang berasal dari daerah Padang, Sumatera Barat. Rendang ini merupakan salah satu masakan tradisional Minangkabau yang menggunakan daginf dan santan kelapa sebagai bahan dasarnya.", "Padang"},
            {"Gulai Ikan Patin Jambi", "Makanan Khas Jambi", "https://alidesta.files.wordpress.com/2015/04/gulai-ikan-patin.jpg", "Masakan Khas Indonesia ini berasal dari daerah Jambi. Gulai Ikan Patin dimasak dengan menggunakan tempoyak, yaitu daging buah durian yagn sudah difermentasi. Namun ada juga banyak orang yang memasak Gulai Ikan Patin yang mengganti tempoyak dengan santan kelapa.", "Jambi"},
            {"Pendap Bengkulu", "Makanan Khas Bengkulu", "https://asset-a.grid.id//crop/0x0:0x0/700x465/photo/bobofoto/original/22471_nikmatnya-pendap-sajian-khas-bengkulu.jpg", "Pendap merupakan salah satu masakan khas Indonesia dari daerah Bengkulu. Pendap terbuat dari bumbu-bumbu yang beraneka ragam seperti bawang putih, kencur serta cabai giling. Kemudian bahan-bahan tersebut dicampur merata dengan parutan kelapa muda.", "Bengkulu"},
            {"Pempek Palembang", "Makanan Khas Palembang", "https://alidesta.files.wordpress.com/2015/04/empek-empek.jpg", "Empek-empek atau sering dinamakan dengan sebutan pempek merupakan makanan khas Indonesia yang berasal dari daerah Palembang, Sumatera Selatan. Makanan khas ini umumnya terbuat dari ikan dan sagu.", "Palembang"},
            {"Kerak Telor Jakarta", "Makanan Khas Jakarta", "https://alidesta.files.wordpress.com/2015/04/keraktelor.jpg", "Makanan khas dari Jakarta yang satu ini sebenarnya merupakan perpaduan dari kuliner Portugis. Kerak telor mudah ditemui di Jakarta terutama pada saat diadakannya  Pekan Raya Jakarta bahkan kerak telor acap kali dijadikan simbol kuliner klasik budaya Betawi.", "Jakarta"},
            {"Gudeg Yogyakarta", "Makanan Khas Yogyakarta", "https://alidesta.files.wordpress.com/2015/04/gudeg-jogja.jpg", "Gudeg merupakan kuliner yang tidak bisa dipisahkan dengan kota Yogyakarta bahkan sampai-sampai Yogyakarta memiliki julukan sebagai kota Gudeg. Gudeg asli Yogyakarta memiliki rasa yang sangat manis. Gudeg terbuat dari sayur nangka muda bersantan yang biasa dinikmati dengan nasi, ayam kampung, dan telur kecap.", "Yogyakarta"}
    };

    public static ArrayList<Food> getData() {
        Food mFood;
        ArrayList<Food> list = new ArrayList<>();
        for (String[] mData : data) {
            mFood = new Food();
            mFood.setName(mData[0]);
            mFood.setDesc(mData[1]);
            mFood.setPhoto(mData[2]);
            mFood.setRemarks(mData[3]);
            mFood.setSourceName(mData[4]);

            list.add(mFood);
        }

        return list;
    }
}
